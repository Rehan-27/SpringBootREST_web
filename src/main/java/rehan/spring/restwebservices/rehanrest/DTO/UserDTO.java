package rehan.spring.restwebservices.rehanrest.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long id;

    @NotEmpty(message = "User First name should not be empty or Null.")
    private String firstName;
    @NotEmpty(message = "User Last Name should not be empty or Null.")
    private String lastName;
    @NotEmpty(message = "User Email should not be empty or Null.")
    @Email(message = "Email address should be Valid.")
    private String email;

}
