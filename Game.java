public class Game {
    private int healthIncrease;

    public Game(int healthIncrease) {
        this.healthIncrease = healthIncrease;
    }

    public Game() {
        this(20); //constructor chaining
    }

    public int getHealth() {
        return healthIncrease;
    }
}
