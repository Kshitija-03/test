package com.app.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor // generates def ctor
@AllArgsConstructor // all args ctor
@Getter // all getters
@Setter // setters
@Table(name="employee")
public class Employee {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name="employee_id")
	    private Long employeeId;

	    @NotBlank(message = "First name is required")
	    @Column(name = "first_name", length = 255)
	    private String firstName;

	    @NotBlank(message = "Last name is required")
	    @Column(name = "last_name", length = 255)
	    private String lastName;

	    @NotNull(message = "Patient ID is required")
	    @MapsId
	    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	   
	    private Patient patientId;
	    
	    @ManyToOne
	    @JoinColumn(name = "admin_id")
	    private Admin adminId;

	    @Email(message = "Invalid email address")
	    @NotBlank(message = "Email is required")
	    @Column(unique = true)
	    private String email;

	    @NotBlank(message = "Password is required")
	    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
	             message = "Password must be at least 8 characters long and contain at least one letter and one number")
	    private String password;

	    @NotNull(message = "Sample type is required")
	    @Column(name="sample_type")
	    private SampleType sampleType;

	    @NotNull(message = "Bill ID is required")
	    @OneToOne(cascade=CascadeType.ALL ,fetch = FetchType.LAZY)
	    @JoinColumn(name = "bill_id")
	    @MapsId
	    private Bill billId;

	    @NotNull(message = "Availability status is required")
	    @Column(name = "is_available")
	    private boolean isAvailable;

	    @NotNull(message = "Phone number is required")
	    @Column(name = "phone_no")
	    private Long phoneNo;
	    
	    @NotNull(message = "Sample ID is required")
	    @OneToMany(cascade=CascadeType.ALL,mappedBy = "sampleId")
	    
	    private List<Sample> sampleId=new ArrayList<Sample>();

	    
	    
}
