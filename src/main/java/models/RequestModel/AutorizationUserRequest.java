package models.RequestModel;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutorizationUserRequest {

    public String email;
    public String password;

    public AutorizationUserRequest(String email){
                this.email = email;
    }

}
