package rpggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Skill {
    private Character character;
    private String name;
    private String skillType;
    private ArrayList<String> type;
    private String attackType;
    private double powerMultiplier;
    private int accuracy;
    private int cooldown;
    private int currentCooldown;
    private String statMultiplier;

    private String description;
    private ArrayList<String> hitMessage;
    private ArrayList<String> missMessage;
    private ArrayList<String> parryMessage;

    private ArrayList<String> enemyHitMessage;
    private ArrayList<String> enemyMissMessage;
    private ArrayList<String> enemyParryMessage;


    private String effect;
    private String effectTarget;
    private double effectPowerMultiplier;
    private String effectStatMultiplier;
    private String effectAttackType;    private int effectChance;
    private ArrayList<String> effectMessage;
    private ArrayList<String> enemyEffectMessage;

    public Character getCharacter(){return character;}
    public String getName(){ return name;}
    public String getSkillType() {return skillType;}
    public ArrayList<String> getType(){ return type;}
    public String getAttackType() { return attackType; }
    public double getPowerMultiplier(){ return powerMultiplier;}

    public int getAccuracy() {return accuracy;}
    public int getCooldown(){ return cooldown;}
    public int getCurrentCooldown() {return currentCooldown;}

    public String getStatMultiplier() {return statMultiplier;}

    public String getDescription() {return description;}
    public ArrayList<String> getHitMessage() {return hitMessage;}
    public ArrayList<String> getMissMessage() {return missMessage;}
    public ArrayList<String> getParryMessage() {return parryMessage;}
    public ArrayList<String> getEnemyHitMessage(){return enemyHitMessage;}
    public ArrayList<String> getEnemyMissMessage() {return enemyMissMessage;}
    public ArrayList<String> getEnemyParryMessage() {return enemyParryMessage;}

    public String getEffect() {return effect;}
    public String getEffectTarget() {return effectTarget;}
    public double getEffectPowerMultiplier(){ return effectPowerMultiplier;}
    public String getEffectStatMultiplier() {return effectStatMultiplier;}
    public int getEffectChance() {return effectChance;}
    public ArrayList<String> getEffectMessage() {return effectMessage;}
    public ArrayList<String> getEnemyEffectMessage() {return enemyEffectMessage;}

    public void setCharacter(Character c) {character = c;}
    public void setName(String n){ name = n;}
    public void setSkillType(String st) {skillType = st;}
    public void setType(ArrayList<String> t){ type = t;}
    public void setAttackType(String at){attackType = at;}
    public void setPowerMultiplier(double p){ powerMultiplier = p;}

    public void setAccuracy(int a){ accuracy = a;}
    public void setCoolDown(int cd){ cooldown = cd;}
    public void setCurrentCoolDown(int ccd) { currentCooldown = ccd;}

    public void setStatMultiplier(String s) {statMultiplier = s;}

    public void setDescription(String d) { description = d;}

    public void setHitMessage(ArrayList<String> l) {hitMessage = l;}
    public void setMissMessage(ArrayList<String> l) {missMessage = l;}
    public void setParryMessage(ArrayList<String> l) {parryMessage = l;}


    public void setEnemyHitMessage(ArrayList<String> l) {enemyHitMessage = l;}
    public void setEnemyMissMessage(ArrayList<String> l) {enemyMissMessage = l;}
    public void setEnemyParryMessage(ArrayList<String> l) {enemyParryMessage = l;}

    public void setEffect(String e) {effect = e;}
    public void setEffectTarget(String et) {effectTarget = et;}
    public void setEffectPowerMultiplier(double p){ effectPowerMultiplier = p;}
    public void setEffectStatMultiplier(String s) {effectStatMultiplier = s;}
    public void setEffectChance(int ec) {effectChance = ec;}
    public void setEffectMessage(ArrayList<String> l) {effectMessage = l;}
    public void setEnemyEffectMessage(ArrayList<String> l) {enemyEffectMessage = l;}

    public void addHitMessage(String s) {hitMessage.add(s);}
    public void addMissMessage(String s) {missMessage.add(s);}
    public void addParryMessage(String s) {parryMessage.add(s);}
    public void addEffectMessage(String s) {effectMessage.add(s);}

    public void addEnemyHitMessage(String s) {enemyHitMessage.add(s);}
    public void addEnemyMissMessage(String s) {enemyMissMessage.add(s);}
    public void addEnemyParryMessage(String s) {enemyParryMessage.add(s);}
    public void addEnemyEffectMessage(String s) {enemyEffectMessage.add(s);}

    public int currentAccuracy(){
        Random rand = new Random();
        int n = 0;
        try {
            n = rand.nextInt(character.getCurrentStat("Luck")) + 1;
        } catch (Exception e) {
            System.out.println("BAD BOUNDS IN CURRENT ACCURACY");
            System.out.println(character.getCurrentStat("Luck"));}
        return accuracy + character.getAccuracyBonus() + n;
    }

    public int currentEffectChance(){
        Random rand = new Random();
        int n = rand.nextInt(character.currentLuck())+1;
        return effectChance + n;
    }

    public boolean activate() {
        return true;
    }

    public boolean offCooldown() {
        return currentCooldown==0;
    }

    public void activateCooldown() {
        currentCooldown=cooldown+1;
    }

    public void effect() {}

    public String randomMessageSelector(List<String> list) {
        Random rand = new Random();
        int n = rand.nextInt(list.size());
        return list.get(n);
    }

    public void onCooldownMessage() {
        System.out.println(getName()+" is on cooldown for "+getCurrentCooldown()+" more turns. Select another skill or end your turn with [0].");
    }

    public void useSkillMessage() {
        System.out.println(getCharacter().getName() + " used " + getName());
    }

    public void printAttackMessage() {
        if (getCharacter().isPlayer()) {
            System.out.println(randomMessageSelector(getHitMessage()));
        } else {System.out.println(randomMessageSelector(getEnemyHitMessage()));}
    }

    public void printEffectMessage() {
        if (getCharacter().isPlayer()) {
            System.out.println(randomMessageSelector(getEffectMessage()));
        } else {System.out.println(randomMessageSelector(getEnemyEffectMessage()));}
    }
}
