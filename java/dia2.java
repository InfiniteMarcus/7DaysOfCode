import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.net.URI;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class dia2 {

    private static String[] parseJsonMovies(String json) {
        return json.substring(json.indexOf("[") + 1, json.indexOf("]")-1).replace("{", "").split("},");
    }

    private static List<String> parseTitles (String [] movieArray) {
        List<String> list = new ArrayList<String>();

        List<String> movieArrayAsList = Arrays.asList(movieArray);

        for(String movie : movieArrayAsList )
            list.add(movie.substring(movie.indexOf("\"title\":\"") + 9, movie.indexOf(",\"fullTitle")-1));

        return list;
    }

    private static List<String> parseUrlImages (String [] movieArray) {
        List<String> list = new ArrayList<String>();

        List<String> movieArrayAsList = Arrays.asList(movieArray);

        for(String movie : movieArrayAsList )
            list.add(movie.substring(movie.indexOf("\"image\":\"") + 9, movie.indexOf(",\"crew")-1));

        return list;
    }

    private static List<String> parseRatings(String [] movieArray) {
        List<String> list = new ArrayList<String>();

        List<String> movieArrayAsList = Arrays.asList(movieArray);

        for(String movie : movieArrayAsList )
            list.add(movie.substring(movie.indexOf("\"imDbRating\":\"") + 14, movie.indexOf(",\"imDbRatingCount")-1));

        return list;
    }

    private static List<String> parseYears(String [] movieArray) {
        List<String> list = new ArrayList<String>();

        List<String> movieArrayAsList = Arrays.asList(movieArray);

        for(String movie : movieArrayAsList )
            list.add(movie.substring(movie.indexOf("\"year\":\"") + 8, movie.indexOf(",\"image")-1));

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
            
            List<String> titles = parseTitles(moviesArray);
            //titles.forEach(System.out::println);

            List<String> urlImages = parseUrlImages(moviesArray);
            //urlImages.forEach(System.out::println);

            List<String> ratings = parseRatings(moviesArray);
            //ratings.forEach(System.out::println);

            List<String> years = parseYears(moviesArray);
            //years.forEach(System.out::println);

            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}