import org.example.EmailValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailValidatorTest {
    @Test
    void testIsValidEmail_ByValidEmail() {
        EmailValidator emailValidator = new EmailValidator();
        assertTrue(emailValidator.isValidEmail("abcd@example.com"));
    }

    @Test
    void testIsValidEmail_ByInvalidEmail() {
        EmailValidator emailValidator = new EmailValidator();
        assertFalse(emailValidator.isValidEmail("a_email"));
    }

    @Test
    void testIsValidEmail_ByNull() {
        EmailValidator emailValidator = new EmailValidator();
        assertFalse(emailValidator.isValidEmail(null));
    }

    @Test
    void testIsCorporateEmail_ByValidCorporateEmail() {
        EmailValidator emailValidator = new EmailValidator();
        assertTrue(emailValidator.isCorporateEmail("admin@company.com"));
    }

    @Test
    void testIsCorporateEmail_ByInvalidCorporateEmail() {
        EmailValidator emailValidator = new EmailValidator();
        assertFalse(emailValidator.isCorporateEmail("abcd@example.com"));
    }

    @Test
    void testIsCorporateEmail_() {
        EmailValidator emailValidator = new EmailValidator();
        assertFalse(emailValidator.isCorporateEmail(null));
    }
}
