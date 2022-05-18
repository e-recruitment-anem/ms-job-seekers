package erecruitmentanem.msjobseeker.entities;

import javax.persistence.*;

import erecruitmentanem.msjobseeker.enums.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobSeekers")
public class JobSeeker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idJobSeeker")
    private Long idJobSeeker ;

    private String firstName ;
    private String lastName ;

    @Enumerated(EnumType.STRING)
    private Gender gender ;

    private Date birthDate ;
    private String birthPlace ;
    private String address ;
    private String postalCode ;
    private Number residenceCity ;
    private String nationality ;

    @Enumerated(EnumType.STRING)
    private IdentityCardType identityCardType ;

    private Number identityCardNumber ;
    private Date identityCardDelivryDate;
    private Number identityCardDelivryCity ;
    private String phoneNumber ;
    private String educationalLevel ;
    private String qualificationLevel ;
    private String languages ;
    private Number skills ;

    @Enumerated(EnumType.STRING)
    private MillitaryStatus milltarySituation ;

    @Enumerated(EnumType.STRING)
    private FamilySituation familySituation ;

    private Number children ;
    private Number minSalary ;

    @Enumerated(EnumType.STRING)
    private Disability disability ;


    @OneToMany(mappedBy = "jobSeeker", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<JobRequest> jobRequest;
}
