package model;

public class CoalMinerUnit extends Unit implements Convertable {
    public CoalMinerUnit(Civilization owner) {
        super(owner);
    }

    public char symbol() {
        return 'c';
    }

    public Building convert() {
        return getOwner().getCoalMine();
    }

    public boolean canConvert(TileType type) {
        return type == TileType.HILLS;
    }
    @Override
    public String toString() {
        return "Coal Miners. " + super.toString();
    }
}
