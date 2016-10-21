package model;

public class SettlerUnit extends Unit implements Convertable {
    private String townName;

    public SettlerUnit(Civilization owner, String tName) {
        super(owner);
        townName = tName;
    }

    public char symbol() {
        return 's';
    }

    public Building convert() {
        getOwner().incrementNumSettlements();
        return getOwner().getSettlement(townName);
    }

    public boolean canConvert(TileType type) {
        return type == TileType.PLAINS;
    }
    @Override
    public String toString() {
        return "Settlers of. " + townName.toUpperCase() + " "
            + super.toString();
    }
}
