public class Treasury {
    private int goldCoins;

    public Treasury() {
        goldCoins = 200;
    }

    public int getCoins() {
        return goldCoins;
    }

    public boolean spend(int cost) {
        if (goldCoins >= cost) {
            goldCoins -= cost;
            return true;
        } else {
            return false;
        }
    }

    public void earn(int coinsEarned) {
        goldCoins += coinsEarned;
    }

}
