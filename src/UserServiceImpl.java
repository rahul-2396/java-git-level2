import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {
    private final List<User> users;

    public UserServiceImpl(List<User> users) {
        this.users = users;
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    @Override
    public List<User> filterByDepartment(String departmentName) { //"I want to process these users as a stream."
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
}
