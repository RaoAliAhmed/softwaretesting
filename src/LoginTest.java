import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private LoginApp loginApp = new LoginApp();

    @Test
    public void testValidLogin() {
        System.out.println("Running test: testValidLogin");
        String email = "johndoe@example.com";
        String password = "password123";
        String result = loginApp.authenticateUser(email,password);
        assertNotNull(result, "Login should be successful for valid credentials.");
    }

    @Test
    public void testInvalidLogin() {
        System.out.println("Running test: testInvalidLogin");
        String email = "invalid@example.com";
        String password = "wrongPassword";
        String result = loginApp.authenticateUser(email,password);
        assertNull(result, "Login should fail for invalid credentials.");
    }

    @Test
    public void testEmptyEmail() {
        System.out.println("Running test: testEmptyEmail");
        String email = "";
        String password = "password123";
        String result = loginApp.authenticateUser(email,password);
        assertNull(result, "Login should fail when the email is empty.");
    }

    @Test
    public void testEmptyPassword() {
        System.out.println("Running test: testEmptyPassword");
        String email = "johndoe@example.com";
        String password = "";
        String result = loginApp.authenticateUser(email,password);
        assertNull(result, "Login should fail when the password is empty.");
    }

    @Test
    public void testNullCredentials() {
        System.out.println("Running test: testNullCredentials");
        String email = null;
        String password = null;
        String result = loginApp.authenticateUser(email,password);
        assertNull(result, "Login should fail when both email and password are null.");
    }


}
