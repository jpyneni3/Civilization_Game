import java.util.Random;

public class Population {
    private int warriors = 50;
    private int civilians = 50;
    private int happiness = 200;
    private Random rand = new Random();

    public boolean canBattle() {
        if (warriors > rand.nextInt(100)) {
            warriors -= rand.nextInt(20);
            return true;
        }
        return false;
    }

    public void increaseHappiness(int incHap) {
        happiness += incHap;
    }

    public boolean decreaseHappiness(int decHap) {
        if (happiness >= decHap) {
            happiness -= decHap;
            return true;
        } else {
            return false;
        }
    }
    public int getHappiness() {
        return happiness;
    }

    public boolean canWork(int workers) {
        if (civilians >= workers) {
            civilians -= workers;
            return true;
        } else {
            return false;
        }
    }

    public Game hunt(Hills hill) {
        return hill.hunt();
    }

    public Fish fish(River river) {
        return river.getFish();
    }

    public boolean canCook(Game game, CoalMine coalMine) {
        if (coalMine.getCoal() >= 40) {
            warriors += 40;
            civilians += 60;
            coalMine.burn();
            coalMine.burn();
            coalMine.burn();
            coalMine.burn();
            return true;
        } else {
            return false;
        }
    }

    public boolean canCook(Fish fish, CoalMine coalMine) {
        if (coalMine.getCoal() >= 40) {
            warriors += 10;
            civilians += 15;
            coalMine.burn();
            coalMine.burn();
            coalMine.burn();
            coalMine.burn();
            return true;
        } else {
            return false;
        }
    }

    public int getWarriors() {
        return warriors;
    }
    public int getCivilians() {
        return civilians;
    }

    public void setWarriors(int newWarriors) {
        warriors = newWarriors;
    }

}
