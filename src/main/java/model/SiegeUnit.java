package model;

class SiegeUnit extends MilitaryUnit {

    public SiegeUnit(Civilization owner) {
        super(200, owner, 5, 10, 14, 5, 10, 60);
    }

    public char symbol() {
        return 'S';
    }

    public void battle(MapObject mapObj) {
        if (mapObj instanceof Building) {
            mapObj.damage(getDamage());
        }
    }

    @Override
    public String toString() {
        return "Siege Unit. " + super.toString();
    }
    @Override
    public void attack(MapObject mapObj) {
        battle(mapObj);
        setCanAttack(false);
    }


}
