package com.app.dto;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PatientDto {

//   
//    @NotBlank(message = "First name is required")
//    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    private String patientFirstName;

//    @NotBlank(message = "Last name is required")
//    @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
    private String patientLastName;

//    @NotNull(message = "Gender is required")
//    private String gender;

//    @NotBlank(message = "Address is required")
//    @Size(min = 5, max = 200, message = "Address must be between 5 and 200 characters")
    private String address;

//    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
    private String phoneNo;

//    @Email(message = "Invalid email address")
//    @NotBlank(message = "Email is required")
    private String email;

//    @NotBlank(message = "Password is required")
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
//            message = "Password must be at least 8 characters long and contain at least one letter and one number")
    private String password;

//    @Size(max = 500, message = "Medical history should not exceed 500 characters")
    private String medicalHistory;

//    @NotNull(message = "Date of birth is required")
//    @PastOrPresent(message = "Date of birth must be in the past or present")
    private LocalDate dateOfBirth;
    private String createdBy;
    private Date createdOn;
    private Date modifyOn;
    private String modifyBy;

}
