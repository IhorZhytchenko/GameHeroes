import heroes.*;

import java.util.*;

public class Utils {
    static Random random= new Random();
   static List<Race> allRaces = Arrays.asList(Race.Elf,Race.Human,Race.Orc,Race.Undead);

    public static List<Team<Hero>> createTeams(){
        MessageHelper.printMessage("Создание команд");
        List<Team<Hero>> result = new ArrayList<>();
        List<List<Race>> teamRaces = new ArrayList<>();
        teamRaces.add(new ArrayList<Race>());
        teamRaces.add(new ArrayList<Race>());
        int randomRace = random.nextInt(3);
        Collections.shuffle(allRaces);
        for (int i=0;i<allRaces.size();i++){
            if (i<=randomRace){
                teamRaces.get(0).add(allRaces.get(i));
            } else {
                teamRaces.get(1).add(allRaces.get(i));
            }
        }
        result.add(createTeam(1,teamRaces.get(0)));
        result.add(createTeam(2,teamRaces.get(1)));

        return result;
    }

    private static Team<Hero> createTeam(int number,List<Race> races) {
        Team<Hero> result= new Team<>("Team "+number);
        MessageHelper.printMessage("За команду "+ result.getName()+" играют следущие расы: " + races.toString());
        result.add(createMage(races.get(random.nextInt(races.size()))));
        for (int i =1;i<4;i++){
            result.add(createArcher(races.get(random.nextInt(races.size())),i));
        }
        for (int i =1;i<5;i++){
            result.add(createWarrior(races.get(random.nextInt(races.size())),i));
        }

        return result;
    }

    private static Hero createWarrior(Race race, int number) {
        Hero result;
        switch (race){
            case Elf:
                result = new ElfWarrior("Warrior"+number);
                break;
            case Orc:
                result = new OrcGoblin("Warrior"+number);
                break;
            case Human:
                result = new HumanWarrior("Warrior"+number);
                break;
            case Undead:
                result = new UndeadZombies("Warrior"+number);
                break;
            default:
                result = new HumanWarrior("Warrior"+number);
                break;
        }
        return result;

    }

    private static Hero createArcher(Race race, int number) {
        Hero result;
        switch (race){
            case Elf:
                result = new ElfArcher("Archer"+number);
                break;
            case Orc:
                result = new OrcArcher("Archer"+number);
                break;
            case Human:
                result = new HumanCrossbowman("Archer"+number);
                break;
            case Undead:
                result = new UndeadHunter("Archer"+number);
                break;
            default:
                result = new HumanCrossbowman("Archer"+number);
                break;
        }
        return result;

    }

    private static Hero createMage(Race race) {
        Hero result;
        switch (race){
            case Elf:
                result = new ElfMage("Mage");
                break;
            case Orc:
                result = new OrcShaman("Mage");
                break;
            case Human:
                result = new HumanMage("Mage");
                break;
            case Undead:
                result = new UndeadNecromancer("Mage");
                break;
            default:
                result = new HumanMage("Mage");
                break;
        }
        return result;
    }
}
