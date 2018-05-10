package rpggame;

import java.util.ArrayList;

public class Player extends Character {
    private int exp;
    private int expToLevelUp;

    private int growthBaseMaxHealthPoint;
    private int growthDefence;
    private int growthResistance;
    private int growthStrength;
    private int growthDexterity;
    private int growthIntelligence;
    private int growthLuck;

    private int growthPiety;
    private int growthSin;
    private int growthWillpower;


    public Player(String name,
                  int level,
                  int exp,
                  int currentHealthPoint,
                  int baseMaxHealthPoint,
                  int growthBaseMaxHealthPoint,
                  int baseDefence,
                  int growthDefence,
                  int baseResistance,
                  int growthResistance,
                  int baseStrength,
                  int growthStrength,
                  int baseDexterity,
                  int growthDexterity,
                  int baseIntelligence,
                  int growthIntelligence,
                  int baseLuck,
                  int growthLuck){
        setName(name);
        setLevel(level);
        setExp(exp);
        setBaseMaxHealthPoint(baseMaxHealthPoint);
        setCurrentHealthPoint(currentHealthPoint);
        setBaseDefence(baseDefence);
        setBaseResistance(baseResistance);
        setBaseStrength(baseStrength);
        setBaseDexterity(baseDexterity);
        setBaseIntelligence(baseIntelligence);
        setBaseLuck(baseLuck);
        setBaseDodge(0);
        setBaseParry(0);
        setGrowthBaseMaxHealthPoint(growthBaseMaxHealthPoint);
        setGrowthDefence(growthDefence);
        setGrowthResistance(growthResistance);
        setGrowthStrength(growthStrength);
        setGrowthDexterity(growthDexterity);
        setGrowthIntelligence(growthIntelligence);
        setGrowthLuck(growthLuck);
        setSkills(new ArrayList<Skill>());
        setPreEffects(new ArrayList<Effect>());
        setPostEffects(new ArrayList<Effect>());
        setIsPlayer(true);
        setPowerMultiplierBonus(1);
        setDamageMultiplierBonus(1);
        setCurrentDamageReduction(1);
        setBaseSin(0);
        setBasePiety(0);
        setBaseWillpower(0);
        setGrowthSin(0);
        setGrowthPiety(0);
        setGrowthWillpower(0);
    }

    public int getExp() {return exp;}
    public int getExpToLevelUp() {return expToLevelUp;}
    public int getGrowthBaseMaxHealthPoint() {return growthBaseMaxHealthPoint;}
    public int getGrowthDefence(){return growthDefence;}
    public int getGrowthResistance(){return growthResistance;}
    public int getGrowthStrength(){return growthStrength;}
    public int getGrowthDexterity(){return growthDexterity;}
    public int getGrowthIntelligence(){return growthIntelligence;}
    public int getGrowthLuck(){return growthLuck;}

    public int getGrowthSin(){return growthSin;}
    public int getGrowthPiety(){return growthPiety;}
    public int getGrowthWillPower(){return growthWillpower;}

    public void setExp(int n){exp = n;}
    public void setExpToLevelUp(int n){expToLevelUp = n;}
    public void setGrowthBaseMaxHealthPoint(int n){growthBaseMaxHealthPoint = n;}
    public void setGrowthDefence(int n){growthDefence = n;}
    public void setGrowthResistance(int n){growthResistance = n;}
    public void setGrowthStrength(int n){growthStrength = n;}
    public void setGrowthDexterity(int n){growthDexterity = n;}
    public void setGrowthIntelligence(int n){growthIntelligence = n;}
    public void setGrowthLuck(int n){growthLuck = n;}

    public void setGrowthSin(int n){growthSin = n;}
    public void setGrowthPiety(int n){growthPiety = n;}
    public void setGrowthWillpower(int n){growthWillpower = n;}

}
