import java.util.Random;

public class River {
    private Fish[] riverFish = new Fish[5];
    private String name;
    private Random r = new Random();
    private static int fishCount = 0;

    public River(String name) {
        this.name = name;
        setFish();
    }


    public void setFish() {
        for (int i = 0; i < riverFish.length; i++) {
            riverFish[i] = new Fish(r.nextInt(5));
            fishCount++;
        }
    }

    public Fish getFish() {
        if (fishCount == 0) {
            return null;
        } else {
            fishCount--;
            return riverFish[fishCount];
        }

    }

    public boolean replenishFish() {
        if (fishCount == 0) {
            setFish();
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return name;
    }

}
