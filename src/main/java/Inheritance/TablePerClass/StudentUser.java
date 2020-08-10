package Inheritance.TablePerClass;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
public class StudentUser extends User {

    private String course;

}
