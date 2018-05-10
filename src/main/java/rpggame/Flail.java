package rpggame;


import java.util.ArrayList;
import java.util.List;

public class Flail extends AttackSkill {
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

    public void effect(){
        if (isEffectActivated()) {
            printEffectMessage();
            getCharacter().takeDamage(calculateDamage(getStatMultiplier())/2, getAttackType());
            getCharacter().onGetHit();
            getCharacter().onHit();
        }
    }
}
