package seminars.third.tdd;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private final List<User> data = new ArrayList<>();

    public void addUser(User user) {
        if (user.isAuthenticate) data.add(user);
    }

    public void removeUser(User user){
        if (findByName(user.name) && !user.isAuthenticate) data.remove(user);
    }

    public void logoutAllUsersExceptAdmins(){
        for (int i = 0; i < data.size(); i++) {
            if (!data.get(i).isAdmin){
                data.get(i).setAuthenticate(false);
                data.remove(i);
            }
        }
    }

    public boolean findByName(String username) {
        for (User user : data) {
            if (user.name.equals(username)) {
                return true;
            }
        }
        return false;
    }

}