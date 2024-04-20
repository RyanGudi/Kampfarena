import codemons.Codemon;
import codemons.CodemonFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Trainer {
    public String name;
    public List<Codemon> team;
    private static final int MAX_TEAM_SIZE = 6;
    private Random random;

    /**
     * Creates a trainer with a name.
     * @param name name
     */
    public Trainer(String name) {
        this.name = name;
        team = new ArrayList<>();
        random = new Random();
        addCodemon();
    }

    /**
     * Adds a random codemon to the team.
     */
    public void addCodemon() {
        if (team.size() < MAX_TEAM_SIZE) {
            Codemon newCodemon = getRandomCodemon();
            team.add(newCodemon);
            System.out.println(newCodemon.getName() + " has joined the team!");
        } else {
            System.out.println("Team is full");
        }
    }

    /**
     * Gets a random codemon.
     * @return
     */
    public Codemon getRandomCodemon() {
        String[] types = {"fire", "water", "grass"};
        int randomIndex = random.nextInt(3);
        return CodemonFactory.createCodemon(types[randomIndex]);
    }

    /**
     * Checks if the team still has an alive codemon.
     * @return
     */
    public boolean hasAliveCodemons() {
        boolean alive = false;
        for (Codemon codemon: team) {
            if (!codemon.isFainted()) {
                alive = true;
            }
        }
        return alive;
    }

    /**
     * Prints the trainer's current team.
     */
    public void printTeam() {
        System.out.println("Trainer " + name + "'s Team:");
        for (Codemon codemon : team) {
            System.out.println(codemon);
        }
    }

    public String getName() {
        return name;
    }

    /**
     * Returns the first codemon thats alive.
     * @return
     */
    public Codemon getCurrentCodemon() {
        for (Codemon codemon : team) {
            if (!codemon.isFainted()) {
                return codemon;
            }
        }
        return null;
    }

    /**
     * Returns the first codemon.
     * @return
     */
    public Codemon getTopCodemon() {
        return team.get(0);
    }

    /**
     * Gives exp to the whole team evenly.
     * @param exp exp
     */
    public void gainExpForAllCodemons(int exp) {
        for (Codemon codemon : team) {
            codemon.gainExp(exp);
        }
    }

    /**
     * Heals the entire team to full.
     */
    public void healAllCodemons() {
        for (Codemon codemon : team) {
            codemon.setFainted(false);
            codemon.setHp(codemon.getHealth());
        }
    }

    /**
     * Sets the whole team's codemon level.
     * @param level level
     */
    public void setTeamLevel(int level) {
        for (Codemon codemon : team) {
            codemon.setLevel(level);
        }
    }

}
