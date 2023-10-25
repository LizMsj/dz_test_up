package models.ResponseModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AutorizationUserResponse {

    public Integer id;
    public String token;
    public String error;

    public AutorizationUserResponse(Integer id, String token){
        this.id = id;
        this.token = token;
    }
}
