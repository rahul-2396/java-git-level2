import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> getAllUsers();

    List<User> filterByDepartment(String departmentName);

    List<User> sortByName();

    Map<Department, List<User>> groupByDepartment();
}
