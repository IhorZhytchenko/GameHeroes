package heroes;

import java.util.List;

public class UndeadNecromancer extends Hero {
    private static final int MAGICAL_DAMAGE=5;
    public UndeadNecromancer(String name) {
        super(name);
    }


    @Override
    public void action(Team<Hero> myTeam, Team<Hero> enemies) {
        if (random.nextInt(2)==1){
            sendAilment(myTeam,enemies);
        } else {
            magicalDamage(myTeam ,enemies);
        }
    }

    private void sendAilment(Team<Hero> myTeam, Team<Hero> enemies) {
        int enemyIndex = random.nextInt(enemies.size());
        enemies.get(enemyIndex).setAilment(true);
        MessageHelper.printMessage("Игрок "+getName()+" команды "+myTeam.getName()+" наложил недуг на игрока "
                + enemies.get(enemyIndex).getName()+" команды "+enemies.getName());
        setStatus(Status.Normal);
        setAilment(false);

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

}
