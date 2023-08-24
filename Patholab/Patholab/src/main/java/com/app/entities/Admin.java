package com.app.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="admin")
public class Admin {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="admin_id")
    private Long adminId;

    @NotBlank(message = "Admin name is required")
    @Column(name = "admin_name", length = 255)
    private String adminName;

    @NotBlank(message = "Admin last name is required")
    @Column(name = "admin_lastname", length = 255)
    private String adminLastName;

    @Email(message = "Invalid email address")
    @NotBlank(message = "Email is required")
    @Column(name="email",unique = true)
    private String email;

    @NotBlank(message = "Password is required")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
             message = "Password must be at least 8 characters long and contain at least one letter and one number")
    @Column(name="password")
    private String password;

    @NotNull(message = "Test ID is required")
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "testId")
    @Column(name="test_id")
    private List<Test> testId=new ArrayList<Test>();

    @NotNull(message = "Bill ID is required")
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "billId")
    
    private List <Bill> billId=new ArrayList<Bill>();

    @NotNull(message = "Employee ID is required")
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "employeeId") // mappedBy refers to the field in the child entity
  
    private List<Employee> employeeId=new ArrayList<Employee>();
  
    @NotNull(message = "Sample type is required")
    @Column(name="sample_type")
    private SampleType sampleType;

}
