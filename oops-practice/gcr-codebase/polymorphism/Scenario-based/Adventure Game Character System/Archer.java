public class Archer extends GameCharacter {
    Archer(String characterName) {
        super(characterName);
    }

    void performAttack() {
        System.out.println(characterName + " (Archer) shoots a precise arrow");
    }
}