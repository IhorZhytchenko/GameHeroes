package heroes;

import java.util.Random;

public abstract class Hero implements Act {
    protected String name;
    protected int hp;
    protected  Status status;
    protected Random random;
    protected boolean ailment;


    public Hero(String name){
        this.name=name;
        hp=100;
        status=Status.Normal;
        random = new Random();
        ailment=false;
    }

    public void  reduceHp(int value ){
        hp-=value;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public Status getStatus() {
        return status;
    }

    public boolean isAilment() {
        return ailment;
    }

    public void setAilment(boolean ailment) {
        this.ailment = ailment;
    }
}
