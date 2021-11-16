package quipux.co.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import quipux.co.Dto.UserDto;
import quipux.co.entity.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("Select u from User u WHERE u.email=?1")
    Optional<User> findByUserEmail(String email);

    @Query("Select u from User u WHERE u.email=?1 and u.password=?2")
    User findByUserEmailPassword(String email, String password);

//    @Query("SELECT new quipux.co.Dto.UserDto(u.id, u.email, u.password)" +
//            "FROM User u "
//            +"WHERE u.id=:param")
//    Optional<UserDto> findByUserId(@Param("param") int id);
}
