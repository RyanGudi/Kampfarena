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

        System.out.println("Player: " + player.hasAliveCodemons() + "Opponent: " + enemyTrainer.hasAliveCodemons());
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

            //Switch to the opponent trainer's turn
            Trainer temp = currentTrainer;
            currentTrainer = opponent;
            opponent = temp;
            System.out.println("Player: " + player.hasAliveCodemons() + " Opponent: " + enemyTrainer.hasAliveCodemons());
        }

        //Check for winner
        if (!player.hasAliveCodemons()) {
            System.out.println(player.getName() + " has no more Codemons left. " + enemyTrainer.getName() + " wins!");
        } else {
            System.out.println(enemyTrainer.getName() + " has no more Codemons left. " + player.getName() + " wins!");
        }
    }

    private void startWildBattle() {

    }

    public int calculateDamage(Attack move, Codemon attacker, Codemon defender) {
        Random random = new Random();
        int damage;

        //Miss Chance
        if(random.nextInt(100) >= move.getAccuracy()) {
            System.out.println("Move missed");
            return 0;
        }

        damage = (move.getPower() * attacker.getAttack()) / (int)(defender.getDefense() * 8);

        //Crit Chance
        if(random.nextInt(100) <= move.getCrit()) {
            damage *= 2;
        }

        return damage;
    }
}
