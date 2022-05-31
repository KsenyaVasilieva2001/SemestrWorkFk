package ru.kpfu.itis.skatingblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.skatingblog.models.User;
import ru.kpfu.itis.skatingblog.models.enums.Role;
import ru.kpfu.itis.skatingblog.models.enums.Status;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);




    @Transactional
    @Modifying
    @Query(value = "update user_fk set first_name = :firstName, last_name = :lastName " +
    "where email = :email", nativeQuery = true)
    void update(@Param("firstName") String firstName,
                @Param("lastName") String lastName,
                @Param("email") String email);


    @Transactional
    @Modifying
    @Query(value = "update user_fk set role=:role, status=:status" +
            "where id = :id", nativeQuery = true)
    void updateUserRoleAndStatus(@Param("role") Role role,
                @Param("status") Status status,
                @Param("id") Long id);

}
