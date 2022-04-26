import java.util.List;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;

public class dia7 {

    public static void main (String args[]) {
        try {
            String apiKey = "";
            String json = new ImdbApiClient(apiKey).getBody();

            List<Movie> movies = new ImdbMovieJsonParser(json).parse();

            /*
            movies.forEach(movie -> {
                System.out.println(movie.getTitle() + " : " + movie.getRating());
            });
            */

            PrintWriter writer = new PrintWriter("index.html");

            HTMLGenerator ht = new HTMLGenerator<Movie>(writer);

            Collections.sort(movies, Comparator.reverseOrder());

            ht.generate(movies);

            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
