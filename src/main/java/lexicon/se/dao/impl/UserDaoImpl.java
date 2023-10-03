package lexicon.se.dao.impl;

import lexicon.se.dao.UserDao;
import lexicon.se.dao.impl.db.MeetingCalendarDbConnection;
import lexicon.se.exception.AuthenticationFailedException;
import lexicon.se.exception.UserExpiredException;
import lexicon.se.model.MeetingCalendar;
import lexicon.se.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Optional;

public class UserDaoImpl implements UserDao {


    @Override
    public User createUser(String username) {
        String query = " " ;
     try(


            Connection connection = MeetingCalendarDbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
        ) {
         // todo: implement it in continue ...
     }catch (SQLException e){

     }

        return null;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public boolean authenticate(User user) throws AuthenticationFailedException, UserExpiredException {
        return false;
    }
}
