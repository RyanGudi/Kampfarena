import codemons.Codemon;
import codemons.CodemonFactory;
import java.util.Random;

public class Game {
    private Trainer player;
    private Trainer enemy;
    private EventSingleton eventSingleton;

    /**
     * Initializes a new game against an enemy trainer.
     * @param player player
     * @param enemy opponent
     * @param eventSingleton day/weather cycle
     */
    public Game(Trainer player, Trainer enemy, EventSingleton eventSingleton) {
        this.player = player;
        this.enemy = enemy;
        this.eventSingleton = eventSingleton;
    }

    /**
     * Starts the game and loops it for a num of days.
     * @param days days
     */
    public void start(int days) {
        System.out.println("Welcome to the world of Codemon!");
        Random random = new Random();
        for (int i = 1; i <= days; i++) {
            System.out.println("\n\nDay " + i);
            while (player.hasAliveCodemons() && eventSingleton.isDay()) {
                System.out.println("Weather: " + eventSingleton.getWeatherCondition());
                boolean enemyEncounter = random.nextBoolean();
                if (enemyEncounter && enemy.hasAliveCodemons()) {
                    System.out.println("You encountered a trainer!");
                    startBattle(player, enemy);
                } else {
                    Codemon wildCodemon = getRandomWildCodemon();
                    System.out.println("You encountered a wild " 
                                    + wildCodemon.getName() 
                                    + " (Level " + wildCodemon.getLevel() + ")!");
                    startWildBattle(player, wildCodemon);
                }
                eventSingleton.advanceCycles();
            }
            System.out.println("Day: " + eventSingleton.isDay() 
                                + " Weather: " + eventSingleton.getWeatherCondition());
            if (!eventSingleton.isDay() || !player.hasAliveCodemons()) {
                eventSingleton.restartDayCycle();
                System.out.println("Nighttime Begins");
                System.out.println("Healing Injured Codemons");
                player.healAllCodemons();
                enemy.healAllCodemons();
                int enemyLevel = random.nextInt(player.getTopCodemon().getLevel() + 1);
                System.out.println("Enemy level: " + enemyLevel);
                enemy.setTeamLevel(enemyLevel);
            }
        }
    }

    /**
     * Starts a battle in the game between two trainers.
     * @param player player
     * @param opponent opponent
     */
    public void startBattle(Trainer player, Trainer opponent) {
        Battle battle = new Battle(player, opponent, eventSingleton);
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

    /**
     * Starts a battle between a trainer and a wild codemon.
     * @param player player
     * @param wildCodemon wild codemon
     */
    public void startWildBattle(Trainer player, Codemon wildCodemon) {
        Battle battle = new Battle(player, wildCodemon, eventSingleton);
        battle.start();
        if (player.hasAliveCodemons()) {
            System.out.println("You defeated the wild " + wildCodemon.getName() + "!");
            int expReward = 250;
            player.gainExpForAllCodemons(expReward);
            System.out.println("You earned " + expReward + " experience points!");
        } else {
            System.out.println("All your codemons have fainted. You were defeated by the wild " 
                                + wildCodemon.getName() + "!");
        }
    }

    /**
     * Returns a random wild codemon based on the player's level.
     * @return
     */
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
