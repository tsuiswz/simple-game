package rpggame;

public class DebuffEffect extends Effect {
    private int power;
    private String statType;
    public DebuffEffect(String name, int turns, int power, String statType, Character giver, Character receiver) {
        super(name, turns, giver, receiver, "Debuff");
        this.power = power;
        this.statType = statType;
    }


    public int getPower() {return power;}
    public String getStatType() {return statType;}
    public void setPower(int i) {power = i;}
    public void setStatType(String s) {statType = s;}

    public void activate() {
        if (getTurns()==0) {getReceiver().setTemporaryStat(getStatType(),getReceiver().getTemporaryStat(statType)+power);}
        reduceTurns();
    }
}

