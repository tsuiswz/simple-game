package rpggame;

public class DamageOverTimeEffect extends Effect {
    private int damage;
    private String attackType;
    public DamageOverTimeEffect(String name, int turns, int damage, Character giver, Character receiver) {
        super(name, turns, giver, receiver);
        this.damage = damage;
        this.attackType = "True";
    }

    public DamageOverTimeEffect(String name, int turns, int damage, Character giver, Character receiver, String attackType) {
        super(name, turns, giver, receiver);
        this.damage = damage;
        this.attackType = attackType;
    }

    public int getDamage() {return damage;}
    public String getAttackType() {return attackType;}
    public void setDamage(int i) {damage = i;}
    public void setAttackType(String s) {attackType = s;}

    public void activate() {
        if (getTurns()>0) {getReceiver().takeDamage(damage, attackType);}
        reduceTurns();
    }
}
