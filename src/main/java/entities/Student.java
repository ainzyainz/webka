package entities;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String address;

    @Column
    private int age;

    @Column
    private int mark;

    @Column
    private String email;
}
