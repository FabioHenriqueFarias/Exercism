abstract class Fighter {

    boolean isVulnerable() {
        return false;
    }

    abstract int damagePoints(Fighter fighter);

}

class Warrior extends Fighter {

    @Override
    public String toString() {
        return "Fighter is a Warrior";
    }

    @Override
    int damagePoints(Fighter fighter) {

        return fighter.isVulnerable() ? 10 : 6;
    }
}

class Wizard extends Fighter {

    private boolean spell;

    @Override
    boolean isVulnerable() {
        return this.spell;
    }

    @Override
    int damagePoints(Fighter fighter) {
        if(this.spell){
            return 12;
        }

        return 3;
    }

    @Override
    public String toString() {
        return "Fighter is a Wizard";
    }

    void prepareSpell() {
        this.spell = true;
    }

}
