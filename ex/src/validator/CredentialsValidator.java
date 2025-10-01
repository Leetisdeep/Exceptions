package validator;

import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

public class CredentialsValidator {
    
    public static void validateCredentials(String login, String password, String confirmPassword) 
            throws WrongLoginException, WrongPasswordException {
        
        if (login == null || login.length() > 20 || !login.matches("^[a-zA-Z0-9_]+$")) {
            throw new WrongLoginException("Логин должен содержать только латинские буквы, цифры и знак подчеркивания, и быть не длиннее 20 символов");
        }
        
        if (password == null || password.length() > 20 || !password.matches("^[a-zA-Z0-9_]+$")) {
            throw new WrongPasswordException("Пароль должен содержать только латинские буквы, цифры и знак подчеркивания, и быть не длиннее 20 символов");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароль и подтверждение пароля не совпадают");
        }
    }
}
