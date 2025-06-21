package com.nisum.UserT;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    private final UserService userService = new UserService();

    @Test
    void testValidateAgeThrowsException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> userService.validateAge(16)
        );
        assertEquals("Underage", exception.getMessage());
        assertDoesNotThrow(() -> userService.validateAge(20));
    }
}
