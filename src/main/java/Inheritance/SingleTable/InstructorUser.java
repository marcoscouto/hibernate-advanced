package Inheritance.SingleTable;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "INSTRUCTOR")
@Data
public class InstructorUser extends User {

    private Double salary;

}
