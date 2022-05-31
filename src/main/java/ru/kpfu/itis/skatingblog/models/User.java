package ru.kpfu.itis.skatingblog.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import ru.kpfu.itis.skatingblog.models.enums.Role;
import ru.kpfu.itis.skatingblog.models.enums.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_fk")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, name = "first_name")
    @Length(max = 50)
    private String firstName;

    @Length(max = 100)
    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Length(max = 255)
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, name = "hash_password")
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<Comment> comments;

    public boolean isActive() { return this.status == Status.ACTIVE; }

    /*
    @ManyToMany(mappedBy = "likes")
    private List<Article> articles;

     */

}
