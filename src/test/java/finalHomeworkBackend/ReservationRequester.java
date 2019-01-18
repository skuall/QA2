package finalHomeworkBackend;

import apiTests.model.Response;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import finalHomeworkBackend.model.ResponseData;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class ReservationRequester {

    private String url = "https://www.qaguru.lv:8090/tickets/getReservations.php";
    private String deleteRequestUrl = "https://www.qaguru.lv:8090/tickets/delete.php?id=";

    public Response getTicketResponeData() throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        String responeToParse = restTemplate.getForEntity(url, String.class).getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(responeToParse, Response.class);
    }

    public ResponseData dataResult() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        URL jsonURL = new URL(url);
        List<ResponseData> responseValues = objectMapper.readValue(jsonURL, new TypeReference<List<ResponseData>>() {
        });
        return responseValues.stream()
                .filter(x -> x.getName().equals("Jevgenijs") && x.getSurname().equals("Klimovs"))
                .findFirst()
                .orElse(new ResponseData());

    }


    public String deleteResponse() throws IOException {
        ResponseData responseData = dataResult();
        return responseData.getId();

    }

}
