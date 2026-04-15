
interface Laptop {}
interface Netbook {}
interface EBook {}
interface Smartphone {}

class MacBook implements Laptop {}
class AppleNetbook implements Netbook {}
class AppleEBook implements EBook {}
class IPhone implements Smartphone {}

class SamsungLaptop implements Laptop {}
class SamsungNetbook implements Netbook {}
class SamsungEBook implements EBook {}
class GalaxySmartphone implements Smartphone {}

class XiaomiLaptop implements Laptop {}
class XiaomiNetbook implements Netbook {}
class XiaomiEBook implements EBook {}
class XiaomiSmartphone implements Smartphone {}

interface TechFactory {
    String getBrandName();
    Laptop createLaptop();
    Netbook createNetbook();
    EBook createEBook();
    Smartphone createSmartphone();
}

class AppleFactory implements TechFactory {
    public String getBrandName() { return "Apple"; }
    public Laptop createLaptop() { return new MacBook(); }
    public Netbook createNetbook() { return new AppleNetbook(); }
    public EBook createEBook() { return new AppleEBook(); }
    public Smartphone createSmartphone() { return new IPhone(); }
}

class SamsungFactory implements TechFactory {
    public String getBrandName() { return "Samsung"; }
    public Laptop createLaptop() { return new SamsungLaptop(); }
    public Netbook createNetbook() { return new SamsungNetbook(); }
    public EBook createEBook() { return new SamsungEBook(); }
    public Smartphone createSmartphone() { return new GalaxySmartphone(); }
}

class XiaomiFactory implements TechFactory {
    public String getBrandName() { return "Xiaomi"; }
    public Laptop createLaptop() { return new XiaomiLaptop(); }
    public Netbook createNetbook() { return new XiaomiNetbook(); }
    public EBook createEBook() { return new XiaomiEBook(); }
    public Smartphone createSmartphone() { return new XiaomiSmartphone(); }
}

public class task2 {
    public static void main(String[] args) {
        TechFactory[] factories = {
                new AppleFactory(),
                new SamsungFactory(),
                new XiaomiFactory()
        };

        for (TechFactory factory : factories) {
            System.out.println("- Фірма: " + factory.getBrandName());
            System.out.println("Створено: " + factory.createLaptop().getClass().getSimpleName());
            System.out.println("Створено: " + factory.createNetbook().getClass().getSimpleName());
            System.out.println("Створено: " + factory.createEBook().getClass().getSimpleName());
            System.out.println("Створено: " + factory.createSmartphone().getClass().getSimpleName());
            System.out.println();
        }
    }
}