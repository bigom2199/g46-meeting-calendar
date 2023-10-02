package lexicon.se.model;

import java.security.SecureRandom;
import java.util.Random;

public class User {
    private final String username;
    private String password;
    public User(String username){
        this.username = username;
        newPassword();
    }
  public User(String username, String password){
        this.username = username;
        this.password = password;
  }

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
        this.password = generateRandomPassword();


    }
    private String generateRandomPassword(){
        String allowedCharacters ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        int passwordLength= 10;
        StringBuilder stringBuilder = new StringBuilder();
         Random random =new SecureRandom();
         for (int i= 0; i< passwordLength;i++){
             int randomIndex = random.nextInt(allowedCharacters.length());
             char randomChar = allowedCharacters.charAt(randomIndex);


         }

        return StringBuilder.toString() ;
    }
}