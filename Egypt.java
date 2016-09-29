public class Egypt {
    private Population populationEgypt = new Population();
    private Settlement[] settlementsEgypt = new Settlement[10];
    private Treasury treasuryEgypt = new Treasury();
    private CoalMine coalMineEgypt = new CoalMine();
    private River riverEgypt = new River("Nile");
    private Technology technologyEgypt = new Technology();
    private Strategy strategyEgypt = new Strategy();
    private static int numSettlement = 0;
    private Desert desertEgypt = new Desert();

    public boolean settle(Settlement settlement) {
        if (this.numSettlement == 10) {
            return false;
        } else {
            settlementsEgypt[this.getNumSettlements()] = settlement;
            numSettlement++;
            return true;
        }
    }

    public int getNumSettlements() {
        return numSettlement;
    }

    public boolean buildPyramid(Settlement s) {
        Building pyramid = new Building(500, 100);
        if (treasuryEgypt.getCoins() >= 500 && populationEgypt.canWork(100)) {
            treasuryEgypt.spend(500);
            technologyEgypt.increaseExperience(10);
            s.addBuilding(pyramid);
            return true;
        } else {
            return false;
        }
    }

    public void practiceHieroglyphics() {
        technologyEgypt.improveWriting();
        populationEgypt.increaseHappiness(10);
    }
    public Strategy getStrategy() {
        return strategyEgypt;
    }

    public Technology getTechnology() {
        return technologyEgypt;
    }

    public Treasury getTreasury() {
        return treasuryEgypt;
    }

    public Population getPopulation() {
        return populationEgypt;
    }

    public Settlement[] getSettlements() {
        return settlementsEgypt;
    }

    public River getRiver() {
        return riverEgypt;
    }

    public Desert getDesert() {
        return desertEgypt;
    }

    public CoalMine getCoalMine() {
        return coalMineEgypt;
    }

}
