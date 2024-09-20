package com.maeda.springboot.mvc;

import com.maeda.springboot.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;

public class Customer {
    private String firstName;
    @NotNull(message = "is required")
    @Size(min=1, message = "is required")
    private String lastName;
    @Min(value = 0, message = "Minimum value is 0.")
    @Max(value = 10, message = "Maximum value is 10.")
    @NotNull(message = "is required")
    private Integer freePasses;

    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "Only 5 chars/digits allowed.")
    @NotNull(message = "is required")
    private String postalCode;
    @CourseCode(value = "MD", message = "Courses must start with 'MD'")
    private String courseCode;

    public Customer() {
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

    public Integer getFreePasses() {
        return freePasses;
    }

    public void setFreePasses(Integer freePasses) {
        this.freePasses = freePasses;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}
