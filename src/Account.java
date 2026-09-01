public class Account {
    private int id;
    private String username;
    private User user;
    private boolean active;

    public Account(int id, String username, User user, boolean active) {
        this.id = id;
        this.username = username;
        this.user = user;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public User getUser() {
        return user;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", user='" + user + '\'' +
                ", active=" + active +
                '}';

    }
}
