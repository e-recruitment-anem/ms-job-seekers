package erecruitmentanem.msjobseeker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import erecruitmentanem.msjobseeker.enums.JobRequestStatus;
import erecruitmentanem.msjobseeker.enums.Mobility;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobRequests")
public class JobRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idJobRequest")
    private Long idJobRequest ;

    private int agency ;
    private int admin ;
    private Date date ;
    private String reason ;
    private Boolean deviceEligibility ;
    private Boolean training ;
    private Boolean learning ;
    private Boolean nightWork ;
    private Boolean teamWork ;
    private Boolean avalibility ;

    @Enumerated(EnumType.STRING)
    private Mobility mobility ;

    private Boolean recycling ;

    @Enumerated(EnumType.STRING)
    private JobRequestStatus status ;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idJobSeeker", nullable = false)
    private JobSeeker jobSeeker;
}
