package rpggame;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Battle {
    boolean charOneTurn; // True when its char1's turn, false if it's char2's turn
    Character char1;
    Character char2;
    boolean battleEnd; // Set to false when one character, char1 or char2 is at or below zero current hp, true otherwise
    boolean endOfTurn; // Set to false when a char uses a turn ending skill or has no skills left off cooldown.
                       // Reset back back true afterwards when passing turns rights over
    int TURN_INTERVAL = 1; // Seconds between each turn

    public Battle(Character char1, Character char2){
        charOneTurn = true;
        this.char1 = char1;
        this.char2 = char2;
        char1.setEnemy(char2);
        char2.setEnemy(char1);
        battleEnd = false;
        endOfTurn = false;
    }

    public void startBattle() {
        battleEnd = false;
        charOneTurn = true;
        endOfTurn = false;
        System.out.println("Starting battle between "+char1.getName()+" and "+char2.getName()+".");
        while (!battleEnd) {
            characterTurn();
        }
        System.out.println("Battle Ended.");
        whoWon();
    }

    public Character getCurrentTurnsChar() {
        if (charOneTurn) {
            return char1;
        }
        return char2;
    }

    public void turnStart() {
        for (Skill s: getCurrentTurnsChar().getSkills()) {
            s.setCurrentCoolDown(Math.max(0, s.getCurrentCooldown()-1));
        }

        activateAll(getCurrentTurnsChar().getPreEffects());
        trashOverdueEffects(getCurrentTurnsChar().getPreEffects());
    }

    public void turnEnd() {
        activateAll(getCurrentTurnsChar().getPostEffects());
        trashOverdueEffects(getCurrentTurnsChar().getPostEffects());

        //Used for checking list of post effects (Moved down)
        /*for (Effect e: getCurrentTurnsChar().getPostEffects()) {
            System.out.println(e.getName());
            System.out.println(e.getTurnsLeft());
        }*/
    }

    public void trashOverdueEffects(List<Effect> effects) {
        for (int i=0; i<effects.size(); i++) {
            if (effects.get(i).isOverdue()) {
                effects.remove(i);
            }
        }
    }

    public void checkBattleEnd() {
        if (isDead(char1) || isDead(char2))
            battleEnd = true;
    }

    public void whoWon() {
        if ((isDead(char1) && isDead(char2))) {
            System.out.println("It's a double knockout!");
        } else if (isDead(char2)) {
            System.out.println(char1.getName() + " has claimed victory against " + char2.getName() + "\n");
        } else {System.out.println(char2.getName()+" has claimed victory against "+char1.getName() + "\n");}
    }

    public boolean isDead(Character c) {return c.getCurrentHealthPoint()<=0;}

    public boolean isSkillsAvailable() {
        for (Skill s: getCurrentTurnsChar().getSkills()) {
            if (s.getCurrentCooldown()==0) {
                return true;
            }
        }
        return false;
    }

    public void characterTurn() {
        turnStart(); //checks for effects like stun, weakened etc
        //character action phase:
        List<Integer> repeatAction = new ArrayList<>();
        while (!endOfTurn) {
            if (getCurrentTurnsChar().isPlayer()) {
                showSkills();
                System.out.print("\nYour turn: ");
                Scanner user_input = new Scanner(System.in);
                String input = user_input.next();
                if (isInteger(input)) {
                    int inputNumber = (Integer.parseInt(input));
                    if (validNumberInput(inputNumber)) {
                        switch (inputNumber) {
                            case 0:
                                endOfTurn = true;
                                break;
                            case -1:
                                lookAtSkill();
                                break;
                            case -2:
                                getCurrentTurnsChar().showCharacterDetails();
                                break;
                            case -3:
                                getCurrentTurnsChar().getEnemy().showCharacterDetails();
                                break;
                            default:
                                if (repeatAction.contains(inputNumber)) {
                                    System.out.println("I'm sorry if I didn't make it clear but please press another number.");
                                }
                                if (getCurrentTurnsChar().getSkills().get(inputNumber - 1).activate()) {
                                    endOfTurn = true;
                                }
                                repeatAction.add(inputNumber);
                                break;
                        }
                    } else {
                        System.out.println("Invalid number: please try again ;).");
                    }

                } else {
                    System.out.println("Invalid input: Please try again ;).");
                }
            } else {computerTurn();}
        }
        System.out.println(char1.getName() + ": " + char1.getCurrentHealthPoint() + " | " + char2.getName() + ": " + char2.getCurrentHealthPoint());
        checkBattleEnd();
        turnEnd(); // checks for effects like poison, burn etc
        endOfTurn = false;
        charOneTurn = !charOneTurn;
        System.out.println("");
        try {
            TimeUnit.SECONDS.sleep(TURN_INTERVAL);
        } catch (InterruptedException e) {} //forcing time between turns
    }

    public void showSkills() {
        for (Skill s: getCurrentTurnsChar().getSkills()) {
            System.out.print("[" + (getCurrentTurnsChar().getSkills().indexOf(s) + 1) + "]" + s.getName() + ", ");
        }
    }

    /*public boolean allDigits(String input) {
        return input.matches("\\d+");
    }
    */

    public boolean validNumberInput(int input) {
        return input <= getCurrentTurnsChar().getSkills().size() && input>=-3;
    }

    public void lookAtSkill() {
        boolean x = true;
        while (x) {
            System.out.print("Look at skill: ");
            Scanner skillNumberInput = new Scanner(System.in);
            String skillInput = skillNumberInput.next();
            if (isInteger(skillInput)) {
                int skillNumber = Integer.parseInt(skillInput);
                if (skillNumber == 0) {
                    break;
                }
                if (skillNumber <= getCurrentTurnsChar().getSkills().size() && skillNumber > 0) {
                    getCurrentTurnsChar().showSkill(skillNumber);
                    break;
                } else {
                    System.out.println("Invalid number: Please try again.");
                }
            } else {System.out.println("Invalid input: Please try again.");}
        }
    }

    public void computerTurn() {
        System.out.println(getCurrentTurnsChar().getName()+" turn:");
        if (isSkillsAvailable()) {
            ArrayList<Skill> skills = getCurrentTurnsChar().getSkills();
            ArrayList<Integer> skillsToChoose = new ArrayList<>();

            for (int i=0; i<skills.size(); i++) {
                Skill skill = skills.get(i);
                if (skill.offCooldown()) {
                    skillsToChoose.add(i);
                }
            }

            Random rand = new Random();
            int n = rand.nextInt(skillsToChoose.size());
            skills.get(skillsToChoose.get(n)).activate();
            endOfTurn = true;
        } else {
            System.out.println(getCurrentTurnsChar().getName() + " did not do anything.");
            endOfTurn = true;
        }
    }

    /*
    One layer deeper of thinking in CPU turn
     */

    public void computerTier2Turn() {
        System.out.println(getCurrentTurnsChar().getName()+" turn:");
        if (isSkillsAvailable()) {
            ArrayList<Skill> skills = getCurrentTurnsChar().getSkills();
            List<Integer> skillsToChoose = new ArrayList<Integer>();

            // If debuffed, add cleanse skills to the list of skills to choose from
            if (isCharDebuffed(getCurrentTurnsChar())) {
                for (int i = 0; i<getCurrentTurnsChar().getSkills().size(); i++) {
                    Skill skill = skills.get(i);
                    if (skill.getType().contains("Cleanse") && skill.offCooldown()) {
                        skillsToChoose.add(i);
                    }
                }
            }

            // If damaged, add heal skills to the list of skills to choose from
            if (isCharDamaged(getCurrentTurnsChar())) {
                for (int i = 0; i<getCurrentTurnsChar().getSkills().size(); i++) {
                    Skill skill = skills.get(i);
                    if (skill.getType().contains("Heal") && skill.offCooldown()) {
                        skillsToChoose.add(i);
                    }
                }
            }

            // If not damaged or debuffed, just add all skills off cd to skills to choose
            if (skills.isEmpty()) {
                Random rand = new Random();
                for (int i=0; i<skills.size(); i++) {
                    Skill skill = skills.get(i);
                    if (skill.offCooldown()) {
                        skillsToChoose.add(i);
                    }
                }
            }

            // Randomly select a skill to activate from the list of skills to choose.
            // The list of skills to choose is a list of indexes, so if say a skill heals AND cleanses it should
            // have a higher chance of being selected (if off cd).
            Random rand = new Random();
            int n = rand.nextInt(skillsToChoose.size());
            skills.get(skillsToChoose.get(n)).activate();
            endOfTurn = true;

        } else {
            System.out.println(getCurrentTurnsChar().getName() + " did not do anything.");
            endOfTurn = true;
        }
    }

    public boolean isCharDebuffed(Character c) {
        for (Effect e: c.getPostEffects()) {
            if (e.getType().equals("Debuff")) {
                return true;
            }
        }
        for (Effect e: c.getPreEffects()) {
            if (e.getType().equals("Debuff")) {
                return true;
            }
        }
        return false;
    }

    public boolean isCharDamaged(Character c) {
        return c.getCurrentHealthPoint()<c.getCurrentMaxHealthPoint();
    }

    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    public void activateAll(List<Effect> effects) {
        for (Effect e: effects) {
            e.activate();
        }
    }
}


