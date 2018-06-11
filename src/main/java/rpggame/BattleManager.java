package rpggame;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class BattleManager {

    /* here for reference
      String name,
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
      int growthLuck
    */
    /*
    THINGS TO ADD AND IMPLEMENT (IN NO PARTICULAR ORDER OF IMPORTANCE):

    REALLY CLEAN UP/ORGANIZE CODE

    A SAVE SYSTEM?

    A GRAPHICAL DISPLAY (MUSIC WOULD BE NICE): USES THREADS? PIXELATED?
                                             : DISPLAYS SKILLS AND CD AND DESCRIPTION WHEN SCROLLED OVER
                                             : HP BARS, POKEMON-ESQUE, WORD BUBBLE SKILL MSGS EVERY FEW TIME A SKILL IS USED
                                             : JOLTS IF HIT, SIDEWAY MOVEMENT FOR DODGE/MISS/PARRY?,

    LEVEL UP SYSTEM: LEVEL UP HEALS YOU (OR NOT)
                     GIVES RANDOM UPGRADE CHANCE (EVERY 10 LVLS CHOOSE AN ULTIMATE SKILL, LIMITED TO ONE AT A TIME)
                                                 (EVERY LVL CHOOSE TO UPGRADE A CURRENT SKILL OR ACQUIRE NEW SKILL)
                     CLASS CHANGE AT LVL X1, X2, X3, OPENING SKILL POOLS AT HIGHER TIER JOBS/CLASS

    ENEMY GENERATION: SELECT RANDOMLY FROM A MAP?

    TIERED AI LEVEL: (T1: RANDOMLY USES SKILLS)
                    (T2: USES DEBUFFS AT THE START, USES HEALS WHEN LOW)
                    (T3: USES DEFENSIVE SKILLS WHEN ENEMY USES SOME SORT OF TELEGRAPHED CHARGE ATTACK,
                    ATTACKS OVER DEBUFFS IF CALCULATES NEXT HIT WILL KILL,
                    PRIORITIZES ATK SKILLS WITH MOST DMG AGAINST ENEMY'S DEFENSE,
                    USES DEBUFF CLEANSERS WHEN DETECTED TO HAVE DEBUFFS, IGNORES INSIGNIFICANT DEBUFFS IF TURN CAN BE BETTER SPENT
                    PLAYS MORE OR LESS LIKE A REAL PLAYER
                    SHOULD WIN OR TIE AGAINST LOWER TIER AIS EVERY TIME)
                    (T4: FOR ELITE/BOSS ENEMIES WITH PRESET SKILLS, HAS CERTAIN SKILL ROTATION/COMBOS, UNIQUE FOR EACH ENEMY)

    EQUIPMENT SYSTEM:
                    EG. PENCIL SHARPENER {INCREASES PENCIL RELATE DMGS, REDUCES PEN RELATED DMGS}
                        SCHOOL LUNCH {ATTACKS HAVE A CHANCE TO POISON BOTH THE USER AND THE DMG RECEIVER}

    SKILL UPGRADE SYSTEM: (FLAIL --> WILD SWING --> DOUBLE EDGED STRIKE)

    RANDOM SPECIAL SKILL CHANGE: (ADDS PRE OR POSTFIX: FLAIL --> CONTROLLED FLAIL OR GUARDING FLAIL OR FLAIL OF STUN OR FLAMING FLAIL)

    SOME SORT OF LEVEL/FLOOR/CLASSROOM/ PROGRESSION

     */

    static int DEFAULT_BASE_MAX_HEALTH_POINT = 100;
    static int DEFAULT_GROWTH_BASE_MAX_HEALTH_POINT = 2;
    static int DEFAULT_BASE_DEFENCE = 5;
    static int DEFAULT_GROWTH_DEFENCE = 1;
    static int DEFAULT_BASE_RESISTANCE = 5;
    static int DEFAULT_GROWTH_RESISTANCE = 1;
    static int DEFAULT_BASE_STRENGTH = 10;
    static int DEFAULT_GROWTH_STRENGTH = 2;
    static int DEFAULT_BASE_DEXTERITY = 10;
    static int DEFAULT_GROWTH_DEXTERITY = 2;
    static int DEFAULT_BASE_INTELLIGENCE = 10;
    static int DEFAULT_GROWTH_INTELLIGENCE = 2;
    static int DEFAULT_BASE_LUCK = 0;
    static int DEFAULT_GROWTH_LUCK = 0;

    static int DEFAULT_STAT_VARIANCE = 20;
    static int DEFAULT_STAT_LOWER_LIMIT = 90;

    static int DEFAULT_AMOUNT_OF_SKILLS = 2;

    public static void main(String[] args) {

        Player player1 = new Player(
                "Player 1",
                1,
                0,
                110,
                110,
                2,
                5,
                1,
                5,
                1,
                12,
                2,
                12,
                1,
                12,
                1,
                0,
                1);

        player1.setIsPlayer(true);
        player1.equipSkill(getSkill("Slash"));
        player1.equipSkill(getSkill("Yell At"));

        int score = 0;
        boolean progress = true;
        while (progress) {
            player1.reset();
            Battle fight = new Battle(player1, randomEnemyGenerator(player1.getLevel()));
            progress = fight.startBattle();
            if (progress == true) {
                score++;
            }
        }
        System.out.println("Your score is "+score+".");
    }

    private static Skill getSkill(String name){
        Gson gson = new Gson();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/SkillsList.json"));
            SkillList skill = gson.fromJson(br, SkillList.class);

            if (skill!=null) {
                for (int i=0; i<skill.list.size(); i++) {
                    if (skill.list.get(i).getName().equals(name)){
                        return correctSkillForm(skill.list.get(i));
                    }
                }
            }
            return null;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (br!=null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Skill getRandomSkill(){
        Gson gson = new Gson();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/SkillsList.json"));
            SkillList skill = gson.fromJson(br, SkillList.class);

            Random rand = new Random();
            int i = rand.nextInt(skill.list.size());
            return correctSkillForm(skill.list.get(i));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (br!=null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Skill correctSkillForm(Skill s) {
        switch (s.getSkillType()) {
            case "AttackSkill": return new AttackSkill(s.getName(),
                                                   s.getType(),
                                                   s.getAttackType(),
                                                   s.getHits(),
                                                   s.getPowerMultiplier(),
                                                   s.getStatMultiplier(),
                                                   s.getAccuracy(),
                                                   s.getCooldown(),
                                                   s.getDescription(),
                                                   s.getHitMessage(),
                                                   s.getMissMessage(),
                                                   s.getParryMessage(),
                                                   s.getEnemyHitMessage(),
                                                   s.getEnemyMissMessage(),
                                                   s.getEnemyParryMessage());
            case "AttackWithOnHitEffect": return new AttackWithOnHitEffect(
                    s.getName(),
                    s.getType(),
                    s.getAttackType(),
                    s.getHits(),
                    s.getPowerMultiplier(),
                    s.getStatMultiplier(),
                    s.getAccuracy(),
                    s.getCooldown(),
                    s.getDescription(),
                    s.getHitMessage(),
                    s.getMissMessage(),
                    s.getParryMessage(),
                    s.getEnemyHitMessage(),
                    s.getEnemyMissMessage(),
                    s.getEnemyParryMessage(),
                    s.getEffect(),
                    s.getEffectTarget(),
                    s.getEffectPowerMultiplier(),
                    s.getEffectStatMultiplier(),
                    s.getAttackType(),
                    s.getEffectChance(),
                    s.getEffectMessage(),
                    s.getEnemyEffectMessage()
                    );
            default: return new AttackSkill(s.getName(),
                    s.getType(),
                    s.getAttackType(),
                    s.getHits(),
                    s.getPowerMultiplier(),
                    s.getStatMultiplier(),
                    s.getAccuracy(),
                    s.getCooldown(),
                    s.getDescription(),
                    s.getHitMessage(),
                    s.getMissMessage(),
                    s.getParryMessage(),
                    s.getEnemyHitMessage(),
                    s.getEnemyMissMessage(),
                    s.getEnemyParryMessage());
        }
    }

    private static Character randomEnemyGenerator(int level) {
        Random rand = new Random();

        int baseMaxHealthPoint = varyNumber(DEFAULT_BASE_MAX_HEALTH_POINT+level*DEFAULT_GROWTH_BASE_MAX_HEALTH_POINT);
        int growthMaxHealthPoint = varyNumber(DEFAULT_GROWTH_BASE_MAX_HEALTH_POINT);

        int baseDefence = varyNumber(DEFAULT_BASE_DEFENCE+level*DEFAULT_GROWTH_DEFENCE);
        int baseResistance = varyNumber(DEFAULT_BASE_RESISTANCE+level*DEFAULT_GROWTH_RESISTANCE);
        int baseStrength = varyNumber(DEFAULT_BASE_STRENGTH+level*DEFAULT_GROWTH_STRENGTH);
        int baseDexterity = varyNumber(DEFAULT_BASE_DEXTERITY+level*DEFAULT_GROWTH_DEXTERITY);
        int baseIntelligence = varyNumber(DEFAULT_BASE_INTELLIGENCE+level*DEFAULT_GROWTH_INTELLIGENCE);
        int baseLuck = varyNumber(DEFAULT_BASE_LUCK+level*DEFAULT_GROWTH_LUCK);

        int growthDefence = varyNumber(DEFAULT_GROWTH_DEFENCE);
        int growthResistance = varyNumber(DEFAULT_GROWTH_RESISTANCE);
        int growthStrength = varyNumber(DEFAULT_GROWTH_STRENGTH);
        int growthDexterity = varyNumber(DEFAULT_GROWTH_DEXTERITY);
        int growthIntelligence = varyNumber(DEFAULT_GROWTH_INTELLIGENCE);
        int growthLuck = varyNumber(DEFAULT_GROWTH_LUCK);

        Character enemy = new Player(
                "Aggressive Student",
                level,
                0,
                baseMaxHealthPoint,
                baseMaxHealthPoint,
                growthMaxHealthPoint,
                baseDefence,
                growthDefence,
                baseResistance,
                growthResistance,
                baseStrength,
                growthStrength,
                baseDexterity,
                growthDexterity,
                baseIntelligence,
                growthIntelligence,
                baseLuck,
                growthLuck
                );
        for (int i = 0; i<DEFAULT_AMOUNT_OF_SKILLS; i++) {
            enemy.equipSkill(getRandomSkill());
        }

        enemy.setIsPlayer(false);
        return enemy;
    }
    /*
    para@: int num
    Used in randomEnemyGenerator.
    Takes in a stat number and returns it after varying the value a bit to create randomness
    so each enemy is produced with different quality.
     */
    private static int varyNumber(int num) {
        Random rand = new Random();
        double n = (double)(DEFAULT_STAT_LOWER_LIMIT + rand.nextInt(DEFAULT_STAT_VARIANCE))/ (double) 100;
        return (int) ((n) * (num));
    }
}
