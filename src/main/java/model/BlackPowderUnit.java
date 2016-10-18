package model;

class BlackPowderUnit extends SiegeUnit {

    public BlackPowderUnit(Civilization owner) {
        super(owner);
    }

    public char symbol() {
        return 'B';
    }

    public void battle(MapObject mapObj) {
        mapObj.damage(getDamage());

    }

    @Override
    public String toString() {
        return "Black Powder Unit. " + super.toString();
    }
}
