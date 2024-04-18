import codemons.*;

public class Main {



    
    public static void main(String[] args) {
        Codemon firemon = CodemonFactory.createCodemon("fire");
        Codemon watermon = CodemonFactory.createCodemon("water");
        Codemon grassmon = CodemonFactory.createCodemon("grass");
        


        firemon.displayStats();
        // firemon.gainExp(600);
        // firemon.displayStats();
        watermon.displayStats();
        // watermon.gainExp(600);
        // watermon.displayStats();
        grassmon.displayStats();
        // grassmon.gainExp(600);
        // grassmon.displayStats();
    }
}