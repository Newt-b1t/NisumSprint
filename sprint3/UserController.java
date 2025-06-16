package com.avinash.sprint3;
//10
// 2️⃣ DAO Layer
class UserDao {
    public String fetchUserData(int userId) throws Exception {
        if (userId <= 0) {
            throw new Exception("Invalid user ID: " + userId);
        }
        // Simulate database fetch
        if (userId == 404) {
            throw new Exception("User not found in database.");
        }
        return "UserData for ID: " + userId;
    }
}

// 3️⃣ Service Layer
class UserService {
    private final UserDao userDao = new UserDao();

    public String getUserDetails(int userId) throws ServiceException {
        try {
            return userDao.fetchUserData(userId);
        } catch (Exception e) {
            // Wrap the exception in a ServiceException and propagate it
            throw new ServiceException("Failed to fetch user details.", e);
        }
    }
}

// 4️⃣ Controller Layer
public class UserController {
    private final UserService userService = new UserService();

    public void handleRequest(int userId) {
        try {
            String userDetails = userService.getUserDetails(userId);
            System.out.println("User Details: " + userDetails);
        } catch (ServiceException e) {
            System.err.println("Error occurred while processing request: " + e.getMessage());
            Throwable rootCause = e.getCause();
            if (rootCause != null) {
                System.err.println("Root Cause: " + rootCause.getMessage());
            }
        }
    }

    // 5️⃣ Main Method
    public static void main(String[] args) {
        UserController controller = new UserController();
        // Valid call
        controller.handleRequest(10);
        // Invalid call (negative ID)
        controller.handleRequest(-5);
        // Simulate user not found
        controller.handleRequest(404);
    }
}

