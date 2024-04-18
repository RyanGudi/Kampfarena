package attacks;



public class Attack {
    protected String name;
    protected int damage;
    protected int crit;
    protected int accuracy;
    protected String[] fireAttacks = {"Flamethrower", ""};
    protected String[] waterAttacks = {"Hydro Pump", "Bubble Beam", "Water Pulse", "Aqua Tail"};
    protected String[] grassAttacks = {"Razor Leaf", "Solar Beam", "Energy Ball", "Vine Whip"};
    


    public Attack(String name) {
        this.name = name;

        switch(name) {

            case "fire":

            break;

            case "water":

            break;

            case "grass":

            break;
        }
    }



    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getCrit() {
        return crit;
    }

    public int getAccuracy() {
        return accuracy;
    }
}
