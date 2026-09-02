import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Application started");

        Department engineering = new Department("Engineering", 1);
        Department finance = new Department("Finance", 2);
        Department hr = new Department("HR", 3);

        User rahul = new User(1, "Rahul", engineering, "rahul@abc.com");
        User alcatraz = new User(2, "Alcatraz", finance, "alcatraz@abc.com");
        User alc = new User(3, "Alc", hr, "alc@abc.com");
        User alcat = new User(4, "Alcat", finance, "alcat@abc.com");

        List<User> users = new ArrayList<>();

        users.add(rahul);
        users.add(alcatraz);
        users.add(alc);
        users.add(alcat);

        Account account1 = new Account(1, "rahul-23", rahul, true);
        Account account2 = new Account(2, "alcatraz-23", alcatraz, false);
        Account account3 = new Account(3, "alc-23", alc, false);
        Account account4 = new Account(4, "alcat-23", alcat, false);


        System.out.println("Accounts : " + account1 + account2 + account3 + account4);

        UserService userService = new UserServiceImpl(users);

        System.out.println("All users : ");
        List<User> allUsers = userService.getAllUsers();

        for (User user : allUsers) {
            System.out.println(user);
        }


        System.out.println("Filter -- Engineering Users : ");
        List<User> engineeringUsers = userService.filterByDepartment("Engineering");

        for (User user : engineeringUsers) {
            System.out.println(user);
        }

        System.out.println(("Filter -- Finance Users : "));
        List<User> financeUsers = userService.filterByDepartment("Finance");

        for (User user : financeUsers) {
            System.out.println(user);
        }

        System.out.println(("Sort users by name : "));
        List<User> sortedUsers = userService.sortByName();

        for (User user : sortedUsers) {
            System.out.println(user);
        }

        System.out.println("Users grouped by department : ");
        Map<Department, List<User>> groupedUsers = userService.groupByDepartment();

        for (Map.Entry<Department, List<User>> entry : groupedUsers.entrySet()) {
            System.out.println(
                    entry.getKey().getName() +
                    " -> " +
                    entry.getValue());
        }
    }
}

