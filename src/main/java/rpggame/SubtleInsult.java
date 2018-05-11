package rpggame;


public class SubtleInsult {
    /*
    public SubtleInsult(Character c) {
        setCharacter(c);
        setName("Subtle Insult");
        List<String> type = new ArrayList<String>();
        type.add("Attack");
        type.add("Chance");
        type.add("Debuff");
        setType(type);
        setAttackType("Magical");
        setPowerMultiplier(1);
        setEffectPowerMultiplier(0.1);
        setStatMultiplier("Intelligence");
        setEffectStatMultiplier("Intelligence");
        setAccuracy(85);
        setCoolDown(0);
        setCurrentCoolDown(0);
        setEffectChance(30);
        setDescription("They still don't get it.\nThe user magically damages the enemy with a subtly placed insult with a minor chance to decrease their resistance for 3 turns");

        setHitMessage(new ArrayList<String>());
        setMissMessage(new ArrayList<String>());
        setParryMessage(new ArrayList<String>());
        setEffectMessage(new ArrayList<String>());

        setEnemyHitMessage(new ArrayList<String>());
        setEnemyMissMessage(new ArrayList<String>());
        setEnemyParryMessage(new ArrayList<String>());
        setEnemyEffectMessage(new ArrayList<String>());

        addHitMessage("You look tired - Philip Ng. (hit)");
        addMissMessage("You stuttered. Really hard. (missed)" );
        addParryMessage("He looked at your face. (you were parried)");
        addEffectMessage("The enemy looks down at their feet in epiphany. (triggered skill effect)");

        addEnemyHitMessage("You're so smart you're at the top of the bell curve! (enemy hit)");
        addEnemyMissMessage("The enemy stuttered like an ancient engine. (enemy missed)");
        addEnemyParryMessage("You looked at his face. (you parried)");
        addEnemyEffectMessage("Oh no you understood that one. (enemy effect)");
    }

    public boolean activate() {
        if (offCooldown()) {
            activateCooldown();
            useSkillMessage();
            if (attack()) {
                effect();
            }
            return true;
        }
        if (getCharacter().isPlayer()) {
            onCooldownMessage();
        }
        return false;
    }

    public void effect() {
        if (isEffectActivated()) {
            printEffectMessage();
            getCharacter().getEnemy().setTemporaryResistance((int) (getCharacter().getEnemy().getTemporaryResistance() - getCharacter().getCurrentIntelligence() * getEffectPowerMultiplier()));
            getCharacter().getEnemy().getPostEffects().add(new DebuffEffect("Resistance Debuff from Subtle Insult",
                    3,
                    (int) (getCharacter().getCurrentIntelligence() * getEffectPowerMultiplier()),
                    "Resistance",
                    getCharacter(),
                    getCharacter().getEnemy()));
        }
    }
    */
}
