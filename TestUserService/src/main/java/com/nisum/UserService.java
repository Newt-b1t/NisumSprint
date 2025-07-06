package com.nisum;

public class UserService {

    private final UserRepository userRepository;
    private final EmailSender emailSender;

    public UserService(UserRepository userRepository, EmailSender emailSender) {
        this.userRepository = userRepository;
        this.emailSender = emailSender;
    }

    public User getUserById(String userId) {
        User user = userRepository.findById(userId);
        if (user == null) {
            handleMissingUser(userId);
            throw new RuntimeException("User not found");
        }
        emailSender.send(user.getEmail(), "Welcome back!");
        return user;
    }

    public void handleMissingUser(String userId) {
        System.out.println("Fallback for missing user: " + userId);
    }
}

