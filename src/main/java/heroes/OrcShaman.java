package heroes;

import java.util.List;

public class OrcShaman extends Hero {
    public OrcShaman(String name) {
        super(name);
    }


    @Override
    public void action(Team<Hero> myTeam, Team<Hero> enemies) {
        if (random.nextInt(2)==1){
            buff(myTeam);
        } else {
            cancel(myTeam ,enemies);
        }
    }

    private void cancel(Team<Hero> myTeam, Team<Hero> enemies) {
       int enemyIndex =-1;
       for (int i =0;i<enemies.size();i++){
           if (enemies.get(i).getStatus()==Status.Privileged){
               enemies.get(i).setStatus(Status.Normal);
               enemyIndex=i;
               break;
           }
       }
       if (enemyIndex==-1){
           MessageHelper.printMessage("Игрок " + getName() + " команды " + myTeam.getName() + " не нашол с кого снять улутшения в команде  "
                    + enemies.getName());
       }else {
           MessageHelper.printMessage("Игрок " + getName() + " команды " + myTeam.getName() + " снял улутшения с игрока "
                   + enemies.get(enemyIndex).getName() + " команды " + enemies.getName());
       }
        setStatus(Status.Normal);
        setAilment(false);
    }

    private void buff( Team<Hero> myTeam) {
        int index = random.nextInt(myTeam.size());
        myTeam.get(index).setStatus(Status.Privileged);
        if(!getName().equals(myTeam.get(index).getName())) setStatus(Status.Normal);
        MessageHelper.printMessage("Игрок "+getName()+" команды "+myTeam.getName()+" наложил улутшения на игрока "
                + myTeam.get(index).getName());
        setAilment(false);
    }
}
