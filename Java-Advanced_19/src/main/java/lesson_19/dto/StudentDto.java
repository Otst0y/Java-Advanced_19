package lesson_19.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String email;
    private String password;
    private String cPassword;

    public StudentDto(String firstName, String lastName, Integer age, String email, String password, String cPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.password = password;
        this.cPassword = cPassword;
    }
}
