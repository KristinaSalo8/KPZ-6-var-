package task1;
import common.Logger;

// Підсистема: автентифікація
public class AuthService {
    public void authenticate(String player) {
        Logger.log("AuthService", "Перевірено облікові дані гравця " + player);
    }
}
