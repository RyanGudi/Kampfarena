import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import attacks.Attack;

import org.junit.Test;

public class AttackTest {

    @Test
    public void testAttackConstructor() {
        Attack fireAttack = new Attack("fire", 1);
        assertEquals("Firepunch", fireAttack.getName());
        assertEquals(75, fireAttack.getPower());
        assertEquals(8, fireAttack.getCrit());
        assertEquals(100, fireAttack.getAccuracy());
        assertEquals("fire", fireAttack.getType());

        Attack waterAttack = new Attack("water", 15);
        assertEquals("Water Pulse", waterAttack.getName());
        assertEquals(90, waterAttack.getPower());
        assertEquals(5, waterAttack.getCrit());
        assertEquals(100, waterAttack.getAccuracy());
        assertEquals("water", waterAttack.getType());

        Attack grassAttack = new Attack("grass", 10);
        assertEquals("Solar Beam", grassAttack.getName());
        assertEquals(100, grassAttack.getPower());
        assertEquals(20, grassAttack.getCrit());
        assertEquals(50, grassAttack.getAccuracy());
        assertEquals("grass", grassAttack.getType());
    }

    @Test
    public void testEqualsAndHashCode() {
        Attack attack1 = new Attack("fire", 1);
        Attack attack2 = new Attack("fire", 1);
        Attack attack3 = new Attack("water", 2);

        assertTrue(attack1.equals(attack2));
        assertFalse(attack1.equals(attack3));

        assertEquals(attack1.hashCode(), attack2.hashCode());
        assertNotEquals(attack1.hashCode(), attack3.hashCode());
    }

    @Test
    public void testToString() {
        Attack attack = new Attack("fire", 15);
        assertEquals("Flamethrower", attack.toString());
    }

    @Test
    public void testAccessors() {
        Attack attack = new Attack("water", 20);
        assertEquals("water", attack.getType());
        assertEquals(110, attack.getPower());
        assertEquals(15, attack.getCrit());
        assertEquals(80, attack.getAccuracy());
    }
}