package amgenz.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * The type Author.
 */
@Entity(name = "Author")
@Table(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_Name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    private String about;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Book> bookList = new HashSet<>();

    /**
     * Instantiates a new Author.
     */
    public Author() {
    }

    /**
     * Instantiates a new Recipe.
     *
     * @param firstName  author's first name
     * @param middleName author's middle name
     * @param lastName   author's last name
     * @param about      author's about information
     */
    public Author(String firstName, String middleName, String lastName, String about) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.about = about;
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
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets middle name.
     *
     * @return the middle name
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Sets middle name.
     *
     * @param middleName the middle name
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets about.
     *
     * @return the about
     */
    public String getAbout() {
        return about;
    }

    /**
     * Sets about.
     *
     * @param about the about
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     * Gets book list.
     *
     * @return the book list
     */
    public Set<Book> getBookList() {
        return bookList;
    }

    /**
     * Sets book list.
     *
     * @param bookList the book list
     */
    public void setBookList(Set<Book> bookList) {
        this.bookList = bookList;
    }

    /**
     * Add book.
     *
     * @param book the author's book
     */
    public void addBook(Book book) {
        bookList.add(book);
        book.setAuthor(this);
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", about='" + about + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return id == author.id && firstName.equals(author.firstName) && Objects.equals(middleName, author.middleName) && lastName.equals(author.lastName) && about.equals(author.about);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, middleName, lastName, about);
    }
}



