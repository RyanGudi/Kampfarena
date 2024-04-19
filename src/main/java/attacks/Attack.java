package attacks;

public class Attack {
    protected String name;
    protected int power;
    protected int crit;
    protected int accuracy;
    protected String[] fireAttacks = {"Firepunch", "Inferno", "Flamethrower", "Fire Blast"};
    protected String[] waterAttacks = {"Hydro Pump", "Bubble Beam", "Water Pulse", "Aqua Tail"};
    protected String[] grassAttacks = {"Razor Leaf", "Solar Beam", "Energy Ball", "Vine Whip"};
    
    public Attack(String type, int level) {
        if(level > 20) {
            return;
        }
        int levelMod = (level - 1) / 5;
        if(type.equals("fire")) {
            name = fireAttacks[levelMod];
        } else if(type.equals("water")) {
            name = waterAttacks[levelMod];
        } else if(type.equals("grass")) {
            name = grassAttacks[levelMod];
        }else {
            System.out.println("Not a valid type");
            return;
        }
        switch(levelMod) {
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
}
