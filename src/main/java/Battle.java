import codemons.*;
import attacks.*;

import java.util.Random;

public class Battle {
    private Trainer player;
    private Trainer enemyTrainer;
    private Codemon wildCodemon;

    public Battle(Trainer player, Trainer enemyTrainer) {
        this.player = player;
        this.enemyTrainer = enemyTrainer;
    }

    public Battle(Trainer player, Codemon wildCodemon) {
        this.player = player;
        this.wildCodemon = wildCodemon;
    }

    public void start() {
        if(enemyTrainer != null) {
            startTrainerBattle();
        } else {
            startWildBattle();
        }
    }


    private void startTrainerBattle() {
        System.out.println("Trainer Battle battle between " + player.getName() +
                             " and " + enemyTrainer.getName() + " started!");

        Trainer currentTrainer = player;
        Trainer opponent = enemyTrainer;

        //System.out.println("Player: " + player.hasAliveCodemons() + "Opponent: " + enemyTrainer.hasAliveCodemons());
        while (player.hasAliveCodemons() && enemyTrainer.hasAliveCodemons()) {
            System.out.println(currentTrainer.getName() + "'s turn:");
            Codemon currentCodemon = currentTrainer.getCurrentCodemon();
            Codemon opponentCodemon = opponent.getCurrentCodemon();

            //Simulate the current trainer's move
            Attack selectedMove = currentCodemon.getRandomMove();
            System.out.println(currentCodemon.getName() + " used " + selectedMove.getName() + "!");
            int damage = calculateDamage(selectedMove, currentCodemon, opponentCodemon);
            opponentCodemon.takeDamage(damage);
            System.out.println(opponent.getName() + "'s " + opponentCodemon.getName() + " took " + damage + " damage!");
            System.out.println(opponentCodemon.getName() + " HP: " + opponentCodemon.getHp());
            if(opponentCodemon.getHp() == 0) {
                System.out.println(opponent.getName() + "'s " + opponentCodemon.getName() + " fainted!");
            }
            //Switch to the opponent trainer's turn
            Trainer temp = currentTrainer;
            currentTrainer = opponent;
            opponent = temp;
            //System.out.println("Player: " + player.hasAliveCodemons() + " Opponent: " + enemyTrainer.hasAliveCodemons());
        }

        //Check for winner
        if (!player.hasAliveCodemons()) {
            System.out.println(player.getName() + " has no more Codemons left. " + enemyTrainer.getName() + " wins!");
        } else {
            System.out.println(enemyTrainer.getName() + " has no more Codemons left. " + player.getName() + " wins!");
        }
    }

    private void startWildBattle() {
        System.out.println("Wild Battle started with a wild " + wildCodemon.getName() + "!");

        while (player.hasAliveCodemons() && !wildCodemon.isFainted()) {
            System.out.println(player.getName() + "'s turn:");
            Codemon playerCodemon = player.getCurrentCodemon();

            //Simulate the trainer's move
            Attack selectedMove = playerCodemon.getRandomMove();
            System.out.println(playerCodemon.getName() + " used " + selectedMove.getName() + "!");
            int damage = calculateDamage(selectedMove, playerCodemon, wildCodemon);
            wildCodemon.takeDamage(damage);
            System.out.println(wildCodemon.getName() + " took " + damage + " damage!");

            // Switch to the wild codemon's turn
            if (!wildCodemon.isFainted()) {
                selectedMove = wildCodemon.getRandomMove();
                System.out.println(wildCodemon.getName() + " used " + selectedMove.getName() + "!");
                damage = calculateDamage(selectedMove, wildCodemon, playerCodemon);
                playerCodemon.takeDamage(damage);
                System.out.println(playerCodemon.getName() + " took " + damage + " damage!");
            }
        }

        // Determine the outcome of the battle
        if (!player.hasAliveCodemons()) {
            System.out.println(player.getName() + " has no more Codemons left. You were defeated by the wild " + wildCodemon.getName() + "!");
        } else {
            System.out.println("Congrats! You defeated the wild " + wildCodemon.getName() + "!");
        }
    }

    public int calculateDamage(Attack move, Codemon attacker, Codemon defender) {
        Random random = new Random();
        int damage;
        double effectiveness;
        //Miss Chance
        if(random.nextInt(100) >= move.getAccuracy()) {
            System.out.println("Move missed");
            return 0;
        }
        effectiveness = getTypeEffectiveness(attacker.getType(), defender.getType());
        damage = (int)(move.getPower() * attacker.getAttack() * effectiveness) / (int)(defender.getDefense() * 8);

        //Crit Chance
        if(random.nextInt(100) <= move.getCrit()) {
            damage *= 2;
        }

        

        return damage;
    }

    private double getTypeEffectiveness(String attackType, String defenseType) {
    if (attackType.equals("grass")) {
        if (defenseType.equals("fire")) {
            System.out.println("Not very effective");
            return 0.75; //Grass is not effective against fire
        } else if (defenseType.equals("water")) {
            System.out.println("Super Effective!");
            return 1.5; //Grass is super effective against water
        }
    } else if (attackType.equals("fire")) {
        if (defenseType.equals("grass")) {
            System.out.println("Super Effective!");
            return 1.5; //Fire is super effective against grass
        } else if (defenseType.equals("water")) {
            System.out.println("Not very effective");
            return 0.75; //Fire is not effective against water
        }
    } else if (attackType.equals("water")) {
        if (defenseType.equals("grass")) {
            System.out.println("Not very effective");
            return 0.75; //Water is not effective against grass
        } else if (defenseType.equals("fire")) {
            System.out.println("Super Effective!");
            return 1.5; //Water is super effective against fire
        }
    }
    return 1.0; //Default
    }
}
