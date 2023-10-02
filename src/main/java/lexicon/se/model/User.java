package lexicon.se.model;

public class User {
    private String username;
    private String password;
    // todo: define constructors


    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String  UserInfo(){
        return "User " + username + "has been created successfully." + " PWD: " + password;

    }
    public void newPassword(){
        // todo: assign a new password to password field
    }
}