// Управління транспортним парком
// (LSP): об'єкти нащадків не порушують роботу програми з базового класу
// Ієрархію розділено на ролі: Vehicle (їздити) + Refuelable (паливо) / Chargeable (батарея)
public class Task3_LSP {
    // Базовий контракт: те, що вміють ВСІ транспортні засоби
    abstract static class Vehicle {
        private final String licensePlate;

        Vehicle(String licensePlate) {
            if (licensePlate == null || licensePlate.isBlank())
                throw new IllegalArgumentException("Номерний знак обов'язковий");
            this.licensePlate = licensePlate;
        }
        String getLicensePlate() { return licensePlate; }
        abstract void drive(double distanceKm);
    }
    // Інтерейси-ролі 
    interface Refuelable {
        double getFuelLevelLiters();
        double getTankCapacityLiters();
        void refuel(double liters);
    }
    interface Chargeable {
        double getBatteryLevelKWh();
        double getBatteryCapacityKWh();
        void charge(double kWh);
    }
    // Бензиновий 
    static class FuelVehicle extends Vehicle implements Refuelable {
        private static final double LITERS_PER_KM = 0.08;
        private final double tankCapacity;
        private double fuelLevel;

        FuelVehicle(String plate, double fuelLevel, double tankCapacity) { // Guard Clauses раннє виявлення помилок
            super(plate);
            if (tankCapacity <= 0 || fuelLevel < 0 || fuelLevel > tankCapacity)
                throw new IllegalArgumentException("Некоректні параметри бака");
            this.fuelLevel = fuelLevel;
            this.tankCapacity = tankCapacity;
        }

        public double getFuelLevelLiters() { return fuelLevel; }
        public double getTankCapacityLiters() { return tankCapacity; }

        public void refuel(double liters) {
            if (liters <= 0) throw new IllegalArgumentException("Літри мають бути > 0");
            if (fuelLevel + liters > tankCapacity) throw new IllegalStateException("Переповнення бака!");
            fuelLevel += liters;
            System.out.println(getLicensePlate() + " заправлено на " + liters + " л. Рівень: " + fuelLevel + " л");
        }

        @Override
        void drive(double distanceKm) {
            double consumed = distanceKm * LITERS_PER_KM;
            if (consumed > fuelLevel) throw new IllegalStateException("Недостатньо пального!");
            fuelLevel -= consumed;
            System.out.println(getLicensePlate() + " проїхав " + distanceKm + " км. Залишок: " + fuelLevel + " л");
        }
    }
    // Електричний 
    static class ElectricVehicle extends Vehicle implements Chargeable {
        private static final double KWH_PER_KM = 0.15;
        private final double batteryCapacity;
        private double batteryLevel;

        ElectricVehicle(String plate, double batteryLevel, double batteryCapacity) { // Guard Clauses
            super(plate);
            if (batteryCapacity <= 0 || batteryLevel < 0 || batteryLevel > batteryCapacity)
                throw new IllegalArgumentException("Некоректні параметри батареї");
            this.batteryLevel = batteryLevel;
            this.batteryCapacity = batteryCapacity;
        }

        public double getBatteryLevelKWh() { return batteryLevel; }
        public double getBatteryCapacityKWh() { return batteryCapacity; }
        public void charge(double kWh) {
            if (kWh <= 0) throw new IllegalArgumentException("кВт·год мають бути > 0");
            if (batteryLevel + kWh > batteryCapacity) throw new IllegalStateException("Переповнення батареї!");
            batteryLevel += kWh;
            System.out.println(getLicensePlate() + " заряджено на " + kWh + " кВт·год. Рівень: " + batteryLevel);
        }

        @Override
        void drive(double distanceKm) {
            double consumed = distanceKm * KWH_PER_KM;
            if (consumed > batteryLevel) throw new IllegalStateException("Недостатньо заряду!");
            batteryLevel -= consumed;
            System.out.println(getLicensePlate() + " проїхав " + distanceKm + " км. Заряд: " + batteryLevel);
        }
    }
    // Менеджер залежать лише від потрібної ролі
    static class GasStationManager {
        void refuelToFull(Refuelable vehicle) {
            double needed = vehicle.getTankCapacityLiters() - vehicle.getFuelLevelLiters();
            if (needed > 0) vehicle.refuel(needed);
        }
    }
    static class ChargingStationManager {
        void chargeToFull(Chargeable vehicle) {
            double needed = vehicle.getBatteryCapacityKWh() - vehicle.getBatteryLevelKWh();
            if (needed > 0) vehicle.charge(needed);
        }
    }
    public static void main(String[] args) {
        FuelVehicle car = new FuelVehicle("AA1111BB", 10, 50);
        ElectricVehicle tesla = new ElectricVehicle("AA2222BB", 20, 75);

        new GasStationManager().refuelToFull(car);  // ElectricVehicle сюди передати неможливо (compile-time)
        new ChargingStationManager().chargeToFull(tesla);

        car.drive(100);
        tesla.drive(100);
    }
}