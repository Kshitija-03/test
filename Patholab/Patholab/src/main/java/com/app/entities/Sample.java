package com.app.entities;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
@Entity
public class Sample {
	@Id
	private Long sampleId;
	private SampleType sampleType;
	@ManyToOne
    @JoinColumn(name = "test_id")
	private Test testId;
	
	@ManyToOne
    @JoinColumn(name = "employee_id")
	private Employee employeeId;
	
	@ManyToOne
    @JoinColumn(name = "patient_id")
	private Patient patientId;

    @Column(name = "is_collected", nullable = false)
	private boolean isCollected;
	
	@Column(name = "created_on")
    private Timestamp createdOn;

    @NotBlank(message = "Created By is required")
    @Column(name = "created_by", length = 255)
    private String createdBy;

    @Column(name = "modify_on")
    private Timestamp modifyOn;

    @Column(name = "modify_by", length = 255)
    private String modifyBy;
}
