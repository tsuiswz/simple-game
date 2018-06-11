package rpggame;

import java.util.ArrayList;
import java.util.Random;

public class AttackSkill extends Skill {
    /*
    creates attack skill
    Requires:
    name
    type
    attackType
    hits
    powerMultiplier
    statMultiplier
    accuracy
    cooldown
     */

    public AttackSkill(String name,
                       ArrayList<String> type,
                       String attackType,
                       int hits,
                       double powerMultiplier,
                       String statMultiplier,
                       int accuracy,
                       int cooldown,
                       String description,
                       ArrayList<String> hitMessage,
                       ArrayList<String> missMessage,
                       ArrayList<String> parryMessage,
                       ArrayList<String> enemyHitMessage,
                       ArrayList<String> enemyMissMessage,
                       ArrayList<String> enemyParryMessage) {
        setName(name);
        setSkillType("AttackSkill");
        setType(type);
        setAttackType(attackType);
        setHits(hits);
        setPowerMultiplier(powerMultiplier);
        setStatMultiplier(statMultiplier);
        setAccuracy(accuracy);
        setCoolDown(cooldown);
        setCurrentCoolDown(0);
        setDescription(description);

        setHitMessage(hitMessage);
        setMissMessage(missMessage);
        setParryMessage(parryMessage);

        setEnemyHitMessage(enemyHitMessage);
        setEnemyMissMessage(enemyMissMessage);
        setEnemyParryMessage(enemyParryMessage);
    }
    public boolean activate(){
        if (offCooldown()) {
            activateCooldown();
            useSkillMessage();
            attack();
            return true;
        }
        if (getCharacter().isPlayer()) {
            onCooldownMessage();
        }
        return false;
    }

    public void attack() {

        for (int i = 0; i<getHits(); i++) {
            if (isAttackActivated()) {
                printAttackMessage();

                getCharacter().getEnemy().takeDamage(calculateDamage(getStatMultiplier()), getAttackType());
                getCharacter().onHit();
                getCharacter().getEnemy().onGetHit();

            } else {
                if (getCharacter().isPlayer()) {
                    System.out.println(getMissMessage());
                } else {
                    System.out.println(randomMessageSelector(getEnemyMissMessage()));
                }
                getCharacter().onMiss();
                getCharacter().getEnemy().onDodge();
            }
        }
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
