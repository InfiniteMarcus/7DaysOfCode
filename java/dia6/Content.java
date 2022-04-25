public interface Content {
    String getTitle();
    String getImageURL();
    String getRating();
    String getYear();

    void setTitle(String title);
    void setImageURL(String imageURL);
    void setRating(String rating);
    void setYear(String year);
}

//javac dia6.java Content.java HTMLGenerator.java ImdbApiClient.java ImdbMovieJsonParser.java JsonParser.java Movie.java
//java dia6 Content HTMLGenerator ImdbApiClient ImdbMovieJsonParser JsonParser Movie   