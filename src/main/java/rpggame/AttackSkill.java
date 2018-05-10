package rpggame;

import java.util.Random;

public class AttackSkill extends Skill {
    public boolean activate(){
        if (offCooldown()) {
            activateCoolDown();
            useSkillMessage();
            attack();
            effect();
            return true;
        }
        if (getCharacter().isPlayer()) {
            onCoolDownMessage();
        }
        return false;
    }

    public boolean attack() {
        if (isAttackActivated()) {
            printAttackMessage();

            getCharacter().getEnemy().takeDamage(calculateDamage(getStatMultiplier()), getAttackType());
            getCharacter().onHit();
            getCharacter().getEnemy().onGetHit();
            return isAttackActivated();

        } else {
            if (getCharacter().isPlayer()) {
                System.out.println(getMissMessage());
            } else {System.out.println(randomMessageSelector(getEnemyMissMessage()));}
            getCharacter().onMiss();
            getCharacter().getEnemy().onDodge();
            return isAttackActivated();}
    }

    public boolean isAttackActivated() {
        Random rand = new Random();
        int n = rand.nextInt(100)+1;
        int chance = currentAccuracy() - getCharacter().getEnemy().getCurrentDodge();
        return chance>=n;
    }

    public boolean isEffectActivated() {
        Random rand = new Random();
        int n = rand.nextInt(100)+1;
        int chance = currentEffectChance();
        return chance>=n;
    }

    public int calculateDamage(String stat){
        int statToUse;
        switch (stat) {
            case "Strength": statToUse = getCharacter().getCurrentStrength(); break;
            case "Dexterity": statToUse = getCharacter().getCurrentDexterity(); break;
            case "Intelligence": statToUse = getCharacter().getCurrentIntelligence(); break;
            case "Defence": statToUse = getCharacter().getCurrentDefence(); break;
            case "Resistance": statToUse = getCharacter().getCurrentResistance(); break;
            case "Piety": statToUse = getCharacter().getCurrentPiety(); break;
            case "Sin": statToUse = getCharacter().getCurrentSin(); break;
            default: statToUse = getCharacter().getCurrentStrength();
        }

        return (int)(((getPowerMultiplier() * statToUse * getCharacter().getPowerMultiplierBonus() * getCharacter().getDamageMultiplierBonus() + getCharacter().getPowerFlatBonus() + getCharacter().getDamageFlatBonus())));
    }

}
