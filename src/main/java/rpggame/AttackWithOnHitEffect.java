package rpggame;


import java.util.ArrayList;

public class AttackWithOnHitEffect extends AttackSkill {

    public AttackWithOnHitEffect(String name,
                           ArrayList<String> type,
                           String attackType,
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
                           ArrayList<String> enemyParryMessage,

                                 //"Hit", "Buff", "Debuff", "Damage Over Time" etc
                           String effect,
                           String effectTarget,
                           double effectPowerMultiplier,
                           String effectStatMultiplier,
                           String effectAttackType,
                           int effectChance,
                           ArrayList<String> effectMessage,
                           ArrayList<String> enemyEffectMessage) {
        super(  name,
                type,
                attackType,
                powerMultiplier,
                statMultiplier,
                accuracy,
                cooldown,
                description,
                hitMessage,
                missMessage,
                parryMessage,
                enemyHitMessage,
                enemyMissMessage,
                enemyParryMessage);
        setEffect("AttackWithOnHitEffect");
        setEffectPowerMultiplier(effectPowerMultiplier);
        setEffectStatMultiplier(effectStatMultiplier);
        setEffectChance(effectChance);
        setEffectMessage(effectMessage);
        setEnemyEffectMessage(enemyEffectMessage);
    }
    /*
    public Flail(Character c){
        setCharacter(c);
        setName("Flail");
        List<String> type = new ArrayList<String>();
        type.add("Attack");
        type.add("Self Harm");
        type.add("Chance");
        type.add("Multi");
        setType(type);
        setAttackType("Physical");
        setPowerMultiplier(1);
        setStatMultiplier("Strength");
        setAccuracy(80);
        setCoolDown(0);
        setCurrentCoolDown(0);
        setEffectChance(50);
        setDescription("Ow! -Some Unlucky Bloke");

        setHitMessage(new ArrayList<String>());
        setMissMessage(new ArrayList<String>());
        setParryMessage(new ArrayList<String>());
        setEffectMessage(new ArrayList<String>());

        setEnemyHitMessage(new ArrayList<String>());
        setEnemyMissMessage(new ArrayList<String>());
        setEnemyParryMessage(new ArrayList<String>());
        setEnemyEffectMessage(new ArrayList<String>());

        addHitMessage("You cuffed him. (hit)");
        addMissMessage("Sorry, you got piss poor aim. (missed)");
        addParryMessage("You were unflailed. (you were parried)");
        addEffectMessage("You...actually hurt yourself flailing (triggered skill effect)");

        addEnemyHitMessage("He cuffed your face and you squealed. (enemy hit)");
        addEnemyMissMessage("This is the type of guy that has trouble pissing into the toilet at night. (enemy missed)");
        addEnemyParryMessage("You flailed his flail. (you parried)");
        addEnemyEffectMessage("XD he hit himself!");

    }
    */

    public void effect(){
        if (isEffectActivated()) {
            printEffectMessage();


            getCharacter().takeDamage(calculateDamage(getStatMultiplier())/2, getAttackType());
            getCharacter().onGetHit();
            getCharacter().onHit();
        }
    }

}
