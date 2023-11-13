package amgenz.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Genre.
 */
@Entity(name = "Genre")
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "genre_name")
    private String genre;

    @ManyToOne
    private Book book;

    /**
     * Instantiates a new Genre.
     */
    public Genre() {
    }

    /**
     * Instantiates a new Genre.
     *
     * @param id    the id
     * @param genre the genre
     */
    public Genre(int id, String genre) {
        this.id = id;
        this.genre = genre;
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

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", genre='" + genre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre1 = (Genre) o;
        return id == genre1.id && genre.equals(genre1.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, genre);
    }
}