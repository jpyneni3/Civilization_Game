package model;
public class GreatWall extends Landmark {

    public GreatWall(Civilization owner) {
      super(owner);
    }
    @Override
    public String toString() {
        return "Great Wall. " + super.toString();
    }

    public void invest() {
        super.invest();
        getOwner().getStrategy().battle();
    }

}
