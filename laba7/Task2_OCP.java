import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Страхова компанія, актуарні розрахунки
// (OCP): if-else за типом полісу замінено на Strategy
// Extension Point: інтерфейс PremiumStrategy
public class Task2_OCP {

    record PolicyHolder(String holderId, int age, BigDecimal insuredAmount, boolean hasPriorClaims) { }
    // Точка розширення - нові правила розрахунку премії
    interface PremiumStrategy {
        String policyName();                       // ключ типу полісу
        BigDecimal calculate(PolicyHolder holder); // поліморфний розрахунок базової премії
    }
    // Стратегії 
    static class AutoPremium implements PremiumStrategy { // премія для автострахування
        public String policyName() { return "AUTO"; }
        public BigDecimal calculate(PolicyHolder h) {
            BigDecimal premium = h.insuredAmount().multiply(new BigDecimal("0.03"));
            if (h.age() < 25 || h.hasPriorClaims()) premium = premium.multiply(new BigDecimal("1.20"));
            return premium;
        }
    }
    static class HealthPremium implements PremiumStrategy { // премія для медичного страхування
        public String policyName() { return "HEALTH"; }
        public BigDecimal calculate(PolicyHolder h) {
            BigDecimal premium = new BigDecimal("200.00");
            if (h.age() > 40) premium = premium.add(BigDecimal.valueOf(h.age() - 40).multiply(new BigDecimal("10.00")));
            if (h.hasPriorClaims()) premium = premium.add(new BigDecimal("150.00"));
            return premium;
        }
    }
    static class PropertyPremium implements PremiumStrategy { // премія для страхування майна
        public String policyName() { return "PROPERTY"; }
        public BigDecimal calculate(PolicyHolder h) {
            return h.insuredAmount().multiply(new BigDecimal("0.005"));
        }
    }
    static class TravelPremium implements PremiumStrategy { // премія для страхування подорожей
        public String policyName() { return "TRAVEL"; }
        public BigDecimal calculate(PolicyHolder h) {
            BigDecimal premium = new BigDecimal("30.00");
            return h.age() >= 65 ? premium.multiply(new BigDecimal("1.50")) : premium;
        }
    }
    // Калькулятор: закритий для модифікації 
    static class InsurancePremiumCalculator {
        private final Map<String, PremiumStrategy> strategies = new HashMap<>();

        InsurancePremiumCalculator(List<PremiumStrategy> strategyList) {
            for (PremiumStrategy s : strategyList) strategies.put(s.policyName(), s);
        }

        BigDecimal calculatePremium(PolicyHolder holder, String policyName) {
            PremiumStrategy strategy = strategies.get(policyName); //пошук за ключем
            if (strategy == null)
                throw new IllegalArgumentException("Тип страхування " + policyName + " не зареєстровано у системі.");
            BigDecimal premium = strategy.calculate(holder).setScale(2, RoundingMode.HALF_UP) ;
            System.out.println("[INSURANCE] Клієнт " + holder.holderId() + " (Вік: " + holder.age()
                    + "): поліс " + policyName + " -> річна премія: $" + premium);
            return premium;
        }
    }
    // Демонстрація розширення: НОВА стратегія, без змін у калькуляторі 
    static class LifePremium implements PremiumStrategy { // премія для страхування життя
        public String policyName() { return "LIFE"; }
        public BigDecimal calculate(PolicyHolder h) {
            return h.insuredAmount().multiply(new BigDecimal("0.01"))
                    .add(BigDecimal.valueOf(h.age()).multiply(new BigDecimal("2.00")));
        }
    }
    public static void main(String[] args) {
        InsurancePremiumCalculator calc = new InsurancePremiumCalculator(List.of(
                new AutoPremium(), new HealthPremium(), new PropertyPremium(),
                new TravelPremium(), new LifePremium())); // LIFE додано в калькулятор лише при збірці

        PolicyHolder holder = new PolicyHolder("H-1", 23, new BigDecimal("20000"), false);
        calc.calculatePremium(holder, "AUTO");
        calc.calculatePremium(holder, "HEALTH");
        calc.calculatePremium(holder, "PROPERTY");
        calc.calculatePremium(holder, "TRAVEL");
        calc.calculatePremium(holder, "LIFE");
    }
}