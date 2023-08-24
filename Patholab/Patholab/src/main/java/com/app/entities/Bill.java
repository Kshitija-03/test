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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@NoArgsConstructor // generates def ctor
@AllArgsConstructor // all args ctor
@Getter // all getters
@Setter // setters
@Table(name="bill")
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="bill_id")
    private Long billId;

    @Column(name = "is_paid", nullable = false)
    private boolean isPaid;

    @NotNull(message = "Amount is required")
    private Integer amount;

    @NotNull(message = "Phone number is required")
    @Digits(integer = 10, fraction = 0, message = "Phone number should not exceed 10 digits")
    @Column(name="phone_no")
    private Long phoneNo;
    
    @NotNull(message = "Patient ID is required")
    @OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name="patientId")
    
    private Patient patientId;
    
    @ManyToOne
    @JoinColumn(name = "adminId")
    private Admin adminId;
    
    @NotNull(message = "Test ID is required")
    @OneToMany(cascade=CascadeType.ALL,mappedBy = "testId")
   
    private List<Test> testId=new ArrayList<Test>();

    @NotNull(message = "Collected date is required")
    @Temporal(TemporalType.DATE)
    @Column(name="collected_date")
    private Date collectedDate;

    @Column(name = "is_collected", nullable = false)
    private boolean isCollected;

    @NotBlank(message = "Created by is required")
    @Size(max = 255, message = "Created by should not exceed 255 characters")
    @Column(name="created_by")
    private String createdBy;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="modify_on")
    private Date modifyOn;

    @Size(max = 255, message = "Modify by should not exceed 255 characters")
    @Column(name="modify_by")
    private String modifyBy;
    
    
   

}
