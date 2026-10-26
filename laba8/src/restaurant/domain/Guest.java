package restaurant.domain;

public record Guest(int id, String name, String phone) {
    public Guest {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Ім'я гостя не може бути порожнім");
        }
    }
}
