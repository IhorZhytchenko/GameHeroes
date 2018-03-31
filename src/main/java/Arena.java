import heroes.Hero;
import heroes.MessageHelper;
import heroes.Status;
import heroes.Team;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Arena {
    static final String LOG_PATH ="files/log.txt";
    private List<Team<Hero>> teams;
    static Arena game;


    public Arena(List<Team<Hero>> teams) {
        this.teams = teams;
    }

    public static void main(String[] args) {
        game = new Arena(Utils.createTeams());
        game.batle();

    }

    public List<Team<Hero>> getTeams() {
        return teams;
    }

    private void batle(){
        MessageHelper.printMessage("Битва началась!");
        Collections.shuffle(teams);
        while (teams.get(0).size()>0 &&teams.get(1).size()>0){
            for (int i=0;i<2;i++){
                Team<Hero> attacking;
                Team<Hero> defensive;
                if (i==0){
                    myShuffle(teams.get(0));
                    attacking= teams.get(0);
                    defensive=teams.get(1);
                } else {
                    myShuffle(teams.get(1));
                    attacking =teams.get(1);
                    defensive=teams.get(0);
                }

                for (int j=0;j<attacking.size();j++){
                    if (defensive.size()==0) break;
                    attacking.get(j).action(attacking,defensive);
                    checkKilled(defensive);
                }
            }

        }
        String winner = teams.get(0).size()==0?teams.get(1).getName():teams.get(0).getName();
        MessageHelper.printMessage("Битва закончилась! Победитель - "+ winner);
        MessageHelper.saveLog(LOG_PATH);
    }

    private void myShuffle(Team<Hero> attacking) {
        List<Hero> normal = new ArrayList<>();
        List<Hero> privileged = new ArrayList<>();
        for (int i =0;i<attacking.size();i++){
            if(attacking.get(i).getStatus()== Status.Normal){
                normal.add(attacking.get(i));
            } else {
                privileged.add(attacking.get(i));
            }
        }
        Collections.shuffle(normal);
        Collections.shuffle(privileged);
        attacking.clear();
        attacking.addAll(privileged);
        attacking.addAll(normal);
    }

    private void checkKilled(Team<Hero> defensive) {
        for (int i = 0;i<defensive.size();i++){
            if (defensive.get(i).getHp()<=0){
                MessageHelper.printMessage("Игрок "+defensive.get(i).getName()+" команды "+defensive.getName()+" убит!!! ");
                defensive.remove(i);
                break;
            }
        }
    }
}
