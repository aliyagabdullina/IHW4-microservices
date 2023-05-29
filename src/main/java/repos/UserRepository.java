package repos;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;

import static databases.user.insertUser;

//for database work
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserByUsername(String username);
    User getUserByToken(String token);
    default void createUser(User user) throws SQLException {
        LocalDateTime dateTime = LocalDateTime.now();
        insertUser(user.getId(), user.getUsername(), user.getPassword(), user.getRole(), Date.valueOf(String.valueOf(dateTime)),  Date.valueOf(String.valueOf(dateTime)));
    }

}

