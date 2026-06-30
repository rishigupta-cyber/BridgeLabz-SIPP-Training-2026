public class AdventureGame {

    static void startBattle(GameCharacter[] characters) {
        System.out.println("--- Battle Begins ---");
        int warriorCount = 0;
        int mageCount = 0;
        int archerCount = 0;

        for (GameCharacter character : characters) {
            character.performAttack();

            if (character instanceof Warrior) {
                warriorCount++;
            } else if (character instanceof Mage) {
                mageCount++;
            } else if (character instanceof Archer) {
                archerCount++;
            }
        }

        System.out.println("\n--- Battle Participation ---");
        System.out.println("Warriors: " + warriorCount);
        System.out.println("Mages: " + mageCount);
        System.out.println("Archers: " + archerCount);
    }

    public static void main(String[] args) {
        GameCharacter[] characters = new GameCharacter[5];
        characters[0] = new Warrior("Aragorn");
        characters[1] = new Mage("Gandalf");
        characters[2] = new Archer("Legolas");
        characters[3] = new Warrior("Conan");
        characters[4] = new Mage("Merlin");

        startBattle(characters);
    }
}