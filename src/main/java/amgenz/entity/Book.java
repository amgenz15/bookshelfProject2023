package amgenz.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Book.
 */
@Entity(name = "Book")
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String title;
    private String summary;
    private String genre;
    private int series;
    @ManyToOne
    @JoinColumn(name = "authorId",
            foreignKey = @ForeignKey(name = "book_author_id_fk")
    )
    private Author author;

    /**
     * Instantiates a new Book.
     */
    public Book() {
    }

    /**
     * Instantiates a new Book.
     *
     * @param title   the title
     * @param summary the summary
     * @param genre   the genre
     * @param series  the series
     * @param author  the author
     */
    public Book(String title, String summary, String genre, int series, Author author) {
        this.title = title;
        this.summary = summary;
        this.genre = genre;
        this.series = series;
        this.author = author;
    }


    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets summary.
     *
     * @return the summary
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Sets summary.
     *
     * @param summary the summary
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Gets genre.
     *
     * @return the genre
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Sets genre.
     *
     * @param genre the genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Gets series.
     *
     * @return the series
     */
    public int getSeries() {
        return series;
    }

    /**
     * Sets series.
     *
     * @param series the series
     */
    public void setSeries(int series) {
        this.series = series;
    }

    /**
     * Gets author.
     *
     * @return the author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * Sets author.
     *
     * @param author the author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", genre='" + genre + '\'' +
                ", series=" + series +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id && series == book.series && Objects.equals(title, book.title) && Objects.equals(summary, book.summary) && Objects.equals(genre, book.genre) && Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, summary, genre, series, author);
    }
}