package lexicon.se.dao;

import lexicon.se.exception.AuthenticationFailedException;
import lexicon.se.exception.UserExpiredException;
import lexicon.se.model.User;

import java.util.Optional;

public interface UserDao {
     User createUser(String username);
          Optional<User>  findByUsername(String username);
          boolean authenticate(User user) throws AuthenticationFailedException, UserExpiredException;
   // todo: add methods according to project functionalities...


}
