package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity

@Table(name = "patient")
@NoArgsConstructor // generates def ctor
@AllArgsConstructor // all args ctor
@Getter // all getters
@Setter // setters
public class Patient {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="patient_id")
    private Long patientId;
	 @NotBlank(message = "First name is required")
	 @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
	 @Column(name="patient_first_name")
	 private String patientFirstName;

	 @NotBlank(message = "Last name is required")
	 @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
	 @Column(name="patient_last_name")
	 private String patientLastName;
	 
	 @Enumerated(EnumType.STRING)
	 @NotNull(message = "Gender is required")
	 private Gender gender;
	 
	 @NotBlank(message = "Address is required")
	    @Size(min = 5, max = 200, message = "Address must be between 5 and 200 characters")
	    private String address;

	    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
	    @Column(name="phone_no")
	    private String phoneNo;
	    
	    @Email(message = "Invalid email address")
	    @NotBlank(message = "Email is required")
	    @Column(unique = true)
	    private String email;

	    @NotBlank(message = "Password is required")
	    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
	             message = "Password must be at least 8 characters long and contain at least one letter and one number")
	    private String password;

	    @Size(max = 500, message = "Medical history should not exceed 500 characters")
	    @Column(name="medical_history")
	    private String medicalHistory;

	    @NotNull(message = "Created on date is required")
	    @PastOrPresent(message = "Created on date must be in the past or present")
	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name="created_on")
	    private Date createdOn;

	    @NotBlank(message = "Created by is required")
	    @Size(min = 2, max = 50, message = "Created by must be between 2 and 50 characters")
	    @Column(name="created_by")
	    private String createdBy;

	    @Temporal(TemporalType.TIMESTAMP)
	    @Column(name="modify_on")
	    private Date modifyOn;

	    @Size(max = 50, message = "Modified by should not exceed 50 characters")
	    private String modifyBy;
	    
	    @NotNull(message = "testId is required")
	    @OneToMany(cascade=CascadeType.ALL, mappedBy = "testId") // mappedBy refers to the field in the child entity
	    private List<Test> testId=new ArrayList<Test>();
	    
	    @NotNull(message = "Date of birth is required")
	    @PastOrPresent(message = "Date of birth must be in the past or present")
	    @Column(name = "date_of_birth")
	    private LocalDate dateOfBirth;
	    
	    @NotNull(message = "Sample ID is required")
	    @OneToMany(cascade=CascadeType.ALL,mappedBy = "sampleId")
	   
	    
	    private List<Sample> sampleId=new ArrayList<Sample>();
	   
	    
}
