package model;

abstract class MilitaryUnit extends Unit {

    private int damage;

    public MilitaryUnit(int health, Civilization owner, int baseEndurance,
        int pay, int initialGoldCost, int initialFoodCost,
        int initialResourceCost, int damage) {
        super(health, owner, baseEndurance, pay, initialGoldCost,
            initialFoodCost, initialResourceCost, 10);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int dam) {
        damage = dam;
    }

    @Override
    public void tick() {
        super.tick();
        setCanAttack(true);
    }

    public abstract void battle(MapObject mapObj);

    public void attack(MapObject mapObj) {
        getOwner().getStrategy().battle();
        battle(mapObj);
        setCanAttack(false);
    }

    @Override
    public String toString() {
        return "Military Unit. " + super.toString();
    }



}
