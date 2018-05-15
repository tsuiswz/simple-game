package rpggame;

import java.util.ArrayList;

public class Character {
    private String name;
    private int level;

    private int currentHealthPoint;
    private int baseMaxHealthPoint;
    private int baseDefence;
    private int baseResistance;
    private int baseStrength;
    private int baseDexterity;
    private int baseIntelligence;
    private int baseLuck;

    private ArrayList<Skill> skills;
    private ArrayList<Effect> preEffects;
    private ArrayList<Effect> postEffects;

    private int temporaryMaxHealthPoint;
    private int temporaryDefence;
    private int temporaryResistance;
    private int temporaryStrength;
    private int temporaryDexterity;
    private int temporaryIntelligence;
    private int temporaryLuck;

    private int temporaryPiety;
    private int temporarySin;
    private int temporaryWillpower;

    private int basePiety;
    private int baseSin;
    private int baseWillpower;

    private int baseDodge;
    private int baseParry;

    private int temporaryDodge;
    private int temporaryParry;

    private double powerMultiplierBonus;
    private int powerFlatBonus;
    private double damageMultiplierBonus;
    private int damageFlatBonus;
    private int accuracyBonus;
    private double currentDamageReduction;

    private Character enemy;

    private boolean isPlayer;

    public String getName(){return name;}
    public int getLevel(){return level;}

    public int getCurrentHealthPoint(){return currentHealthPoint;}
    public int getBaseMaxHealthPoint(){return baseMaxHealthPoint;}
    public int getBaseDefence() {return baseDefence;}
    public int getBaseResistance(){return baseResistance;}
    public int getBaseStrength(){return baseStrength;}
    public int getBaseDexterity(){return baseDexterity;}
    public int getBaseIntelligence(){return baseIntelligence;}
    public int getBaseLuck(){return baseLuck;}
    public ArrayList<Skill> getSkills() {return skills;}
    public ArrayList<Effect> getPreEffects() {return preEffects;}
    public ArrayList<Effect> getPostEffects() {return postEffects;}
    public int getBasePiety(){return basePiety;}
    public int getBaseSin(){return baseSin;}
    public int getBaseWillpower(){return baseWillpower;}
    public int getBaseDodge(){return baseDodge;}
    public int getBaseParry(){return baseParry;}
    public Character getEnemy() {return enemy;}

    public int getTemporaryMaxHealthPoint(){return temporaryMaxHealthPoint;}
    public int getTemporaryDefence() {return temporaryDefence;}
    public int getTemporaryResistance(){return temporaryResistance;}
    public int getTemporaryStrength(){return temporaryStrength;}
    public int getTemporaryDexterity(){return temporaryDexterity;}
    public int getTemporaryIntelligence(){return temporaryIntelligence;}
    public int getTemporaryLuck(){return temporaryLuck;}
    public int getTemporaryPiety(){return temporaryPiety;}
    public int getTemporarySin(){return temporarySin;}
    public int getTemporaryWillpower(){return temporaryWillpower;}
    public int geTemporaryDodge(){return temporaryDodge;}
    public int getTemporaryParry(){return temporaryParry;}

    public void setName(String s){name = s;}
    public void setLevel(int lvl){level = lvl;}

    public void setCurrentHealthPoint(int n){currentHealthPoint = n;}
    public void setBaseMaxHealthPoint(int n){baseMaxHealthPoint = n;}
    public void setBaseDefence(int n) {baseDefence = n;}
    public void setBaseResistance(int n){baseResistance = n;}
    public void setBaseStrength(int n){baseStrength = n;}
    public void setBaseDexterity(int n){baseDexterity = n;}
    public void setBaseIntelligence(int n){baseIntelligence = n;}
    public void setBaseLuck(int n){ baseLuck = n;}
    public void setSkills(ArrayList<Skill> newSkills) {skills = newSkills;}
    public void setPreEffects(ArrayList<Effect> newEffects) {preEffects = newEffects;}
    public void addPreEffect(Effect e) {preEffects.add(e);}
    public void setPostEffects(ArrayList<Effect> newEffects) {postEffects = newEffects;}
    public void addPostEffect(Effect e) {postEffects.add(e);}
    public void setBasePiety(int n){basePiety = n;}
    public void setBaseSin(int n){baseSin = n;}
    public void setBaseWillpower(int n){baseWillpower = n;}
    public void setBaseDodge(int n){baseDodge = n;}
    public void setBaseParry(int n){baseParry = n;}
    public void setEnemy(Character e) {enemy = e;}
    public void setIsPlayer(boolean tf) {isPlayer = tf;}

    public double getPowerMultiplierBonus(){return powerMultiplierBonus;}
    public int getPowerFlatBonus(){return powerFlatBonus;}
    public double getDamageMultiplierBonus(){return damageMultiplierBonus;}
    public int getDamageFlatBonus(){return damageFlatBonus;}
    public int getAccuracyBonus(){return accuracyBonus;}
    public double getCurrentDamageReduction(){return currentDamageReduction;}

    public void setPowerMultiplierBonus(double n){powerMultiplierBonus = n;}
    public void setPowerFlatBonus(int n){powerFlatBonus = n;}
    public void setDamageMultiplierBonus(double n){damageMultiplierBonus = n;}
    public void setDamageFlatBonus(int n){damageFlatBonus = n;}
    public void setAccuracyBonus(int n){accuracyBonus = n;}
    public void setCurrentDamageReduction(double n){currentDamageReduction = n;}

    public void resetTemporary() {
        powerMultiplierBonus = 1;
        powerFlatBonus = 0;
        damageFlatBonus = 0;
        damageMultiplierBonus = 1;
        accuracyBonus = 0;
    }

    public void resetStatus() {
        //List of pre-turn and post-turn Status Effects resets
    }

    public int getCurrentMaxHealthPoint(){return baseMaxHealthPoint + temporaryMaxHealthPoint;}
    public int getCurrentDefence() {return baseDefence + temporaryDefence;}
    public int getCurrentResistance(){return baseResistance + temporaryResistance;}
    public int getCurrentStrength(){return baseStrength + temporaryStrength;}
    public int getCurrentDexterity(){return baseDexterity + temporaryDexterity;}
    public int getCurrentIntelligence(){return baseIntelligence + temporaryIntelligence;}
    public int getCurrentLuck(){return baseLuck + temporaryLuck;}
    public int getCurrentPiety(){return basePiety + temporaryPiety;}
    public int getCurrentSin(){return baseSin + temporarySin;}
    public int getCurrentWillpower(){return baseWillpower + temporaryWillpower;}
    public int getCurrentDodge(){return baseDodge + temporaryDodge;}
    public int getCurrentParry(){return baseParry + temporaryParry;}

    public void setTemporaryMaxHealthPoint(int n){temporaryMaxHealthPoint = n;}
    public void setTemporaryDefence(int n) {temporaryDefence = n;}
    public void setTemporaryResistance(int n){temporaryResistance = n;}
    public void setTemporaryStrength(int n){temporaryStrength = n;}
    public void setTemporaryDexterity(int n){temporaryDexterity = n;}
    public void setTemporaryIntelligence(int n){temporaryIntelligence = n;}
    public void setTemporaryLuck(int n){ temporaryLuck = n;}
    public void setTemporaryPiety(int n){temporaryPiety = n;}
    public void setTemporarySin(int n){temporarySin = n;}
    public void setTemporaryWillpower(int n){temporaryWillpower = n;}
    public void setTemporaryDodge(int n){temporaryDodge = n;}
    public void setTemporaryParry(int n){temporaryParry = n;}

    public boolean isPlayer() {return isPlayer;}

    public void equipSkill(Skill s) {
        s.setCharacter(this);
        skills.add(s);
    }
    /* scrapped stuff
    public boolean isHit(Character hitter, int special) {
        if (special == -1) {
            return true;
        }
        Random rand = new Random();
        int n = rand.nextInt(100)+1;

        if (n<currentParry()){
            this.onParry();
            hitter.onGetParried();
            return false;
        }

        int t = rand.nextInt(100)+1;

        if (t<currentDodge()){
            this.onDodge();
            hitter.onMiss();
            return false;
        }
        return true;
    }
    */

    public int currentLuck() { return baseLuck + temporaryLuck;}

    public int currentParry(){ return baseParry + temporaryParry;}

    public int currentDodge(){ return baseDodge + temporaryDodge;}

    public void onHit() {

    }

    public void onGetHit() {

    }

    public void onDodge() {

    }

    public void onMiss() {

    }

    public void onParry() {

    }

    public void onGetParried() {

    }

    public void onApplyEffect() {

    }


    public void takeDamage(int calculatedDamage, String attackType) {
        int actualDamage;
        switch (attackType) {
            case "Physical": actualDamage = Math.max(0, (int) ((calculatedDamage - getCurrentDefence()) * getCurrentDamageReduction())); break;
            case "Magical": actualDamage = Math.max(0, (int) ((calculatedDamage - getCurrentResistance()) * getCurrentDamageReduction())); break;
            default: actualDamage = Math.max(0, calculatedDamage);
        }
        int temp = currentHealthPoint;
        currentHealthPoint -= actualDamage;
        System.out.println(getName()+" HP: "+temp+"->"+currentHealthPoint);
    }

    public void showCharacterDetails() {
        System.out.println("Lvl "+getLevel()+" "+getName());
        for (Skill s: getSkills()) {
            System.out.println(s.getName());
        }
        System.out.println(getCurrentHealthPoint()+"/"+getCurrentMaxHealthPoint());
        System.out.println("Strength: "+getCurrentStrength());
        System.out.println("Dexterity: "+getCurrentDexterity());
        System.out.println("Intelligence: "+getCurrentIntelligence());
        System.out.println("Defence: "+getCurrentDefence());
        System.out.println("Resistance: "+getCurrentResistance());
        System.out.println("Luck: "+getCurrentLuck());
        System.out.println("Dodge: "+getCurrentDodge());
        System.out.println("Parry: "+getCurrentParry());
        System.out.println("Sin: "+getCurrentSin());
        System.out.println("Piety: "+getCurrentPiety());
        System.out.println("Willpower: "+getCurrentWillpower());
    }

    public void showSkill(int n) {
        Skill skill = getSkills().get(n-1);
        System.out.println(skill.getName());
        System.out.println(skill.getDescription());
        System.out.println("Scales off of: "+skill.getStatMultiplier());
        System.out.println("by: "+skill.getPowerMultiplier());
        System.out.println("Accuracy: "+skill.getAccuracy());
        System.out.println("Current cooldown: "+skill.getCurrentCooldown());
        System.out.println("Cooldown:  "+skill.getCooldown());
    }

    public int getBaseStat(String statType) {
        switch (statType) {
            case "Max Health Point":
                return baseMaxHealthPoint;
            case "Strength":
                return baseStrength;
            case "Dexterity":
                return baseDexterity;
            case "Intelligence":
                return baseIntelligence;
            case "Defence":
                return baseDefence;
            case "Resistance":
                return baseResistance;
            case "Luck":
                return baseLuck;
            case "Dodge":
                return baseDodge;
            case "Parry":
                return baseParry;
            case "Sin":
                return baseSin;
            case "Piety":
                return basePiety;
            case "Willpower":
                return baseWillpower;
            default:
                return 0;
        }
    }

    public int getTemporaryStat(String statType) {
        switch (statType) {
            case "Max Health Point":
                return temporaryMaxHealthPoint;
            case "Strength":
                return temporaryStrength;
            case "Dexterity":
                return temporaryDexterity;
            case "Intelligence":
                return temporaryIntelligence;
            case "Defence":
                return temporaryDefence;
            case "Resistance":
                return temporaryResistance;
            case "Luck":
                return temporaryLuck;
            case "Dodge":
                return temporaryDodge;
            case "Parry":
                return temporaryParry;
            case "Sin":
                return temporarySin;
            case "Piety":
                return temporaryPiety;
            case "Willpower":
                return temporaryWillpower;
            default:
                return 0;
        }
    }

    public int getCurrentStat(String statType) {
        switch (statType) {
            case "Max Health Point":
                return getCurrentMaxHealthPoint();
            case "Strength":
                return getCurrentStrength();
            case "Dexterity":
                return getCurrentDexterity();
            case "Intelligence":
                return getCurrentIntelligence();
            case "Defence":
                return getCurrentDefence();
            case "Resistance":
                return getCurrentResistance();
            case "Luck":
                return getCurrentLuck();
            case "Dodge":
                return getCurrentDodge();
            case "Parry":
                return getCurrentParry();
            case "Sin":
                return getCurrentSin();
            case "Piety":
                return getCurrentPiety();
            case "Willpower":
                return getCurrentWillpower();
            default:
                return 0;
        }
    }

    public void setBaseStat(String statType, int n) {
        switch (statType) {
            case "Max Health Point":
                baseMaxHealthPoint=n;
            case "Strength":
                baseStrength=n;
            case "Dexterity":
                baseDexterity=n;
            case "Intelligence":
                baseIntelligence=n;
            case "Defence":
                baseDefence=n;
            case "Resistance":
                baseResistance=n;
            case "Luck":
                baseLuck=n;
            case "Dodge":
                baseDodge=n;
            case "Parry":
                baseParry=n;
            case "Sin":
                baseSin=n;
            case "Piety":
                basePiety=n;
            case "Willpower":
                baseWillpower=n;
                break;
            default:
                System.out.println("You tried setting a base stat but it failed.");
        }
    }

    public void setTemporaryStat(String statType, int n) {
        switch (statType) {
            case "Max Health Point":
                temporaryMaxHealthPoint=n;
            case "Strength":
                temporaryStrength=n;
            case "Dexterity":
                temporaryDexterity=n;
            case "Intelligence":
                temporaryIntelligence=n;
            case "Defence":
                temporaryDefence=n;
            case "Resistance":
                temporaryResistance=n;
            case "Luck":
                temporaryLuck=n;
            case "Dodge":
                temporaryDodge=n;
            case "Parry":
                temporaryParry=n;
            case "Sin":
                temporarySin=n;
            case "Piety":
                temporaryPiety=n;
            case "Willpower":
                temporaryWillpower=n;
                break;
            default:
                System.out.println("You tried setting a temporary stat but it failed.");
        }
    }

    public void reset() {
        resetSkills();
        preEffects.clear();
        postEffects.clear();
        resetTempStats();
        currentHealthPoint = baseMaxHealthPoint;
    }

    public void resetTempStats() {
        setTemporaryStat("Max Health Point", 0);
        setTemporaryStat("Strength", 0);
        setTemporaryStat("Dexterity", 0);
        setTemporaryStat("Intelligence", 0);
        setTemporaryStat("Defence", 0);
        setTemporaryStat("Resistance", 0);
        setTemporaryStat("Luck", 0);
        setTemporaryStat("Dodge", 0);
        setTemporaryStat("Parry", 0);
        setTemporaryStat("Sin", 0);
        setTemporaryStat("Piety", 0);
        setTemporaryStat("Willpower", 0);
    }

    public void resetSkills() {
        for (Skill s: getSkills()) {s.setCurrentCoolDown(0);}
    }
}
