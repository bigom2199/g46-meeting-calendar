package lexicon.se.dao.impl;

import lexicon.se.dao.UserDao;
import lexicon.se.dao.impl.db.MeetingCalendarDbConnection;
import lexicon.se.exception.AuthenticationFailedException;
import lexicon.se.exception.MySQLException;
import lexicon.se.exception.UserExpiredException;
import lexicon.se.model.MeetingCalendar;
import lexicon.se.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

public class UserDaoImpl implements UserDao {


    public UserDaoImpl(Connection connection) {
    }

    @Override
    public User createUser(String username) {
        String query = "INSERT INTO US)ERS(USERNAME,_PASSWORD)VALUES(?,? ";
        try (


                Connection connection = MeetingCalendarDbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            User user = new User(username);
            preparedStatement.setString(1, user.getUsername());
            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows == 0) {
                throw new MySQLException("Creation user failed,no rows affected.");
            }
            return user;
        } catch (SQLException e) {
            throw new MySQLException("Error occurred while creating user:" + username, e);

        }


    }

    @Override
    public Optional<User> findByUsername(String username) {
        String query = "SELECT * FROM USERS WHERE USERNAME= ?";
        try (
                Connection connection = MeetingCalendarDbConnection.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String foundUsername = resultSet.getString("USERNAME");
                String foundPassword = resultSet.getString("_PASSWORD");
                boolean foundExpired = resultSet.getBoolean("ExPIRed");
                User user = new User(foundUsername, foundPassword, foundExpired);
                return Optional.of(user);

            } else {
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new MySQLException("Error occurred while finding user by username:" + username, e);
        }

    }
        @Override
        public boolean authenticate (User user) throws AuthenticationFailedException, UserExpiredException {
        // step1:define a select query
        // step2:create prepared statement
        // step3:set parameters to prepared statement
        // step4:execute query
        // step5:check the result
         // step6: if resul exists go to step 7
         // step7: check if the user is expired -> throw exception
         //step8: else if the result set was null -> throw exception
         // step9:return true
         String query = "SELECT * FROM WHERE USERNAME = ? AND _PASSWORD= ?" ;
         try(
                 PreparedStatement  preparedStatement = Connection.prepareStatement(query);
                 ){
          PreparedStatement.setString(1,user.getUsername());

          PreparedStatement.setString(2, user.getPassword());
          ResultSet resultSet = PreparedStatement.executeQuery();
          if (resultSet.next()){

          }else {
              throw new AuthenticationFailedException("Authentication failed Invalid credentials.");
          }

          return true;
         }catch (SQLException e){
   throw new MySQLException("Error occurred while authenticating user by username:" + user.getUsername(),e);

         }



        }
    }
