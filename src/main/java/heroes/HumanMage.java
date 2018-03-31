package heroes;

import java.util.List;

public class HumanMage extends Hero {
    private static final int MAGICAL_DAMAGE=4;
    public HumanMage(String name) {
        super(name);
    }


    @Override
    public void action(Team<Hero> myTeam, Team<Hero> enemies) {
        if (random.nextInt(2)==1){
            buff(myTeam);
       } else {
            magicalDamage(myTeam ,enemies);
        }
    }

    private void magicalDamage(Team<Hero> myTeam, Team<Hero> enemies) {
        int enemyIndex = random.nextInt(enemies.size());
        int damage = MAGICAL_DAMAGE;
        if (isAilment()) damage=damage/2;
        if (getStatus()==Status.Privileged) damage= (int) (damage*1.5);
        enemies.get(enemyIndex).reduceHp(damage);
        MessageHelper.printMessage("Игрок "+getName()+" команды "+myTeam.getName()+" нанес "+damage+"hp урона игроку "
                + enemies.get(enemyIndex).getName()+" команды "+enemies.getName());
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
