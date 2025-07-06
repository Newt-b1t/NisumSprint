package com.nisum;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private EmailSender emailSender;

    @Spy
    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserById() {
        String userId = "123";
        User user = new User(userId, "user@example.com");

        // Stub repository: return null first, then user
        when(userRepository.findById(userId)).thenReturn(null, user);

        // First call: should throw exception and invoke fallback
        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            userService.getUserById(userId);
        });
        assertEquals("User not found", thrown.getMessage());

        // Verify fallback method invoked
        verify(userService).handleMissingUser(userId);

        // Second call: should send email
        User result = userService.getUserById(userId);
        assertNotNull(result);
        assertEquals(userId, result.getId());

        // Capture arguments passed to emailSender.send()
        ArgumentCaptor<String> emailCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> subjectCaptor = ArgumentCaptor.forClass(String.class);
        verify(emailSender).send(emailCaptor.capture(), subjectCaptor.capture());

        // Assert the subject line
        assertEquals("Welcome back!", subjectCaptor.getValue());
    }
}
