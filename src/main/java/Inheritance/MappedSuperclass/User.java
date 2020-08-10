package Inheritance.MappedSuperclass;

import lombok.Data;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
}
