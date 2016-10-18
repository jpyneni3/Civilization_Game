package model;



class Egypt extends Civilization {
    private Desert desert = new Desert();

    public Egypt() {
        super("Egpyt");
    }

    public Desert getDesert() {
        return desert;
    }

    @Override
    public String explore() {
        int j = desert.findTreasure();
        getTreasury().earn(j);
        return "You explore your surroundings and acquire " + j + " gold";
    }

    @Override
    public RangedUnit getRangedUnit() {
        return new WarChariot(this);
    }
    @Override
    public Landmark getLandmark() {
        return new Pyramid(this);
    }



}
