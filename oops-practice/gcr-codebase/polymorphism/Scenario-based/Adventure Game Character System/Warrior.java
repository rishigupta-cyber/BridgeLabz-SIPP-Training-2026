public class Warrior extends GameCharacter {
    Warrior(String characterName) {
        super(characterName);
    }

    void performAttack() {
        System.out.println(characterName + " (Warrior) swings a mighty sword");
    }
}