package Data;

public class Movie {
    private int id;
    private int year;
    private int rating;
    private String name;
    private String director;

    public Movie(int id, int year, int rating, String name, String director) {
        this.id = id;
        this.year = year;
        this.rating = rating;
        this.name = name;
        this.director = director;
    }

    public int getId() {
        return id;
    }

    public int getYear() {
        return year;
    }

    public int getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public String getDirector() {
        return director;
    }
}
