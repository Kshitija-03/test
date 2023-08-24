package com.app.entities;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor // generates def ctor
@AllArgsConstructor // all args ctor
@Getter // all getters
@Setter // setters
@Table(name="test")
public class Test {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long testId;

	    @NotNull(message = "Patient ID is required")
	    @ManyToOne
	    @JoinColumn(name = "patientId")
	    private Patient patientId;

	    @NotBlank(message = "Test Name is required")
	    @Column(name = "Test_Name", length = 255)
	    private String testName;

	    @NotNull(message = "Test Price is required")
	    @Column(name = "Test_Price")
	    private Integer testPrice;
	    
	    @ManyToOne
	    @JoinColumn(name = "adminId")
	    private Admin adminId;

	    @Column(name = "created_on")
	    private Timestamp createdOn;

	    @NotBlank(message = "Created By is required")
	    @Column(name = "created_by", length = 255)
	    private String createdBy;

	    @Column(name = "modify_on")
	    private Timestamp modifyOn;

	    @Column(name = "modify_by", length = 255)
	    private String modifyBy;

	    @NotNull(message = "Sample ID is required")
	    @OneToMany(cascade=CascadeType.ALL,mappedBy = "sampleId")
	   
	    private List<Sample> sampleId=new ArrayList<Sample>();
	    
}
