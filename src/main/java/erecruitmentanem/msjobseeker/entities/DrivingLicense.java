package erecruitmentanem.msjobseeker.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "drivingLicense")
public class DrivingLicense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDrivingLicense")
    private Long idDrivingLicense ;

    private Date deliveryDate ;
    private Date category ;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idJobSeeker", nullable = false)
    private JobSeeker jobSeeker;
}
