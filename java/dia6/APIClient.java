import java.io.IOException;
import java.net.URISyntaxException;
import java.lang.InterruptedException;

public interface APIClient {
    String getBody() throws IOException, URISyntaxException, InterruptedException;
    String getType();
}