public class Movie implements Content {
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

    @Override
    public String getTitle() { return this.title; }

    @Override
    public String getImageURL() { return this.imageURL; }

    @Override
    public String getRating() { return this.rating; }

    @Override
    public String getYear() { return this.year; }

    @Override
    public void setTitle(String title) { this.title = title; }

    @Override
    public void setImageURL(String imageURL) { this.imageURL = imageURL; }

    @Override
    public void setRating(String rating) { this.rating = rating; }

    @Override
    public void setYear(String year) { this.year = year; }
}