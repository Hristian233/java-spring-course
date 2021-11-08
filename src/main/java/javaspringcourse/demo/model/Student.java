package javaspringcourse.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="All details about the user.")
@Entity
public class Student {

    @Id
    @GeneratedValue
    private int id;

    @Size(min=3,max = 30, message="First name should be at least 3 and at most 30 characters")
    @ApiModelProperty(notes="First name should be at least 3 and at most 30 characters")
    @NotBlank(message = "First name is mandatory")
    private String firstName;

    @Size(min=3,max = 30, message="Last name should be at least 3 and at most 30 characters")
    @ApiModelProperty(notes="Last name should be at least 3 and at most 30 characters")
    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @Past
    @ApiModelProperty(notes="Birth date should be in the past")
    private Date birthDate;

    public Student(String firstName, String lastName, int id, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.birthDate = birthDate;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
