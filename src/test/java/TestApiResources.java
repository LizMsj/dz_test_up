import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import models.ResponseModel.DatumResponse;
import models.ResponseModel.ResourcesDatumSupportResponce;
import models.ResponseModel.SupportResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.BaseTests;

import java.util.ArrayList;
import java.util.List;

@Epic("Гр.3 api tests")
@Feature("Тесты resources list")
public class TestApiResources extends BaseTests {

    @Test(description = "get list <resource>")
    public void testGetListResources() {
        List<DatumResponse> listResponseData  = apiSteps.getResourcesListUnknown().getData();
        ArrayList<DatumResponse> listDatum = new ArrayList<>();
        DatumResponse datumResponse1 = new DatumResponse(1, "cerulean", 2000, "#98B2D1", "15-4020");
        DatumResponse datumResponse2 = new DatumResponse(2, "fuchsia rose", 2001, "#C74375", "17-2031");
        DatumResponse datumResponse3 = new DatumResponse(3, "true red", 2002, "#BF1932", "19-1664");
        DatumResponse datumResponse4 = new DatumResponse(4, "aqua sky", 2003, "#7BC4C4", "14-4811");
        DatumResponse datumResponse5 = new DatumResponse(5, "tigerlily", 2004, "#E2583E", "17-1456");
        DatumResponse datumResponse6 = new DatumResponse(6, "blue turquoise", 2005, "#53B0AE", "15-5217");
        listDatum.add(datumResponse1);
        listDatum.add(datumResponse2);
        listDatum.add(datumResponse3);
        listDatum.add(datumResponse4);
        listDatum.add(datumResponse5);
        listDatum.add(datumResponse6);

        Assert.assertEquals(listResponseData, listDatum);
    }

    @Test(description = "get single <resources>")
    public void testGetSingleResponceListSuccess()
    {
        ResourcesDatumSupportResponce returnResponce = apiSteps.getResourcesListById(2, 200);
        DatumResponse data = new DatumResponse(2, "fuchsia rose", 2001, "#C74375", "17-2031");
        SupportResponse support = new SupportResponse("https://reqres.in/#support-heading", "To keep ReqRes free, contributions towards server costs are appreciated!");
        ResourcesDatumSupportResponce checkResponce = new ResourcesDatumSupportResponce(data, support);
        Assert.assertEquals(checkResponce, returnResponce);
    }

    @Test(description = "get single <resources> not found")
    public void testSingleResoucesListNotFound()
    {
        apiSteps.getSingleUserById(23, 404);
    }

}
