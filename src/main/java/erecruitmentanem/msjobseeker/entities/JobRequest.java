package erecruitmentanem.msjobseeker.entities;

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
public class JobRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idJobRequest ;

    private Number agency ;
    private Number admin ;
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


}
