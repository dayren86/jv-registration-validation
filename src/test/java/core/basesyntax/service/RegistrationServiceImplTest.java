package core.basesyntax.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.basesyntax.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegistrationServiceImplTest {
    private RegistrationService registrationService = new RegistrationServiceImpl();
    private User user;

    @BeforeEach
    void setUp() {
        user = new User("testLogin", "corectPasswod", 25);
    }

    @Test
    void checkRegistrationUser_Ok() {
        User register = registrationService.register(user);

        assertEquals(user, register);
    }

    @Test
    void checkingForAnIncorrectLogin() {
        user.setLogin("log");

        assertThrows(RegistrationException.class, () -> registrationService.register(user));
    }

    @Test
    void checkingForAnIncorrectLoginMoreThan25() {
        user.setLogin("logeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");

        assertThrows(RegistrationException.class, () -> registrationService.register(user));
    }

    @Test
    void checkingForAnIncorrectPassword() {
        user.setPassword("111");

        assertThrows(RegistrationException.class, () -> registrationService.register(user));
    }

    @Test
    void checkingForAnIncorrectPasswordMoreThan25() {
        user.setPassword("11111111111111111111111111111111");

        assertThrows(RegistrationException.class, () -> registrationService.register(user));
    }

    @Test
    void checkingForAnIncorrectAge() {
        user.setAge(15);

        assertThrows(RegistrationException.class, () -> registrationService.register(user));
    }

    @Test
    void checkingForAnIncorrectAge90() {
        user.setAge(90);

        assertThrows(RegistrationException.class, () -> registrationService.register(user));
    }

    @Test
    void checkingForAnNullLogin() {
        user.setLogin(null);

        assertThrows(RegistrationException.class, () -> registrationService.register(user));
    }

    @Test
    void checkingForAnNullPassword() {
        user.setPassword(null);

        assertThrows(RegistrationException.class, () -> registrationService.register(user));
    }

    @Test
    void checkingForAnNullAge() {
        user.setAge(null);

        assertThrows(RegistrationException.class, () -> registrationService.register(user));
    }
}
