package erecruitmentanem.msjobseeker.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "drivingLicense")
@AllArgsConstructor
public class DrivingLicense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDrivingLicense")
    private Long idDrivingLicense ;

    private Date deliveryDate ;
    // Driving license type
    private Date category ;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idJobSeeker", nullable = false)
    private JobSeeker jobSeeker;
}
