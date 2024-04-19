import java.util.Random;

import codemons.*;

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
            startBattle(player, enemy);
        } else {
            Codemon wildCodemon = getRandomWildCodemon();
            System.out.println("You encountered a wild " + wildCodemon.getName() + " (Level " + wildCodemon.getLevel() +")!");
            startWildBattle(player, wildCodemon);
        }

    }

    public void startBattle(Trainer player, Trainer opponent) {
        Battle battle = new Battle(player, opponent);
        battle.start();
        if (player.hasAliveCodemons()) {
            System.out.println("Congratulations! You defeated " + opponent.getName() + "!");
             int expReward = 500;
             player.gainExpForAllCodemons(expReward);
             System.out.println("You earned " + expReward + " experience points!");
        } else {
            System.out.println("You lost the battle. Better luck next time!");
        }
    }

    public void startWildBattle(Trainer player, Codemon wildCodemon) {
        Battle battle = new Battle(player, wildCodemon);
        battle.start();
        if (player.hasAliveCodemons()) {
            System.out.println("You defeated the wild " + wildCodemon.getName() + "!");
            int expReward = 250;
            player.gainExpForAllCodemons(expReward);
             System.out.println("You earned " + expReward + " experience points!");
        } else {
            System.out.println("All your codemons have fainted. You were defeated by the wild " + wildCodemon.getName() + "!");
        }
    }

    public Codemon getRandomWildCodemon() {
        Codemon wildCodemon;
        String[] types = {"fire", "water", "grass"};
        Random random = new Random();
        int level = player.getCurrentCodemon().getLevel();
        System.out.println("Player Level : " + level);
        wildCodemon = CodemonFactory.createCodemon(types[random.nextInt(3)]);
        wildCodemon.gainExp((level - random.nextInt(10)) * 100);
        return wildCodemon;
    }


}
