package com.codecool.shop.dao.implementation;

import com.codecool.shop.dao.UserDao;
import com.codecool.shop.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDaoMem implements UserDao{

    private List<User> DATA = new ArrayList<>();
    private static UserDaoMem instance = null;

    /* A private Constructor prevents any other class from instantiating.
     */
    private UserDaoMem() {
    }

    /**
     * Singleton
     * @return User object
     */
    public static UserDaoMem getInstance() {
        if (instance == null) {
            instance = new UserDaoMem();
        }
        return instance;
    }

    /**
     * Add new user
     * @param user user object
     */
    @Override
    public void add(User user) {
        user.setId(DATA.size() + 1);
        DATA.add(user);
    }


    /**
     * Find user by name
     * @param name name of the user to find
     * @return User object
     */
    public User find(String name) {
        return DATA.stream().filter(t -> t.getName().equals(name)).findFirst().orElse(null);
    }

    /**
     * Find user by id
     * @param id id of user to find
     * @return User object
     */
    @Override
    public User find(int id) {
        return DATA.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    /**
     * Remove user by id
     * @param id id of user to remove
     */
    @Override
    public void remove(int id) {
        DATA.remove(find(id));
    }

    /**
     * Find all user
     * @return User List
     */
    @Override
    public List<User> getAll() {
        return DATA;
    }
}
