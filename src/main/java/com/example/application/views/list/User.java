package com.example.application.views.list;

import java.util.ArrayList;
import java.util.List;

public class User {
    /** 
     * The user's name
     */
    private String name;

    /**
     * The user's age
     */
    private int age;

    /**
     * The user's weight
     */
    private int weight;
    /**
     * The user's height
     */
	private int height;

	/**
     * The user's password
     */
	
	private String password;

    /**
     * The user's sex
     */
    private boolean sex;

    /**
     * The user's dietary preferences (list of all selected)
     */
    private List<String> diet;

     /**
      * Creates a new user object
      */
    public User(String name, int age, int height, int weight, String password, boolean sex, List<String> diet){
        this.name = name;
        this.age = age;
        this.password = password;
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.diet = diet;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge() {
    	return age;
    }
    
    public void setAge(int age) {
    	this.age = age;
    }
    
    public String getPassword() {
    	return password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
    
    public int getHeight(){
        return height;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public int getWeight(){
        return weight;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public boolean getSex() {
    	return sex;
    }
    
    public void setSex(boolean sex) {
    	this.sex = sex;
    }

    public List<String> getDiet() {
    	return diet;
    }
    
    public void setDiet(List<String> diet) {
    	this.diet = diet;
    }

    //creates a list of all the users
    protected static List<User> userList = new ArrayList<User>();

    //add a user to the users list
    public static void addUser(User user) {
        userList.add(user);
    }

    /**
     * Unregisters an existing student account. Does nothing if the account does not exist.
     *
     * @param user The user account to remove
     */
    public static void removeUser(User user) {
        userList.remove(user);
    }
    
    /**
     * Gets a list of all active user accounts.
     *
     * @return A list of users
     */
    public static List<User> getUsers() {
        return userList;
    }
    
}
