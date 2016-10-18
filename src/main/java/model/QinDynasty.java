package model;


class QinDynasty extends Civilization {

    private Hills hills = new Hills();

    public QinDynasty() {
        super("Qin Dynasty");
    }

    public Hills getHills() {
        return hills;
    }

    @Override
    public String explore() {
        hills.replenishGame();
        int j = hills.hunt().getHealth();
        makeFood(j);
        return "You explore your surroundings and acquire " + j + " food!";
    }
    @Override
    public Landmark getLandmark() {
        return new GreatWall(this);
    }
    @Override
    public SiegeUnit getSiegeUnit() {
        return new BlackPowderUnit(this);
    }



}
