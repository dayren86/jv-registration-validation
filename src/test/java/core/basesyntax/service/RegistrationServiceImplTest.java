package core.basesyntax.service;

import core.basesyntax.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationServiceImplTest {
    RegistrationService registrationService = new RegistrationServiceImpl();

    @BeforeEach
    void setUp() {
        
    }

    @Test
    void checkRegistrationUser_Ok() {
        User user = new User();
        user.setLogin("testuser");
        user.setPassword("11111111");
        user.setAge(20);

        User register = registrationService.register(user);

        assertEquals(user, register);
    }

    @Test
    void checkingForAnIncorrectLogin() {
        User user = new User();
        user.setLogin("testuser");
        user.setPassword("111");
        user.setAge(20);

        assertThrows(RegistrationException.class, () -> registrationService.register(user));
    }
}