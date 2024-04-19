import codemons.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Trainer {
    public String name;
    public int money;
    public List<Codemon> team;
    private static final int MAX_TEAM_SIZE=6;

    public Trainer(String name) {
        this.name = name;
        money = 0;
        team = new ArrayList<>();
        addCodemon();
    }

    public void addCodemon() {
        if(team.size() < MAX_TEAM_SIZE) {
            Codemon newCodemon = getRandomCodemon();
            team.add(newCodemon);
            System.out.println(newCodemon.getName() + " has joined the team!");
        } else {
            System.out.println("Team is full");
        }
    }

    public Codemon getRandomCodemon() {
        String[] types = {"fire", "water", "grass"};
        Random rand = new Random();
        int randomIndex = rand.nextInt(3);
        return CodemonFactory.createCodemon(types[randomIndex]);
    }

    public boolean hasAliveCodemons() {
        boolean alive = false;
        for(Codemon codemon: team) {
            if(!codemon.isFainted()) {
                alive = true;
            }
        }
        return alive;
    }

    public void printTeam() {
        System.out.println("Trainer " + name + "'s Team:");
        for (Codemon codemon : team) {
            System.out.println(codemon);
        }
    }

    public String getName() {
        return name;
    }

    public Codemon getCurrentCodemon() {
        for (Codemon codemon : team) {
            if (!codemon.isFainted()) {
                return codemon;
            }
        }
        return null;
    }

    public void gainExpForAllCodemons(int exp) {
        //System.out.println(name + " gained " + exp + "exp.");
        for (Codemon codemon : team) {
            codemon.gainExp(exp);
        }
    }

}
