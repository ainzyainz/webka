package entities;

import lombok.*;
import utils.roles.Roles;

import javax.persistence.*;

@Entity
@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String password;

    @Column(name = "email")
    private String email;

    @Column
    private Roles role;

    @ToString.Exclude
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user")
    @Access(AccessType.PROPERTY)
    private Student student;

}
