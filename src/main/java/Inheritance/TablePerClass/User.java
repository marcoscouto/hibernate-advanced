package Inheritance.TablePerClass;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
}
