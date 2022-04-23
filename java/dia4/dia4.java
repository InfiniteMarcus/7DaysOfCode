import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.net.URI;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.io.PrintWriter;

public class dia4 {

    private static String[] parseJsonMovies(String json) {
        return json.substring(json.indexOf("[") + 1, json.indexOf("]")-1).replace("{", "").split("},");
    }

    private static List<String> parseMovieAttributes(String movie) {
        String[] attributesWithNames = movie.split("\",\"");

        List<String> attributesValues = new ArrayList<String>();

        for(String attribute : attributesWithNames){
            String[] attributeSplitted = attribute.split(":\"");
            attributesValues.add(attributeSplitted[1].replace("\"", ""));
        }

        return attributesValues;
    }

    private static List<Movie> parseMovies(String [] movieArray) {
        List<Movie> list = new ArrayList<Movie>();

        List<String> movieArrayAsList = Arrays.asList(movieArray);

        for(String movie : movieArrayAsList ){
            List<String> attributes = parseMovieAttributes(movie);

            String title = attributes.get(3);
            String imageURL = attributes.get(5);
            String rating = attributes.get(7);
            String year = attributes.get(4);

            Movie m = new Movie (title, imageURL, rating, year);
            list.add(m);
        }
        return list;
    }

    public static void main (String args[]) {
        try {
            String apiKey = "";
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest
                .newBuilder()
                .uri(new URI("https://imdb-api.com/en/API/Top250Movies/" + apiKey))
                .GET()
                .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            String[] moviesArray = parseJsonMovies(json);

            List<Movie> movies = parseMovies(moviesArray);

            /*
            movies.forEach(movie -> {
                System.out.println(movie.getTitle() + " : " + movie.getRating());
            });
            */

            PrintWriter writer = new PrintWriter("index.html");

            HTMLGenerator ht = new HTMLGenerator(writer);
            ht.generate(movies);

            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
