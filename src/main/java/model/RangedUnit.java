package model;

class RangedUnit extends MilitaryUnit {

    public RangedUnit(Civilization owner) {
        super(100, owner, 10, 10, 14, 5, 0, 30);
    }

    public char symbol() {
        return 'R';
    }

    public void battle(MapObject mapObj) {
        mapObj.damage(getDamage());
        if (!mapObj.isDestroyed()) {
            if (mapObj instanceof RangedUnit || mapObj instanceof HybridUnit) {
                this.damage(((MilitaryUnit) mapObj).getDamage()); //have to cast
                //to MilitaryUnit because MapObject does not have getDamage
                //for compile time errors
            }
        }
    }

    @Override
    public String toString() {
        return "Ranged Unit. " + super.toString();
    }


}
