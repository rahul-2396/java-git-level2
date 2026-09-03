import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final List<User> users;

    public UserServiceImpl(List<User> users) {
        this.users = users;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public List<User> filterByDepartment(String departmentName) {
        return users.stream()
                .filter(user ->
                        user.getDepartment()
                                .getName()
                                .equalsIgnoreCase(departmentName))
                .toList();
    }

    @Override
    public List<User> sortByName() {
        return users.stream()
                .sorted(Comparator.comparing(User::getName))
                .toList();
    }

    @Override
    public Map<Department, List<User>> groupByDepartment() {
        return users.stream()
                .collect(Collectors.groupingBy(User::getDepartment));
    }

    @Override
    public List<User> getUsersByDepartment(int departmentId) {
        return users.stream()
                .filter(user -> user.getDepartment().getId() == departmentId)
                .toList();
    }

    @Override
    public User createUser(User user, Department department) {
        for (User existingUser : users) {
            if (existingUser.getId() == user.getId()) {
                System.out.println("User already exists");
                return null;
            }
        }
        users.add(user);
        return user;
    }
}
