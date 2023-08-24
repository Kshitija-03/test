package com.app.entities;

import java.security.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

public class Report {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "report_id")
	    private Long reportId;
	    
	    @NotNull(message = "test_id is required")
	    @MapsId
	    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	    @JoinColumn(name = "test_id")
	    private Long testId;

	    @NotNull(message = "employee_id is required")
	    @MapsId
	    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	    @JoinColumn(name = "employee_id")
	    private Long employeeId;

	    @NotNull(message = "patient_id is required")
	    @MapsId
	    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	    @JoinColumn(name = "patient_id")
	    private Long patientId;
	    
	    @Column(name = "result_value", length = 255)
	    private String resultValue;

	    @Column(name = "comment", columnDefinition = "TEXT")
	    private String comment;

	    @Column(name = "created_on")
	    private Timestamp createdOn;

	    @Column(name = "created_by", length = 255)
	    private String createdBy;

	    @Column(name = "modify_on")
	    private Timestamp modifyOn;

	    @Column(name = "modify_by", length = 255)
	    private String modifyBy;

}
