package DTO;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private int id;

    private String name;

    private String surname;

    private String address;

    private int age;

    private int mark;

    private UserDTO userDTO;

    private CountryDTO countryDTO;
}
