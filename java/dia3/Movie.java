public class Movie {
    private String title;
    private String imageURL;
    private String rating;
    private String year;

    public Movie (String title, String imageURL, String rating, String year) {
        this.title = title;
        this.imageURL = imageURL;
        this.rating = rating;
        this.year = year;
    }

    public String getTitle() { return this.title; }

    public String getImageURL() { return this.imageURL; }

    public String getRating() { return this.rating; }

    public String getYear() { return this.year; }

    public void setTitle(String title) { this.title = title; }

    public void setImageURL(String imageURL) { this.imageURL = imageURL; }

    public void setRating(String rating) { this.rating = rating; }

    public void setYear(String year) { this.year = year; }
}