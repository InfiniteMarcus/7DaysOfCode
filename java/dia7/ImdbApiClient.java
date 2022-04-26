import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.net.URI;
import java.io.IOException;
import java.net.URISyntaxException;
import java.lang.InterruptedException;

public class ImdbApiClient implements APIClient{

    private String apiKey;

    public ImdbApiClient(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String getBody() throws IOException, URISyntaxException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

         HttpRequest request = HttpRequest
            .newBuilder()
            .uri(new URI("https://imdb-api.com/en/API/Top250Movies/" + this.apiKey))
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    @Override
    public String getType() { return "Movie"; }
}