package ru.kpfu.itis.skatingblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.skatingblog.models.Coach;
import ru.kpfu.itis.skatingblog.models.Speciality;

import java.util.List;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {


    @Query(value =
            "WITH _coach_and_speciality AS (\n" +
                    "    SELECT coach.id, coach.name, coach.content, coach.photo_url," +
                    " coach_speciality.speciality_id\n" +
                    "    FROM coach coach\n" +
                    "             LEFT JOIN coach_speciality on coach.id = coach_speciality.coach_id)\n" +
                    "SELECT cas.id, cas.name, cas.content, cas.photo_url\n" +
                    "FROM _coach_and_speciality cas\n" +
                    "         INNER JOIN speciality speciality ON speciality.id = cas.speciality_id\n" +
                    "WHERE tag.tag_name = :tag_name", nativeQuery = true)
    List<Coach> findCoachesBySpeciality(@Param("speciality") String speciality);

    //List<Speciality> findSpecialityByCoach(@Param("coachName") String coachName);


}
