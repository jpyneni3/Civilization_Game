package model;

class WarChariot extends RangedUnit {

    public WarChariot(Civilization owner) {
        super(owner);
        setBaseEndurance(2 * getBaseEndurance());
    }

    public char symbol() {
        return 'W';
    }


    @Override
    public String toString() {
        return "War Chariot Unit. " + super.toString();
    }


}
