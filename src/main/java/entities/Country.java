package entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@Entity
@Table(name = "country")
@AllArgsConstructor
@NoArgsConstructor

public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "country_name")
    private String countryName;

    @OneToMany(mappedBy = "country")
    private Set<Student> peopleSet = new HashSet<>();
}
