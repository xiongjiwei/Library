package Data;

public class Book {
    private int id;
    private int yearPublished;
    private String name;
    private String author;

    public Book(int id, int yearPublished, String name, String author) {
        this.id = id;
        this.yearPublished = yearPublished;
        this.name = name;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }
}
