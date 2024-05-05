import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.*;

public class magicalArenaTest {

    @Test
    public void testFightWithZeroAttackerAttack() {
        // Test fight method when attacker has zero attack
        int damage = magicalArena.fight(0, 5);
        assertEquals(0, damage); // Damage should be 0 as attacker's attack is 0
    }

    @Test
    public void testFightWithZeroAttackAndStrength() {
        // Test fight method when both attacker's attack and defender's strength are zero
        int damage = magicalArena.fight(0, 0);
        assertEquals(0, damage); // Damage should be 0 as both attacker's attack and defender's strength are 0
    }

    @Test
    public void testFightWithMaxDamage() {
        // Test fight method when attacker's attack is significantly greater than defender's strength
        int attackerAttack = 100; // Example attacker's attack
        int defenderStrength = 10; // Example defender's strength
        int damage = magicalArena.fight(attackerAttack, defenderStrength);
        assertTrue(() -> damage >= 0, "Damage should be non-negative");
    }

    @Test
    public void testFightWithZeroDamage() {
        // Test fight method when attacker's attack is less than or equal to defender's strength
        int attackerAttack = 3; // Example attacker's attack
        int defenderStrength = 5; // Example defender's strength
        int damage = magicalArena.fight(attackerAttack, defenderStrength);
        assertEquals(0, damage); // Damage should be 0 as attacker's attack is less than or equal to defender's strength
    }
}
