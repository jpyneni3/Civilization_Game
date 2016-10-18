package model;

class LegionUnit extends MeleeUnit {

    public LegionUnit(Civilization owner) {
        super(owner);
        setDamage((int) (getDamage() * 1.5));
    }

    public char symbol() {
        return 'L';
    }

    public void battle(MapObject mapObj) {
        mapObj.damage(getDamage());
        if (!mapObj.isDestroyed()) {
            if (mapObj instanceof MeleeUnit) {
                this.damage(((MilitaryUnit) mapObj).getDamage()); //have to cast
                //to MilitaryUnit because MapObject does not have getDamage
                //for compile time errors
            }
        }
    }

    @Override
    public String toString() {
        return "Legion. " + super.toString();
    }


}
