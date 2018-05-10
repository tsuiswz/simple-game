package rpggame;

import java.util.List;
import java.util.Random;

public class Skill {
    private Character character;
    private String name;
    private List<String> type;
    private String attackType;
    private double powerMultiplier;
    private double effectPowerMultiplier;
    private int accuracy;
    private int cooldown;
    private int currentCooldown;
    private int effectChance;
    private String statMultiplier;
    private String effectStatMultiplier;
    private String description;
    private List<String> hitMessage;
    private List<String> missMessage;
    private List<String> parryMessage;
    private List<String> effectMessage;
    private List<String> enemyHitMessage;
    private List<String> enemyMissMessage;
    private List<String> enemyParryMessage;
    private List<String> enemyEffectMessage;

    public Character getCharacter(){return character;};
    public String getName(){ return name;}
    public List<String> getType(){ return type;}
    public String getAttackType() { return attackType; }
    public double getPowerMultiplier(){ return powerMultiplier;}
    public double getEffectPowerMultiplier(){ return effectPowerMultiplier;}
    public int getAccuracy() {return accuracy;}
    public int getCooldown(){ return cooldown;}
    public int getCurrentCooldown() {return currentCooldown;}
    public int getEffectChance() {return effectChance;}
    public String getStatMultiplier() {return statMultiplier;}
    public String getEffectStatMultiplier() {return effectStatMultiplier;}
    public String getDescription() {return description;}
    public List<String> getHitMessage() {return hitMessage;}
    public List<String> getMissMessage() {return missMessage;}
    public List<String> getParryMessage() {return parryMessage;}
    public List<String> getEffectMessage() {return effectMessage;}
    public List<String> getEnemyHitMessage(){return enemyHitMessage;}
    public List<String> getEnemyMissMessage() {return enemyMissMessage;}
    public List<String> getEnemyParryMessage() {return enemyParryMessage;}
    public List<String> getEnemyEffectMessage() {return enemyEffectMessage;}

    public void setCharacter(Character c) {character = c;}
    public void setName(String n){ name = n;}
    public void setType(List<String> t){ type = t;}
    public void setAttackType(String at){attackType = at;}
    public void setPowerMultiplier(double p){ powerMultiplier = p;}
    public void setEffectPowerMultiplier(double p){ effectPowerMultiplier = p;}
    public void setAccuracy(int a){ accuracy = a;}
    public void setCoolDown(int cd){ cooldown = cd;}
    public void setCurrentCoolDown(int ccd) { currentCooldown = ccd;}
    public void setEffectChance(int ec) {effectChance = ec;}
    public void setStatMultiplier(String s) {statMultiplier = s;}
    public void setEffectStatMultiplier(String s) {effectStatMultiplier = s;}
    public void setDescription(String d) { description = d;}

    public void setHitMessage(List<String> l) {hitMessage = l;}
    public void setMissMessage(List<String> l) {missMessage = l;}
    public void setParryMessage(List<String> l) {parryMessage = l;}
    public void setEffectMessage(List<String> l) {effectMessage = l;}

    public void setEnemyHitMessage(List<String> l) {enemyHitMessage = l;}
    public void setEnemyMissMessage(List<String> l) {enemyMissMessage = l;}
    public void setEnemyParryMessage(List<String> l) {enemyParryMessage = l;}
    public void setEnemyEffectMessage(List<String> l) {enemyEffectMessage = l;}

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

    public void activateCoolDown() {
        currentCooldown=cooldown+1;
    }

    public void effect() {}

    public String randomMessageSelector(List<String> list) {
        Random rand = new Random();
        int n = rand.nextInt(list.size());
        return list.get(n);
    }

    public void onCoolDownMessage() {
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
