public class Mage extends GameCharacter {
    Mage(String characterName) {
        super(characterName);
    }

    void performAttack() {
        System.out.println(characterName + " (Mage) casts a fireball spell");
    }
}