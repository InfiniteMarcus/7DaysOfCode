import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class ImdbMovieJsonParser implements JsonParser {
    private String json;

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

    public ImdbMovieJsonParser(String json) {
        this.json = json;
    }

    @Override
    public List<Movie> parse() {
        String[] moviesArray = parseJsonMovies(this.json);

        return parseMovies(moviesArray);
    }
}