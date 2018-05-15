package rpggame;

public class Effect {
    private String name;
    private int turns;
    private int turnsLeft;
    private Character giver;
    private Character receiver;
    private String type;
    public Effect(String name, int turns, Character giver, Character receiver, String type){
        this.name = name;
        this.turns = turns;
        this.turnsLeft = turns;
        this.giver = giver;
        this.receiver = receiver;
        this.type = type;
    }

    public String getName() {return name;}
    public int getTurns() {return turns;}
    public int getTurnsLeft() {return turnsLeft;}
    public boolean isOverdue() {return turnsLeft<0;}
    public Character getGiver() { return giver; }
    public Character getReceiver() { return receiver; }

    public String getType() {
        return type;
    }

    public void setName(String s) {name = s;}
    public void setTurns(int i) {turns = i;}
    public void setTurnsLeft(int i){turnsLeft=i;}
    public void setGiver(Character c) {giver=c;}
    public void setReceiver(Character c) {receiver=c;}

    public void setType(String type) {
        this.type = type;
    }

    public void reduceTurns() {turnsLeft=Math.max(turnsLeft-1, -1);}

    public void activate() {}
}
