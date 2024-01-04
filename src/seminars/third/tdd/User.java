package seminars.third.tdd;

public class User {

    String name;
    String password;
    boolean isAdmin;

    boolean isAuthenticate = false;

    public User(String name, String password, boolean isAdmin) {
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
        this.isAdmin = false;
    }


    public boolean login(String name, String password) {
        if (this.name.equals(name) && this.password.equals(password))
            isAuthenticate = true;

        return isAuthenticate;
    }

    public boolean logout(String name, String password) {
        if (this.name.equals(name) && this.password.equals(password) && !this.isAdmin)
            isAuthenticate = false;

        return isAuthenticate;
    }

    public void setAuthenticate(boolean authenticate) {
        isAuthenticate = authenticate;
    }
}