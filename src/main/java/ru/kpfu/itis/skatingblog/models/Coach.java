package ru.kpfu.itis.skatingblog.models;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coach")
public class Coach implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @Length(max = 500)
    private String name;

    @Column(nullable = false)
    @Length(max = 1000)
    private String content;

    @Column(nullable = false)
    @CreatedDate
    private LocalDateTime created;

    @Column(name = "photo_url")
    @Length(max = 500)
    private String photoUrl;

    @ManyToMany
    @JoinTable(name = "coach_speciality",
            joinColumns = {@JoinColumn(name = "coach_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "speciality_id", referencedColumnName = "id")})
    private List<Speciality> specialityList;
}
