package DTO;

import lombok.*;

@ToString
@EqualsAndHashCode
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    public int id;
    public String name;
    public String surname;
    public String address;
    public int age;
    public int mark;

}
