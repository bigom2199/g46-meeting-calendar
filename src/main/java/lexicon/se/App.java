package lexicon.se;

import lexicon.se.dao.MeetingCalendarDao;
import lexicon.se.dao.UserDao;
import lexicon.se.dao.impl.UserDaoImpl;
import lexicon.se.dao.impl.db.MeetingCalendarDbConnection;
import lexicon.se.exception.AuthenticationFailedException;
import lexicon.se.exception.UserExpiredException;
import lexicon.se.model.User;

import java.util.Optional;

/**
 * Hello world!
 *
 */
public class App {




    public static void main(String[] args) {


         UserDao userDao = new UserDaoImpl(MeetingCalendarDbConnection.getConnection());


       // User CreatedUser = UserDao.createUser("admin");


      //  System.out.println("CreatedUser.userInfo()= " + createdUser.userInfo());
         // Optional<User> userOptional = userDao.findByUsername("admin");
          // if (userOptional.isPresent()){
         //   System.out.println(userOptional.get().UserInfo());

        try {

         boolean isAuthenticate = userDao.authenticate(new User("admin","123456"));
            System.out.println("You are logged in...");
        } catch (AuthenticationFailedException e) {
            System.out.println(e.getMessage());

        } catch (UserExpiredException e) {
            System.out.println(e.getMessage());
        }
    }

    }







