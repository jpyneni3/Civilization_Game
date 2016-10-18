package model;


class RomanEmpire extends Civilization {
    private Hills hills = new Hills();

    public RomanEmpire() {
        super("Roman Empire");
    }

    public Hills getHills() {
        return hills;
    }

    @Override
    public String explore() {
        int j = this.getHills().mineCoal();
        produceResources(j);
        return "You explore your surroundings and acquire " + j + " coal!";
    }

    @Override
    public MeleeUnit getMeleeUnit() {
        return new LegionUnit(this);
    }
    @Override
    public Landmark getLandmark() {
        return new Coliseum(this);
    }



}
