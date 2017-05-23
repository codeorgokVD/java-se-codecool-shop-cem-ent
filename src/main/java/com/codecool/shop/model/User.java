package com.codecool.shop.model;


import java.util.ArrayList;

public class User {
    protected int id;
    protected String name;
    private String password;
    private int rank;
    private ArrayList<User> users;

    /**
     * Constructor
     * @param name name of user
     * @param password password of user
     * @param rank rank of user
     */
    public User(String name, String password, int rank) {
        this.name = name;
        this.password = password;
        this.rank = rank;
        this.users = new ArrayList<>();
    }

    /**
     * Setter
     * @param users object
     */
    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    /**
     * Getter
     * @return ArrayList of users
     */
    public ArrayList getUser() {
        return this.users;
    }

    /**
     * Add new user
     * @param user object
     */
    public void addUser(User user) {
        this.users.add(user);
    }

    /**
     * Getter
     * @return int id
     */
    public int getId() {return id;}

    /**
     * Setter
     * @param id int id
     */
    public void setId(int id) {this.id = id;}

    /**
     * Getter
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     * @param name string name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter
     * @return String password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter
     * @param password string password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter
     * @return int rank
     */
    public int getRank() {
        return rank;
    }

    /**
     * Setter
     * @param rank int rank
     */
    public void setRank(int rank) {
        this.rank = rank;
    }

    /**
     * Creates string of object properties
     * @return String
     */
    public String toString() {
        return String.format("id: %1$d, " +
                        "name: %2$s, " +
                        "password: %3$s, " +
                        "rank: %4$d",
                this.id,
                this.name,
                this.password,
                this.rank
        );

    }
}
