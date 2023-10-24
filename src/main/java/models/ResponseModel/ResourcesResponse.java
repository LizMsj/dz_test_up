package models.ResponseModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourcesResponse {

    public int page;
    public int per_page;
    public int total;
    @JsonProperty("total_pages")
    public int totalPages;
    public List<DatumResponse> data;
    public SupportResponse support;

}
