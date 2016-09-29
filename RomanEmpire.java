public class RomanEmpire {
    private Population populationRome = new Population();
    private Settlement[] settlementsRome = new Settlement[10];
    private Treasury treasuryRome = new Treasury();
    private CoalMine coalMineRome = new CoalMine();
    private River riverRome = new River("Tiber");
    private Technology technologyRome = new Technology();
    private Strategy strategyRome = new Strategy();
    private static int numSettlement = 0;
    private Hills hillsRome = new Hills();

    public boolean settle(Settlement settlement) {
        if (numSettlement == 10) {
            return false;
        } else {
            settlementsRome[this.getNumSettlements()] = settlement;
            numSettlement++;
            return true;
        }
    }

    public int getNumSettlements() {
        return numSettlement;
    }

    public boolean buildAqueduct(Settlement s) {
        Building aqueduct = new Building(250, 130);
        if (treasuryRome.getCoins() >= 250 && populationRome.canWork(130)) {
            treasuryRome.spend(250);
            technologyRome.increaseExperience(10);
            s.addBuilding(aqueduct);
            return true;
        } else {
            return false;
        }
    }

    public boolean buildBathHouse(Settlement s) {
        Building bathHouse = new Building(110, 20);
        if (treasuryRome.getCoins() >= 110 && populationRome.canWork(20)) {
            treasuryRome.spend(110);
            technologyRome.increaseExperience(10);
            s.addBuilding(bathHouse);
            return true;
        } else {
            return false;
        }
    }

    public boolean buildVilla(Settlement s) {
        Building villa = new Building(80, 15);
        if (treasuryRome.getCoins() >= 80 && populationRome.canWork(15)) {
            treasuryRome.spend(80);
            technologyRome.increaseExperience(5);
            s.addBuilding(villa);
            return true;
        } else {
            return false;
        }
    }


    public void studyPhilosophy() {
        technologyRome.philosophize();
        if (populationRome.getHappiness() >= 10) {
            populationRome.decreaseHappiness(10);
        }
    }

    public Strategy getStrategy() {
        return strategyRome;
    }

    public Technology getTechnology() {
        return technologyRome;
    }

    public Treasury getTreasury() {
        return treasuryRome;
    }

    public Population getPopulation() {
        return populationRome;
    }

    public Settlement[] getSettlements() {
        return settlementsRome;
    }

    public River getRiver() {
        return riverRome;
    }

    public Hills getHills() {
        return hillsRome;
    }

    public CoalMine getCoalMine() {
        return coalMineRome;
    }


}
