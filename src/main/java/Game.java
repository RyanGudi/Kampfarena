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
        // boolean enemyEncounter = random.nextBoolean();
        boolean enemyEncounter = true;
        if(enemyEncounter) {
            System.out.println("You encountered a trainer!");
            startBattle(player, enemy);
        }else {
           System.out.println("You encountered a wild Code-a-Mon!");
        }

    }

    public void startBattle(Trainer player, Trainer opponent) {
        Battle battle = new Battle(player, opponent);
        battle.start();
        if (player.hasAliveCodemons()) {
            System.out.println("Congratulations! You defeated " + opponent.getName() + "!");
            // int moneyReward = opponent.calculateMoneyReward();
            // int expReward = opponent.calculateExpReward();
            // player.gainMoney(moneyReward);
            // player.gainExpForAllCodemons(expReward);
            // System.out.println("You earned " + moneyReward + " money and " + expReward + " experience points!");
        } else {
            System.out.println("You lost the battle. Better luck next time!");
        }
    }



}
