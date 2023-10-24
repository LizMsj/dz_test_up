package models.ResponseModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatumResponse {
    public int id;
    public String name;
    public int year;
    public String color;
    @JsonProperty("pantone_value")
    public String pantoneValue;
}
