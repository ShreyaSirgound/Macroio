package com.example.application.views.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class User {
    /** 
     * The user's name
     */
    private static String name;

    /**
     * The user's age
     */
    private static int age;

    /**
     * The user's weight
     */
    private static int weight;
    /**
     * The user's height
     */
	private static int height;

	/**
     * The user's password
     */
	
	private String password;

    /**
     * The user's sex
     */
    private static String sex;

    /**
     * The user's dietary preferences (list of all selected)
     */
    private static Set<String> diet;

    /**
     * The user's general activity level
     */
    private static String activity;

     /**
      * Creates a new user object
      */
    public User(String name, int age, int height, int weight, String sex, Set<String> diet, String activity){
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.sex = sex;
        this.diet = diet;
        this.activity = activity;
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

    public String getSex() {
    	return sex;
    }
    
    public void setSex(String sex) {
    	this.sex = sex;
    }

    public Set<String> getDiet() {
    	return diet;
    }
    
    public void setDiet(Set<String> diet) {
    	this.diet = diet;
    }

    public String getActivity() {
    	return activity;
    }
    
    public void setActivity(String activity) {
    	this.activity = activity;
    }

    public static String userToString(User user) {
        String curUser = name + " " + age + " " + height + " " + weight + " " + sex + " " + diet + " " + activity;
        return curUser;
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
