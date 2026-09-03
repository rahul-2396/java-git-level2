import java.util.List;

public class DepartmentServiceImpl implements DepartmentService{
    private final List<Department> departments;

    public DepartmentServiceImpl(List<Department> departments) {
        this.departments = departments;
    }

    @Override
    public List<Department> getAllDepartments() {
        return departments;
    }

    @Override
    public Department getDepartmentById(int id) {
        return departments.stream()
                .filter(department -> department.getId() == id)
                .findFirst()
                .orElseThrow(() ->
                        new DepartmentNotFoundException(
                                "Department not found with id " + id));
    }
}
