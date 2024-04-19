import java.util.Random;

public class Game {
    private Trainer player;
    private Trainer enemy;

    public Game(Trainer player, Trainer enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public void start() {
        System.out.println("Welcome to the world of Codemon!");

        Random random = new Random();
        boolean enemyEncounter = random.nextBoolean();

        if(enemyEncounter) {
            System.out.println("You encountered a trainer!");
            
        }else {
           
        }

    }

    public void startBattle(Trainer player, Trainer opponent) {

    }



}
