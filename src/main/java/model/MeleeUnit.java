package model;

class MeleeUnit extends MilitaryUnit {

    public MeleeUnit(Civilization owner) {
        super(100, owner, 10, 10, 14, 5, 0, 30);
    }

    public char symbol() {
        return 'M';
    }

    public void battle(MapObject mapObj) {
        mapObj.damage(getDamage());
        if (!mapObj.isDestroyed()) {
            if (mapObj instanceof MeleeUnit || mapObj instanceof HybridUnit) {
                this.damage(((MilitaryUnit) mapObj).getDamage()); //have to cast
                //to MilitaryUnit because MapObject does not have getDamage
                //for compile time errors
            }
        }
    }

    @Override
    public String toString() {
        return "Melee Unit. " + super.toString();
    }


}
