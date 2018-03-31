package heroes;

import java.util.List;



public interface Act {

    void action(Team<Hero> myTeam, Team<Hero> enemies);
}