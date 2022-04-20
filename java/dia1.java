import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.net.URI;

public class dia1 {
    public static void main (String args[]) {
        try {
            String apiKey = "";
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest
                .newBuilder()
                .uri(new URI("https://imdb-api.com/en/API/Top250Movies/" + apiKey))
                .GET()
                .build();

            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}