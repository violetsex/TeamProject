import java.util.List;
import java.util.Scanner;


public class Game {
    public static void main(String[] args) {

        
        //Enter the game
        Scanner sc = new Scanner(System.in);
        String username, password;
        System.out.println("Welcome to Swashbuckler");

        // Registration
        System.out.println("Please enter a username for registration:");
        username = sc.nextLine();
        System.out.println("Please enter a password for registration:");
        password = sc.nextLine();
        System.out.println("Registration successful!");

        // Login
        System.out.println("Please enter your username for login:");
        String inputUsername = sc.nextLine();
        System.out.println("Please enter your password for login:");
        String inputPassword = sc.nextLine();

        if (inputUsername.equals(username) && inputPassword.equals(password)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Incorrect username or password. Please try again.");
        }
        
        // Operating system, keyboard interaction
        RoleManagementSystem roleManagementSystem = new RoleManagementSystem();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the Swashbuckler!");
            System.out.println("1. Create Role");
            System.out.println("2. Show Role Information");
            System.out.println("3. Modify Role blood volume");
            System.out.println("4. Delete Role");
            System.out.println("5. Start Game");
            System.out.println("6. Exit Game");
            System.out.print("Please enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createRole(roleManagementSystem, scanner);
                    break;
                case 2:
                    roleManagementSystem.showAllRoles();
                    break;
                case 3:
                    modifyRole(roleManagementSystem, scanner);
                    break;
                case 4:
                    deleteRole(roleManagementSystem, scanner);
                    break;
                case 5:
                    startGame(roleManagementSystem);
                    break;
                case 6:
                    System.out.println("Thank you for playing. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please enter a valid option!");
            }
        }
    }

    // Function
    private static void createRole(RoleManagementSystem roleManagementSystem, Scanner scanner) {
        System.out.println("Enter the name of the first character:");
        String name1 = scanner.next();
        System.out.println("Choose the gender of the first character (male:0/female:1):");
        String gender1 = scanner.next();
        System.out.println("Choose the appearance of the first character (1-7):");
        int faceIndex1 = scanner.nextInt();
        Role r1 = new Role(name1, 100, gender1.charAt(0), faceIndex1);

        System.out.println("Enter the name of the second character:");
        String name2 = scanner.next();
        System.out.println("Choose the gender of the second character (male:0/female:1):");
        String gender2 = scanner.next();
        System.out.println("Choose the appearance of the second character (1-7):");
        int faceIndex2 = scanner.nextInt();
        Role r2 = new Role(name2, 100, gender2.charAt(0), faceIndex2);

        roleManagementSystem.addRole(r1);
        roleManagementSystem.addRole(r2);
        System.out.println("Roles created successfully!");
    }

    private static void modifyRole(RoleManagementSystem roleManagementSystem, Scanner scanner) {
        System.out.println("Enter the name of the character to modify:");
        String name = scanner.next();
        Role role = roleManagementSystem.findRole(name);
        if (role != null) {
            System.out.println("Enter the new blood volume:");
            int newBlood = scanner.nextInt();
            role.setBlood(newBlood);
            System.out.println("Role information modified successfully!");
        } else {
            System.out.println("Character not found!");
        }
    }

    private static void deleteRole(RoleManagementSystem roleManagementSystem, Scanner scanner) {
        System.out.println("Enter the name of the character to delete:");
        String name = scanner.next();
        roleManagementSystem.deleteRole(name);
    }

    private static void startGame(RoleManagementSystem roleManagementSystem) {
        List<Role> roles = roleManagementSystem.getRoles();
        if (roles.size() < 2) {
            System.out.println("The game cannot start, insufficient number of characters!");
            return;
        }

        Role r1 = roles.get(0);
        Role r2 = roles.get(1);

        System.out.println("Game started!");
        // Characters engage in combat until their health reaches zero, ending the game
        while (true) {
            r1.attack(r2);
            if (r2.getBlood() == 0) {
                System.out.println(r1.getName() + " K.O " + r2.getName());
                break;
            }
            r2.attack(r1);
            if (r1.getBlood() == 0) {
                System.out.println(r2.getName() + " K.O " + r1.getName());
                break;
            }
        }
    }
}
