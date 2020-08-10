package Inheritance.MappedSuperclass;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

@Entity
@Data
public class InstructorUser extends User {

    private Double salary;

}
