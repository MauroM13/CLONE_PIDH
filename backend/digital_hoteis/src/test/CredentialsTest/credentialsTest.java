@Test
public void testInvalidEmailValidation() {
        String invalidEmail = "email.invalid"; // Um e-mail inválido
        boolean isEmailValid = ValidationUtils.isValidEmail(invalidEmail); // Substitua por sua lógica de validação de e-mail
        assertFalse(isEmailValid); // Esperamos que o e-mail seja inválido
        }

@Test
public void testShortPasswordValidation() {
        String shortPassword = "12345"; // Uma senha com menos de 6 caracteres
        boolean isPasswordValid = ValidationUtils.isValidPassword(shortPassword); // Substitua por sua lógica de validação de senha
        assertFalse(isPasswordValid); // Esperamos que a senha seja inválida
        }
