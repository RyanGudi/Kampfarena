package attacks;

import java.util.Objects;

public class Attack {
    protected String name;
    protected int power;
    protected int crit;
    protected int accuracy;
    protected String type;
    protected String[] fireAttacks = {"Firepunch", "Inferno", "Flamethrower", "Fire Blast"};
    protected String[] waterAttacks = {"Hydro Pump", "Bubble Beam", "Water Pulse", "Aqua Tail"};
    protected String[] grassAttacks = {"Razor Leaf", "Solar Beam", "Energy Ball", "Vine Whip"};
    
    /**
     * Creates a type of attack and initializes its stats.
     * depending on the type and level of the codemon
     * @param type type 
     * @param level level
     */
    public Attack(String type, int level) {
        this.type = type;
        int levelMod = (level - 1) / 5;
        if (level > 20) {
            return;
        }
        if (type.equals("fire")) {
            name = fireAttacks[levelMod];
        } else if (type.equals("water")) {
            name = waterAttacks[levelMod];
        } else if (type.equals("grass")) {
            name = grassAttacks[levelMod];
        } else {
            System.out.println("Not a valid type");
            return;
        }
        switch (levelMod) {
            case 0:
                power = 75;
                accuracy = 100;
                crit = 8;
                break;
            case 1:
                power = 100;
                accuracy = 50;
                crit = 20;
                break;
            case 2:
                power = 90;
                accuracy = 100;
                crit = 5;
                break;
            case 3:
                power = 110;
                accuracy = 80;
                crit = 15;
                break;
            default:
                System.out.println("Something went wrong selecting a move: " + level);
                return;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Attack)) {
            return false;
        }
        Attack other = (Attack) obj;
        return power == other.power 
                    && crit == other.crit 
                    && accuracy == other.accuracy 
                    && name.equals(other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, power, crit, accuracy);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public int getCrit() {
        return crit;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public String getType() {
        return type;
    }
}
