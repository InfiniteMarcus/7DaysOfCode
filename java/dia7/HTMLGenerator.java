import java.io.PrintWriter;
import java.util.List;
import java.lang.StringBuilder;

public class HTMLGenerator <T extends Content> {

    private PrintWriter writer;

    public HTMLGenerator(PrintWriter writer) {
        this.writer = writer;
    }

    public void generate(List<T> contentList) { 
        
        String head =
            """
            <!DOCTYPE html>
            <html lang=\"pt-br\">
                <head>
                    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">
                    <meta charset=\"utf-8\">
                    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
                    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" 
                        + "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">
                    <title>Desafio 7DaysOfCode - Java</title>
                </head>
            """;
        
        StringBuilder body = new StringBuilder();

        body.append("""
            <body>
                <main class=\"mt-4\">
        """);

        String divTemplate =
        """
        <div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">
            <h4 class=\"card-header\">%s</h4>
            <div class=\"card-body\">
                <img class=\"card-img\" src=\"%s\" alt=\"%s\">
                <p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>
            </div>
        </div>
        """;

        contentList.forEach(content -> {
            body.append("\t<div class=\"d-flex justify-content-center align-items-center flex-column mb-4\">");
            body.append(String.format(divTemplate, content.getTitle(), content.getImageURL(), content.getTitle(), content.getRating(), content.getYear()));
            body.append("</div>\n");
        });

        body.append("</main></body></html>");

        writer.print(head + body.toString());
    }
}