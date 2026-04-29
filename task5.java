import java.util.ArrayList;
import java.util.List;

class Character {
    public String type;
    public int height;
    public String build;
    public String hairColor;
    public String eyeColor;
    public String clothing;
    public List<String> inventory = new ArrayList<>();
    public List<String> actions = new ArrayList<>();

    public void showInfo() {
        System.out.println("Зріст: " + height + " см, Статура: " + build);
        System.out.println("Волосся: " + hairColor + ", Очі: " + eyeColor);
        System.out.println("Одяг: " + clothing);
        System.out.println("Інвентар: " + String.join(", ", inventory));
        System.out.println("Справи: " + String.join(", ", actions));
        System.out.println();
    }
}

interface ICharacterBuilder {
    ICharacterBuilder reset();
    ICharacterBuilder setHeight(int height);
    ICharacterBuilder setBuild(String build);
    ICharacterBuilder setHairColor(String color);
    ICharacterBuilder setEyeColor(String color);
    ICharacterBuilder setClothing(String clothes);
    ICharacterBuilder addInventory(String item);
    ICharacterBuilder performAction(String action);
    Character getCharacter();
}

class HeroBuilder implements ICharacterBuilder {
    private Character character;

    public HeroBuilder() { this.reset(); }

    @Override
    public ICharacterBuilder reset() {
        this.character = new Character();
        this.character.type = "Героїня:";
        return this;
    }

    public ICharacterBuilder setHeight(int height) { this.character.height = height; return this; }
    public ICharacterBuilder setBuild(String build) { this.character.build = build; return this; }
    public ICharacterBuilder setHairColor(String color) { this.character.hairColor = color; return this; }
    public ICharacterBuilder setEyeColor(String color) { this.character.eyeColor = color; return this; }
    public ICharacterBuilder setClothing(String clothes) { this.character.clothing = clothes; return this; }
    public ICharacterBuilder addInventory(String item) { this.character.inventory.add(item); return this; }

    public ICharacterBuilder performAction(String action) {
        this.character.actions.add("Добра справа: " + action);
        return this;
    }

    public Character getCharacter() {
        Character result = this.character;
        this.reset();
        return result;
    }
}

class EnemyBuilder implements ICharacterBuilder {
    private Character character;

    public EnemyBuilder() { this.reset(); }

    @Override
    public ICharacterBuilder reset() {
        this.character = new Character();
        this.character.type = "Ворог:";
        return this;
    }

    public ICharacterBuilder setHeight(int height) { this.character.height = height; return this; }
    public ICharacterBuilder setBuild(String build) { this.character.build = build; return this; }
    public ICharacterBuilder setHairColor(String color) { this.character.hairColor = color; return this; }
    public ICharacterBuilder setEyeColor(String color) { this.character.eyeColor = color; return this; }
    public ICharacterBuilder setClothing(String clothes) { this.character.clothing = clothes; return this; }
    public ICharacterBuilder addInventory(String item) { this.character.inventory.add(item); return this; }

    public ICharacterBuilder performAction(String action) {
        this.character.actions.add("Злодіяння: " + action);
        return this;
    }

    public Character getCharacter() {
        Character result = this.character;
        this.reset();
        return result;
    }
}

class Director {
    public void constructDreamHero(ICharacterBuilder builder) {
        builder.reset()
                .setHeight(175)
                .setBuild("Спортивна, струнка")
                .setHairColor("Руса")
                .setEyeColor("Зелені")
                .setClothing("Костюм FBI")
                .addInventory("Автомат")
                .addInventory("Ніж")
                .performAction("Врятувала місто від злочинців")
                .performAction("Допомогла котику злізти з дерева");
    }

    public void constructArchEnemy(ICharacterBuilder builder) {
        builder.reset()
                .setHeight(210)
                .setBuild("Масивна, загрозлива")
                .setHairColor("Лисий")
                .setEyeColor("Чорні")
                .setClothing("Чорний плащ")
                .addInventory("Кулемет")
                .performAction("Захопив владу у місті")
                .performAction("З'їв усю піцу");
    }
}

public class task5 {
    public static void main(String[] args) {
        Director director = new Director();

        ICharacterBuilder heroBuilder = new HeroBuilder();
        director.constructDreamHero(heroBuilder);
        Character myHero = heroBuilder.getCharacter();

        ICharacterBuilder enemyBuilder = new EnemyBuilder();
        director.constructArchEnemy(enemyBuilder);
        Character myEnemy = enemyBuilder.getCharacter();

        myHero.showInfo();
        myEnemy.showInfo();
    }
}