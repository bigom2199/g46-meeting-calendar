package lexicon.se.exception;

import java.sql.SQLException;

public class MySQLException extends SQLException {
    public MySQLException( String message) {
        super(message);
    }


    public MySQLException(String message,Throwable cause){
        super(message,cause);
    }
}

