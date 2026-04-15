import java.util.ArrayList;
import java.util.List;

interface Prototype {
    Prototype clone();
}

class Virus implements Prototype {
    private double weight;
    private int age;
    private String name;
    private String species;
    private List<Virus> children;

    public Virus(double weight, int age, String name, String species) {
        this.weight = weight;
        this.age = age;
        this.name = name;
        this.species = species;
        this.children = new ArrayList<>();
    }

    public Virus(Virus original) {
        this.weight = original.weight;
        this.age = original.age;
        this.name = original.name;
        this.species = original.species;
        this.children = new ArrayList<>();

        for (Virus child : original.children) {
            this.children.add((Virus) child.clone());
        }
    }

    public void addChild(Virus child) {
        this.children.add(child);
    }

    @Override
    public Prototype clone() {
        return new Virus(this);
    }

    public void printHierarchy(String indent) {
        System.out.println(indent + "Вірус: " + name + " | Вид: " + species + " | Вага: " + weight + " | Вік: " + age + " [ID об'єкта: " + this.hashCode() + "]");
        for (Virus child : children) {
            child.printHierarchy(indent + "    ");
        }
    }
}

public class task4 {
    public static void main(String[] args) {
        Virus grandParent = new Virus(2.5, 10, "Vitatik", "T-virus");

        Virus parent1 = new Virus(1.8, 5, "Dota1", "T-virus");
        Virus parent2 = new Virus(1.9, 6, "Dota2", "T-virus");

        Virus child1 = new Virus(0.5, 1, "LadyBag", "T-virus");
        Virus child2 = new Virus(0.6, 2, "Bulochka", "T-virus");
        Virus child3 = new Virus(0.4, 1, "Trava", "T-virus");

        parent1.addChild(child1);
        parent1.addChild(child2);
        parent2.addChild(child3);

        grandParent.addChild(parent1);
        grandParent.addChild(parent2);

        System.out.println("ОРИГІНАЛЬНИЙ ВІРУС ТА ЙОГО ДІТИ:");
        grandParent.printHierarchy("");

        System.out.println("\nКЛОНОВАНИЙ ВІРУС:");
        Virus clonedGrandParent = (Virus) grandParent.clone();
        clonedGrandParent.printHierarchy("");
    }
}