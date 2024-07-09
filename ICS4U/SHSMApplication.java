import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class User {
    protected String email;
    protected String password; // In a real-world application, passwords should be hashed

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password);
    }
}

class Student extends User {
    private String shsm;

    public Student(String email, String password, String shsm) {
        super(email, password);
        this.shsm = shsm;
    }

    public String getShsm() {
        return shsm;
    }

    public void setShsm(String shsm) {
        this.shsm = shsm;
    }
}

class Teacher extends User {
    private String school;

    public Teacher(String email, String password, String school) {
        super(email, password);
        this.school = school;
    }

    public String getSchool() {
        return school;
    }
}

class Announcement {
    private String title;
    private String message;

    public Announcement(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }
}

class Event {
    private String title;
    private String description;
    private LocalDateTime dateTime;

    public Event(String title, String description, LocalDateTime dateTime) {
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}

class UserDatabase {
    private static final String FILE_PATH = "users.json";
    private List<User> users;

    public UserDatabase() {
        this.users = loadUsers();
    }

    private List<User> loadUsers() {
        List<User> userList = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(FILE_PATH)) {
            Object obj = parser.parse(reader);
            JSONArray userListJson = (JSONArray) obj;

            for (Object userObject : userListJson) {
                JSONObject userJson = (JSONObject) userObject;
                String email = (String) userJson.get("email");
                String password = (String) userJson.get("password");
                String role = (String) userJson.get("role");

                if ("student".equals(role)) {
                    String shsm = (String) userJson.get("shsm");
                    userList.add(new Student(email, password, shsm));
                } else if ("teacher".equals(role)) {
                    String school = (String) userJson.get("school");
                    userList.add(new Teacher(email, password, school));
                }
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return userList;
    }

    public void saveUsers() {
        JSONArray userListJson = new JSONArray();

        for (User user : users) {
            JSONObject userJson = new JSONObject();
            userJson.put("email", user.getEmail());
            userJson.put("password", user.getPassword());
            if (user instanceof Student) {
                userJson.put("role", "student");
                userJson.put("shsm", ((Student) user).getShsm());
            } else if (user instanceof Teacher) {
                userJson.put("role", "teacher");
                userJson.put("school", ((Teacher) user).getSchool());
            }
            userListJson.add(userJson);
        }

        try (FileWriter file = new FileWriter(FILE_PATH)) {
            file.write(userListJson.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean addUser(User user) {
        if (users.contains(user)) {
            return false; // User already exists
        }
        users.add(user);
        saveUsers();
        return true;
    }

    public User authenticate(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}

class AuthService {
    private UserDatabase userDatabase;

    public AuthService() {
        this.userDatabase = new UserDatabase();
    }

    public void signUp(String email, String password, String role, String extraInfo) {
        User newUser;
        if ("student".equals(role)) {
            newUser = new Student(email, password, extraInfo);
        } else if ("teacher".equals(role)) {
            newUser = new Teacher(email, password, extraInfo);
        } else {
            System.out.println("Invalid role.");
            return;
        }
        
        if (userDatabase.addUser(newUser)) {
            System.out.println("Signup successful.");
        } else {
            System.out.println("User already exists.");
        }
    }

    public void login(String email, String password) {
        User user = userDatabase.authenticate(email, password);
        if (user != null) {
            System.out.println("Login successful.");
            if (user instanceof Student) {
                System.out.println("Welcome, student!");
                // Redirect to student dashboard
            } else if (user instanceof Teacher) {
                System.out.println("Welcome, teacher!");
                // Redirect to teacher dashboard
            }
        } else {
            System.out.println("Invalid email or password.");
        }
    }
}

public class SHSMApplication {
    public static void main(String[] args) {
        AuthService authService = new AuthService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome! Please choose an option: ");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            }

            System.out.println("Enter email: ");
            String email = scanner.nextLine();
            System.out.println("Enter password: ");
            String password = scanner.nextLine();

            if (choice == 1) {
                System.out.println("Enter role (student/teacher): ");
                String role = scanner.nextLine();
                System.out.println("Enter SHSM program (for students) or school (for teachers): ");
                String extraInfo = scanner.nextLine();
                authService.signUp(email, password, role, extraInfo);
            } else if (choice == 2) {
                authService.login(email, password);
            } else {
                System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}
