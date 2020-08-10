package Inheritance.SingleTable;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "STUDENT")
@Data
public class StudentUser extends User {

    private String course;

}
