package com.allstarproject.cs2340.allstarwatercrowdsourcingapp.model;

/**
 * Created by yamin on 2/19/17.
 */

public class RegisteredUserDB {
    private String lastName;
    private String username;
    private String password;
    private String email;
    private String accountType;
    private int id;

    /**
     * This is a no-arg constructor
     */
    public RegisteredUserDB() {}

    /**
     * Thiis constructor instantiates all fields except the primary key,
     * which is email
     * @param lastName
     * @param userName
     * @param password
     */
    public RegisteredUserDB(String email, String accountType, String username,
                          String password, String lastName) {
        super();
        this.email = email;
        this.accountType = accountType;
        this.username = username;
        this.password = password;
        this.lastName = lastName;
    }
    /**
     * getter for the primary key, id
     * @return id
     */
    public int getId() {
        return id;
    }
    /**
     * setter for the primary key, id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter for the foreign key, email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * setter for email, we are making this private just incase Admin has to
     * come in and overwrite email for specific user
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * getter for the account type
     * @return accountType
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * setter for lastName
     * @param lastName
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * getter for userName
     * @return userName
     */
    public String getUsername() {
        return username;
    }

    /**
     * setter for lastName
     * @param lastName
     */
    public void setUserName(String username) {
        this.username = username;
    }

    /**
     * getter for lastName
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * setter for lastName
     * @param lastName
     */

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    /**
     * getter for password
     * @return password
     */

    public String getPassword() {
        return password;
    }

    /**
     * setter for password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns a String representation of the attributes of the registered user
     */
    @Override
    public String toString() {
        return "User Information: [ID: " + getId() + ", Email: " + getEmail()
                + ", Account Type: " + getAccountType() + ", Username: "
                + getUsername() + ", Password: " + getPassword()
                + ", Last Name: " + getLastName() + "]";
    }
}
