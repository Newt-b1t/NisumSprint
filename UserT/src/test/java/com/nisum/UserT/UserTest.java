package com.nisum.UserT;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUserProperties() {
        User user = new User("Avinash", "avi@gmail.com", 30);

        assertAll("User property validations",
                () -> assertNotNull(user.getName(), "Name should not be null"),
                () -> assertNotNull(user.getEmail(), "Email should not be null"),
                () -> assertTrue(user.getAge() > 0, "Age should be positive"),
                () -> assertEquals("Avinash", user.getName(), "Name mismatch"),
                () -> assertEquals("avi@gmail.com", user.getEmail(), "Email mismatch"),
                () -> assertEquals(30, user.getAge(), "Age mismatch")
        );
    }
}
