package models.ResponseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponceWithUpdate {

    public String name;
    public String job;
    public String updatedAt;

}
