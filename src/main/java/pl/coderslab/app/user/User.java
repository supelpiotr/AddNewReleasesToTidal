package pl.coderslab.app.user;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import pl.coderslab.app.role.Role;

import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String favouriteGenre;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @Email
    @NotBlank
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private boolean enabled;

    @ManyToMany/**(cascade = CascadeType.ALL, fetch = FetchType.EAGER)*/
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

}
