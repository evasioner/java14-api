package newapi.newapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "members", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Members extends BaseEntity {
    private static final long serialVersionUID = 1748671025743118220L;
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    @JsonIgnore
    private String username;

    @JsonIgnore
    private String email;

    @JsonIgnore
    private String role;

    @JsonIgnore
    private String password;

}
