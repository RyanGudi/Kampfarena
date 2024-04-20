import attacks.Attack;
import codemons.Codemon;

import java.util.Random;

public class Battle {
    private Trainer player;
    private Trainer enemyTrainer;
    private Codemon wildCodemon;
    private EventSingleton eventSingleton;
    private Random random;

    /**
     * Constructs a battle against an enemy trainer.
     * @param player player
     * @param enemyTrainer trainer
     * @param eventSingleton event cycle
     */
    public Battle(Trainer player, Trainer enemyTrainer, EventSingleton eventSingleton) {
        setPlayer(player);
        setEnemyTrainer(enemyTrainer);
        this.eventSingleton = eventSingleton;
        random = new Random();
    }


    /**
     * Constructs a battle against a wild codemon.
     * @param player player
     * @param wildCodemon wild codemon
     * @param eventSingleton event cycle
     */
    public Battle(Trainer player, Codemon wildCodemon, EventSingleton eventSingleton) {
        setPlayer(player);
        setWildCodemon(wildCodemon);
        this.eventSingleton = eventSingleton;
        random = new Random();
    }

    /**
     * Starts the battle, checking for trainer or wild codemon.
     */
    public void start() {
        if (enemyTrainer != null) {
            startTrainerBattle();
        } else {
            startWildBattle();
        }
    }


    /**
     * Beings the trainer battle.
     * ends when either trainer loses all their codemons
     */
    private void startTrainerBattle() {
        System.out.println("Trainer Battle battle between " + player.getName() 
                            + " and " + enemyTrainer.getName() + " started!");

        Trainer currentTrainer = player;
        Trainer opponent = enemyTrainer;

        while (player.hasAliveCodemons() && enemyTrainer.hasAliveCodemons()) {
            System.out.println("\n" + currentTrainer.getName() + "'s turn:");
            Codemon currentCodemon = currentTrainer.getCurrentCodemon();
            Codemon opponentCodemon = opponent.getCurrentCodemon();

            //Simulate the current trainer's move
            Attack selectedMove = currentCodemon.getRandomMove();
            System.out.println(currentCodemon.getName() + " used " + selectedMove.getName() + "!");
            int damage = calculateDamage(selectedMove, currentCodemon, opponentCodemon);
            opponentCodemon.takeDamage(damage);
            System.out.println(opponent.getName() + "'s " + opponentCodemon.getName() 
                                + " took " + damage + " damage!");
            System.out.println(opponentCodemon.getName() + " HP: " + opponentCodemon.getHp());
            if (opponentCodemon.getHp() == 0) {
                System.out.println(opponent.getName() + "'s " 
                                    + opponentCodemon.getName() + " fainted!");
            }
            //Switch to the opponent trainer's turn
            Trainer temp = currentTrainer;
            currentTrainer = opponent;
            opponent = temp;
        }

        //Check for winner
        if (!player.hasAliveCodemons()) {
            System.out.println(player.getName() + " has no more Codemons left. " 
                                + enemyTrainer.getName() + " wins!");
        } else {
            System.out.println(enemyTrainer.getName() + " has no more Codemons left. " 
                                + player.getName() + " wins!");
        }
    }


    /**
     * Begins a wild codemon battle.
     * ends when the trainer loses all codemons
     * or when the wild codemon faints
     */
    private void startWildBattle() {
        System.out.println("Wild Battle started with a wild " + wildCodemon.getName() + "!");

        while (player.hasAliveCodemons() && !wildCodemon.isFainted()) {
            System.out.println("\n" + player.getName() + "'s turn:");
            Codemon playerCodemon = player.getCurrentCodemon();

            //Simulate the trainer's move
            Attack selectedMove = playerCodemon.getRandomMove();
            System.out.println(playerCodemon.getName() + " used " + selectedMove.getName() + "!");
            int damage = calculateDamage(selectedMove, playerCodemon, wildCodemon);
            wildCodemon.takeDamage(damage);
            System.out.println("Wild " + wildCodemon.getName() + " took " + damage + " damage!");

            // Switch to the wild codemon's turn
            if (!wildCodemon.isFainted()) {
                selectedMove = wildCodemon.getRandomMove();
                System.out.println("Wild " + wildCodemon.getName() 
                                    + " used " + selectedMove.getName() + "!");
                damage = calculateDamage(selectedMove, wildCodemon, playerCodemon);
                playerCodemon.takeDamage(damage);
                System.out.println(playerCodemon.getName() + " took " + damage + " damage!");
            }
        }

        // Determine the outcome of the battle
        if (!player.hasAliveCodemons()) {
            System.out.println(player.getName() 
                                + " has no more Codemons left. You were defeated by the wild " 
                                + wildCodemon.getName() + "!");
        } else {
            System.out.println("Congrats! You defeated the wild " + wildCodemon.getName() + "!");
        }
    }

    /**
     * Calculates the damage depending on the stats of the codemon.
     * @param move attack
     * @param attacker attacker
     * @param defender defender
     * @return
     */
    public int calculateDamage(Attack move, Codemon attacker, Codemon defender) {
        int damage;
        double effectiveness;
        //Miss Chance
        if (random.nextInt(100) >= move.getAccuracy()) {
            System.out.println("Move missed");
            return 0;
        }
        effectiveness = getTypeEffectiveness(attacker.getType(), defender.getType());
        damage = (int)(move.getPower() * attacker.getAttack() * effectiveness) 
                / (int)(defender.getDefense() * 8);

        //Crit Chance
        if (random.nextInt(100) <= move.getCrit()) {
            damage *= 2;
        }

        return damage;
    }

    /**
     * Calculates the damage based on type effectiveness.
     * Uses weather to check if the move is boosted
     * @param attackType attack move type
     * @param defenseType defender codemon type
     * @return
     */
    private double getTypeEffectiveness(String attackType, String defenseType) {
        double effectiveness = 1.0;
        if (attackType.equals("grass")) {
            if (defenseType.equals("fire")) {
                System.out.println("Not very effective");
                effectiveness = 0.75; //Grass is not effective against fire
            } else if (defenseType.equals("water")) {
                System.out.println("Super Effective!");
                effectiveness = 1.5; //Grass is super effective against water
            }
        } else if (attackType.equals("fire")) {
            if (defenseType.equals("grass")) {
                System.out.println("Super Effective!");
                effectiveness = 1.5; //Fire is super effective against grass
            } else if (defenseType.equals("water")) {
                System.out.println("Not very effective");
                effectiveness = 0.75; //Fire is not effective against water
            }
        } else if (attackType.equals("water")) {
            if (defenseType.equals("grass")) {
                System.out.println("Not very effective");
                effectiveness = 0.75; //Water is not effective against grass
            } else if (defenseType.equals("fire")) {
                System.out.println("Super Effective!");
                effectiveness = 1.5; //Water is super effective against fire
            }
        }

        if (eventSingleton.getWeatherCondition().equals("sunny") && attackType.equals("fire")) {
            System.out.println("The fire was boosted by the scorching sun!");
            effectiveness *= 1.25;
        } else if (eventSingleton.getWeatherCondition().equals("rainy") 
                && attackType.equals("water")) {
            System.out.println("The water was boosted by the rainy weather!");
            effectiveness *= 1.25;
        } else if (eventSingleton.getWeatherCondition().equals("sunny") 
                && attackType.equals("grass")) {
            System.out.println("The grass was boosted by the sunny weather!");
            effectiveness *= 1.25;
        }
        return effectiveness;
    }

    /**
     * Sets current enemy trainer.
     * @param enemyTrainer enemy
     */
    private void setEnemyTrainer(Trainer enemyTrainer) {
        this.enemyTrainer = enemyTrainer;
    }

    /**
     * Sets current player trainer.
     * @param player player
     */
    private void setPlayer(Trainer player) {
        this.player = player;
    }

    /**
     * Sets current wild codemon.
     * @param wildCodemon wild codemon
     */
    private void setWildCodemon(Codemon wildCodemon) {
        this.wildCodemon = wildCodemon;
    }
}
