package model;

import java.util.Map;

public class UserList {
    private Map<Animal, User> userList;

    public void addUser(Animal animal){
        User user = new User(animal);
        userList.put(animal, user);
    }

    public boolean check(String animal) {
        if (userList.get(animal) != null) {
            return false;
        } else {
            return true;
        }
    }

    public User getUser(String animal){return userList.get(animal);}
}
