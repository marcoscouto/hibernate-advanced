package Collections;
import org.hibernate.annotations.SortComparator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="student")
public class Student implements Comparator<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @ElementCollection
    @CollectionTable(name = "image")
    @MapKeyJoinColumn(name = "student_id")
    @MapKeyColumn(name = "file_name")
    @Column(name = "image_name")
//    @OrderBy("file_name ASC")
    @SortComparator(StudentComparator.class)
    private Map<String, String> image = new TreeMap<>();

//    @ElementCollection
//    @CollectionTable(name = "image", joinColumns = @JoinColumn(name = "student_id"))
//    @Column(name = "file_name")
//    @OrderBy("file_name ASC")
//    private Set<String> image = new HashSet<>();
//
//    @ElementCollection
//    @CollectionTable(name = "image")
//    @OrderColumn(name = "order_file")
//    @Column(name = "file_name")
//    private List<String> image = new ArrayList<>();

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, String> getImages() {
        return image;
    }

    public void setImages(Map<String, String> images) {
        this.image = images;
    }


    @Override
    public int compare(String o1, String o2) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(email, student.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", image=" + image +
                '}';
    }
}
