package heroes;

import java.util.List;

public class OrcArcher extends Hero {
    private static final int SHOT_DAMAGE=3;
    private static final int BEAT_DAMAGE=2;
    public OrcArcher(String name) {
        super(name);
    }


    @Override
    public void action(Team<Hero> myTeam, Team<Hero> enemies) {
        int enemyIndex = random.nextInt(enemies.size());
        int damage = random.nextInt(2)==0?BEAT_DAMAGE:SHOT_DAMAGE;
        if (isAilment()) damage=damage/2;
        if (getStatus()==Status.Privileged) damage= (int) (damage*1.5);
        enemies.get(enemyIndex).reduceHp(damage);
        MessageHelper.printMessage("Игрок "+getName()+" команды "+myTeam.getName()+" нанес "+damage+"hp урона игроку "
                + enemies.get(enemyIndex).getName()+" команды "+enemies.getName());
        setStatus(Status.Normal);
        setAilment(false);
    }
}
