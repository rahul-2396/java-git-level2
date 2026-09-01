public class User {
    private int id;
    private String name;
    private Department department;
    private String email;

    public User(int id, String name, Department department, String email) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", email='" + email +
                '}';
    }
}
