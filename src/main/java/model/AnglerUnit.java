package model;

public class AnglerUnit extends Unit implements Convertable {
    public AnglerUnit(Civilization owner) {
        super(owner);
    }

    public char symbol() {
        return 'a';
    }

    public Building convert() {
        return getOwner().getFishingShack();
    }

    public boolean canConvert(TileType type) {
        return type == TileType.WATER;
    }
    @Override
    public String toString() {
        return "Anglers. " + super.toString();
    }
}
