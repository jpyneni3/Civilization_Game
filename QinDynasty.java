public class QinDynasty {
    private Population populationQin = new Population();
    private Settlement[] settlementsQin = new Settlement[10];
    private Treasury treasuryQin = new Treasury();
    private CoalMine coalMineQin = new CoalMine();
    private River riverQin = new River("Yellow");
    private Technology technologyQin = new Technology();
    private Strategy strategyQin = new Strategy();
    private static int numSettlement = 0;
    private Hills hillsQin = new Hills();

    public boolean settle(Settlement settlement) {
        if (numSettlement == 10) {
            return false;
        } else {
            settlementsQin[this.getNumSettlements()] = settlement;
            numSettlement++;
            return true;
        }
    }

    public int getNumSettlements() {
        return numSettlement;
    }

    public boolean buildWall(Settlement s) {
        Building wall = new Building(1000, 100);
        if (treasuryQin.getCoins() >= 1000 && populationQin.canWork(100)) {
            treasuryQin.spend(1000);
            technologyQin.increaseExperience(10);
            s.addBuilding(wall);
            return true;
        } else {
            return false;
        }
    }

    public boolean buildHouse(Settlement s) {
        Building house = new Building(30, 8);
        if (treasuryQin.getCoins() >= 30 && populationQin.canWork(8)) {
            treasuryQin.spend(1000);
            technologyQin.increaseExperience(10);
            s.addBuilding(house);
            return true;
        } else {
            return false;
        }
    }


    public void establishLegalism() {
        technologyQin.philosophize();
        if (populationQin.getHappiness() >= 20) {
            populationQin.decreaseHappiness(20);
        }
    }
    public Strategy getStrategy() {
        return strategyQin;
    }

    public Technology getTechnology() {
        return technologyQin;
    }

    public Treasury getTreasury() {
        return treasuryQin;
    }

    public Population getPopulation() {
        return populationQin;
    }


    public Settlement[] getSettlements() {
        return settlementsQin;
    }

    public River getRiver() {
        return riverQin;
    }

    public Hills getHills() {
        return hillsQin;
    }

    public CoalMine getCoalMine() {
        return coalMineQin;
    }


}
