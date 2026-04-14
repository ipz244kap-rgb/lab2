// Спільний інтерфейс продукту
interface Subscription {
    double getMonthlyFee();
    int getMinPeriodMonths();
    String getFeatures();
}

// Конкретні продукти (види підписок)
class DomesticSubscription implements Subscription {
    @Override
    public double getMonthlyFee() { return 10.0; }
    @Override
    public int getMinPeriodMonths() { return 1; }
    @Override
    public String getFeatures() { return "Базові телеканали, Новини"; }
}

class EducationalSubscription implements Subscription {
    @Override
    public double getMonthlyFee() { return 15.0; }
    @Override
    public int getMinPeriodMonths() { return 6; }
    @Override
    public String getFeatures() { return "Наукові програми, Документальні фільми, Доступ до бібліотеки"; }
}

class PremiumSubscription implements Subscription {
    @Override
    public double getMonthlyFee() { return 50.0; }
    @Override
    public int getMinPeriodMonths() { return 12; }
    @Override
    public String getFeatures() { return "Усі канали, 4K якість, Відсутність реклами"; }
}

// Спільний клас-творець
abstract class SubscriptionCreator {
    // Фабричний метод
    public abstract Subscription createSubscription();

    public void purchase() {
        Subscription subscription = createSubscription();
        System.out.println("Оформлено підписку: " + subscription.getClass().getSimpleName());
        System.out.println("Ціна: $" + subscription.getMonthlyFee() + "/міс");
        System.out.println("Мінімальний період: " + subscription.getMinPeriodMonths() + " міс.");
        System.out.println("Можливості: " + subscription.getFeatures());
        System.out.println("-------------------------------------------------");
    }
}

// Конкретні творці
class WebSite extends SubscriptionCreator {
    @Override
    public Subscription createSubscription() {
        // Логіка для веб-сайту: за замовчуванням пропонує Educational
        return new EducationalSubscription();
    }
}

class MobileApp extends SubscriptionCreator {
    @Override
    public Subscription createSubscription() {
        // Логіка для мобільного додатку: фокус на Premium
        return new PremiumSubscription();
    }
}

class ManagerCall extends SubscriptionCreator {
    @Override
    public Subscription createSubscription() {
        // Логіка для дзвінка менеджеру: зазвичай продають базовий пакет
        return new DomesticSubscription();
    }
}

// Головний метод програми
public class Main {
    public static void main(String[] args) {
        SubscriptionCreator webCreator = new WebSite();
        webCreator.purchase();

        SubscriptionCreator appCreator = new MobileApp();
        appCreator.purchase();

        SubscriptionCreator managerCreator = new ManagerCall();
        managerCreator.purchase();
    }
}