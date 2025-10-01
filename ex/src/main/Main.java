package main;

import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;
import validator.CredentialsValidator;

public class Main {
    public static void main(String[] args) {
        String[][] testCases = {
            {"java_skypro_go", "D_1hWiKjjP_9", "D_1hWiKjjP_9"}, // валидные данные
            {"java_skypro_go_too_long_login", "D_1hWiKjjP_9", "D_1hWiKjjP_9"}, // слишком длинный логин
            {"java_skypro!", "D_1hWiKjjP_9", "D_1hWiKjjP_9"}, // недопустимые символы в логине
            {"java_skypro_go", "D_1hWiKjjP_9!", "D_1hWiKjjP_9!"}, // недопустимые символы в пароле
            {"java_skypro_go", "D_1hWiKjjP_9", "different_password"} // разные пароли
        };
        
        for (int i = 0; i < testCases.length; i++) {
            String login = testCases[i][0];
            String password = testCases[i][1];
            String confirmPassword = testCases[i][2];
            
            System.out.println("Тест " + (i + 1) + ":");
            System.out.println("Логин: " + login);
            System.out.println("Пароль: " + password);
            System.out.println("Подтверждение: " + confirmPassword);
            
            try {
                CredentialsValidator.validateCredentials(login, password, confirmPassword);
                System.out.println("Успех: Данные валидны\n");
            } catch (WrongLoginException | WrongPasswordException e) {
                System.out.println("Ошибка: " + e.getMessage() + "\n");
            }
        }
    }
}