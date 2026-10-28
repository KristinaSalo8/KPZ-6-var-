package restaurant.domain;
    //Information Expert - Об'єкт, який володіє даними, повинен виконувати операції над цими даними.
public record OrderLine(MenuItem item, int count) {
    public OrderLine {
        if (item == null || count <= 0) {
            throw new IllegalArgumentException("Некоректний рядок замовлення");
        }
    }

    public double subtotal() {
        return item.price() * count;
    }
}
