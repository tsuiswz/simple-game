package rpggame;

import java.util.ArrayList;
import java.util.List;

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
                                                 (EVERY LVL CHOOSE TO UPGRADE A CURRENT SKILL OR ACQUIRE NEXT SKILL)
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
    public static void main(String[] args) {
        Player player1 = new Player("Player 1",1, 0, 100, 100, 2, 5, 1, 5, 1, 10, 2, 10, 1, 10, 1, 70, 1);
        Player player2 = new Player("Player 2",1, 0, 100, 100, 2, 5, 1, 5, 1, 10, 2, 10, 1, 10, 1, 1, 1);
        Player player3 = new Player("Player 3",1, 0, 100, 100, 2, 5, 1, 5, 1, 10, 2, 10, 1, 10, 1, 1, 1);
        Battle testBattle = new Battle(player1, player3);
        //Battle testBattle2 = new Battle(player1, player2);
        player2.setIsPlayer(false);
        player3.setIsPlayer(false);
        List<Skill> skills1 = new ArrayList<>();
        List<Skill> skills2 = new ArrayList<>();
        List<Skill> skills3 = new ArrayList<>();
        skills1.add(new Flail(player1));
        skills1.add(new SubtleInsult(player1));
        skills1.add(new PencilStab(player1));
        skills2.add(new Flail(player2));
        skills2.add(new SubtleInsult(player2));
        player1.setSkills(skills1);
        player2.setSkills(skills2);
        player3.setSkills(skills3);
        while (true) {
            player1.reset();
            player2.reset();
            player3.reset();
            testBattle.startBattle();
        }
    }
}