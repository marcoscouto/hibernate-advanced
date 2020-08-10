package Inheritance.JoinedTable;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Data
public class InstructorUser extends User {

    private Double salary;

}
