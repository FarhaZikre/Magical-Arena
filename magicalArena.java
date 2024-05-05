import java.util.*;

class magicalArena {

    static Random random = new Random();

    public static int rollDice() {
        return random.nextInt(6) + 1; // 1 to 6 sided dice
    }

    public static int fight(int attackerAttack, int defenderStrength) {
        int attackerRoll = rollDice();
        int defenderRoll = rollDice();

        System.out.print("Attacker Roll Dice:" + attackerRoll);
        System.out.print("\tDefender Roll Dice:" + defenderRoll+"\n");

        int attackDamage = attackerAttack * attackerRoll;
        int defendingStrength = defenderStrength * defenderRoll;

        // does not take negative value in damageTaken
        int damageTaken = Math.max(0, attackDamage - defendingStrength);
        return damageTaken;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        //taking player A input from user
        System.out.println("Enter player A's Details:");
        System.out.println("Enter A's Health:");
        int player_A_Health = sc.nextInt();
        System.out.println("Enter A's Strength:");
        int player_A_Strength = sc.nextInt();
        System.out.println("Enter A's Attack:");
        int player_A_Attack = sc.nextInt();

        System.out.println("= = = = = = = = = = = = = = = = = = = = =");

        //taking player A input from user
        System.out.println("Enter player B's Details:");
        System.out.println("Enter B's Health:");
        int player_B_Health = sc.nextInt();
        System.out.println("Enter B's Strength:");
        int player_B_Strength = sc.nextInt();
        System.out.println("Enter B's Attack:");
        int player_B_Attack = sc.nextInt();

        //Determine which player attacks first based on lower health
        String current_Attacker;
        
        if (player_A_Health < player_B_Health) {
            current_Attacker = "Player A";
        } 
        else {
            current_Attacker = "Player B";
        }

        //Turn-based playing
        while (player_A_Health > 0 && player_B_Health > 0) {
            int damage_taken;
            //Attacker and Defender are switched after each turn
            if (current_Attacker.equals("Player A")) {
                System.out.println("Player A is Attacker and B is Defender");
                damage_taken = fight(player_A_Attack, player_B_Strength);
                player_B_Health -= damage_taken;
                System.out.println("Player A attacks. Player B's health reduced to " + player_B_Health+"\n");
                current_Attacker = "Player B";
            } 

            else {
                System.out.println("Player B is Attacker and A is Defender");
                damage_taken = fight(player_B_Attack, player_A_Strength);
                player_A_Health -= damage_taken;
                System.out.println("Player B attacks. Player A's health reduced to " + player_A_Health+"\n");
                current_Attacker = "Player A";
            }
        }

        //game ends if any players health reduced to 0
        if (player_A_Health <= 0) {
            System.out.println("\n! Player B wins !");
        }
        if (player_B_Health <= 0) {
            System.out.println("\n! Player A wins !");
        }

        sc.close();
    }
}
