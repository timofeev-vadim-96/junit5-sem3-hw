package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    private User user;
    private UserRepository repository;

    @BeforeEach
    void setUp() {
        user = new User("Kate", "underworld", false);
        repository = new UserRepository();
    }

    @Test
    void testAuthenticationPositive() {
        assertTrue(user.login("Kate", "underworld"));
    }

    @ParameterizedTest
    @CsvSource({"Kte, underworld", "Kate, underwrld"})
    void testAuthenticationNegative(String login, String password) {
        assertFalse(user.login(login, password));
    }

    @Test
    void testUserRepositoryPositive() {
        user.login(user.name, user.password);

        repository.addUser(user);

        assertTrue(repository.findByName(user.name));
    }

    @Test
    void testUserRepositoryNegative() {
        user.login(user.name, user.password);

        repository.addUser(user);

        assertFalse(repository.findByName(user.name + "no"));
    }

    @Test
    void logoutAllUsersExceptAdminsPositive() {
        user.login(user.name, user.password);
        repository.addUser(user);

        repository.logoutAllUsersExceptAdmins();

        assertFalse(repository.findByName(user.name));
    }

    @Test
    void logoutAllUsersExceptAdminsNegative() {
        user.isAdmin = true;
        user.login(user.name, user.password);
        repository.addUser(user);

        repository.logoutAllUsersExceptAdmins();

        assertTrue(repository.findByName(user.name));
    }
}