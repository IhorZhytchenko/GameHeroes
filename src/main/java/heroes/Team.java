package heroes;

import java.util.ArrayList;

public class Team<E> extends ArrayList<E>{
    private String name;

    public Team(String name){
        super();
        this.name=name;
    }

    public String getName() {
        return name;
    }
}
