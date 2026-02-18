package pl.estrix.restapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Map;

import static org.junit.Assert.*;

public class ProductImageVersionRestControllerTest {

    private Gson gson = new Gson();
    private CloseableHttpClient httpClient;
    private ObjectMapper mapper;
    private String ENDPOINT = "http://rp.e-strix.pl:80/productimageversion/add-image";

    @Test
    public void findByEAN() {
    }

    @Test
    public void getImageDynamicType() {
    }

//    public static void main() throws IOException{

    @Test
    public void create() throws IOException {

        File file = new File("/Users/kamilmuc/memy/444990981_882171700615531_1781627156243985294_n.jpg");

        byte[] fileContent = FileUtils.readFileToByteArray(file);

        AddImageRequest postRequest = AddImageRequest
                .builder()
                .versionId(2065L)
                .description("description")
                .ean("4305615883267")
                .hashGroup("ef0c6f5d-f099-43a1-997f-e7498de75419")
                .artNumber("2065")
                .author("author")
                .externalOCRCheck(true)
                .imgBas64(Base64.getEncoder().encodeToString(fileContent))
                .build();

        HttpPost postMethod = this.buildPostMethod(ENDPOINT);
        String json = gson.toJson(postRequest);
        HttpEntity entity = new ByteArrayEntity(json.getBytes(), ContentType.APPLICATION_JSON);
        postMethod.setEntity(entity);
        int httpStatus;
        this.httpClient = HttpClientBuilder.create().build();

        Map responseMap =  getEntityAndReleaseConnection(postMethod, Map.class);


        assertNotNull(responseMap);
    }

    @Before
    public void setUp() throws Exception {
        this.httpClient = HttpClientBuilder.create().build();
        this.mapper = new ObjectMapper();
    }


    private HttpPost buildPostMethod(String requestUrl) {
        HttpPost method = new HttpPost(requestUrl);
        // Request headers
        method.addHeader("Accept", "*/*");
//        method.addHeader("User-Agent", "AHSP");
//        method.addHeader("Content-Type", "application/timestamp-query");
//        method.addHeader("Content-Transfer-Encoding", CHARSET_UTF8);
        // Parameters
//        method.setEntity(new ByteArrayEntity(rfc3161TimestampRequest));
        return method;
    }

    private <T> T getEntityAndReleaseConnection(HttpRequestBase httpRequest, Class<T> objectClass) {
        try {

            HttpResponse httpResponse = httpClient.execute(httpRequest);
            HttpEntity httpEntity = httpResponse.getEntity();
            if (httpEntity == null) {
                throw new RuntimeException("Error retrieving results from http request");
            }
            Object result = mapper.readValue(httpEntity.getContent(), Object.class);
            if (objectClass.isInstance(result)) {
                return objectClass.cast(result);
            }
            throw new RuntimeException("Can't parse retrieved object: " + result.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            httpRequest.releaseConnection();
        }
    }


}
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
class AddImageRequest {

    private Long versionId;
    private String description;
    private String ean;
    private String hashGroup;
    private String artNumber;
    private String author;
    private Boolean externalOCRCheck;
    private String imgBas64;

}
