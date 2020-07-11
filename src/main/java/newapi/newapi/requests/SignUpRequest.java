package newapi.newapi.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import newapi.newapi.models.Members;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequest {
    private String username;
    private String email;
    private String password;

    public Members toEntity() {
        return Members.builder()
                .username(username)
                .email(email)
                .password(password)
                .build();
    }
}
