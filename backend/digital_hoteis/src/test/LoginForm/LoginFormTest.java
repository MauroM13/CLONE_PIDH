import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LoginFormTest {

    private LoginForm loginForm;

    @Before
    public void setUp() {
        // Inicializa a classe LoginForm ou o componente que contém o formulário de login
        loginForm = new LoginForm();
    }

    @Test
    public void testLoginFormElements() {
        // Obtenha os elementos do formulário de login
        WebElement emailInput = loginForm.getEmailInputElement();
        WebElement passwordInput = loginForm.getPasswordInputElement();

        // Verifique se os elementos existem
        assertNotNull(emailInput);
        assertNotNull(passwordInput);

        // Verifique os atributos dos elementos
        assertEquals("email", emailInput.getAttribute("type"));
        assertEquals("password", passwordInput.getAttribute("type"));

        // Verifique as etiquetas dos elementos
        assertEquals("E-mail", loginForm.getEmailLabel());
        assertEquals("Senha", loginForm.getPasswordLabel());
    }
}
