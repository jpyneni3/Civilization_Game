package model;

public class FarmerUnit extends Unit implements Convertable {
    public FarmerUnit(Civilization owner) {
        super(owner);
    }

    public char symbol() {
        return 'f';
    }

    public Building convert() {
        return getOwner().getFarm();
    }

    public boolean canConvert(TileType type) {
        return type == TileType.PLAINS;
    }
    @Override
    public String toString() {
        return "Farmers. " + super.toString();
    }
}
