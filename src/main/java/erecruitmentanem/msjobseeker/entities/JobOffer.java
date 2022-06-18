package erecruitmentanem.msjobseeker.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import erecruitmentanem.msjobseeker.enums.FamilySituation;
import erecruitmentanem.msjobseeker.enums.Gender;
import erecruitmentanem.msjobseeker.enums.MillitaryStatus;
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
@Table(name = "jobOffers")
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idJobOffer")
    private Long idJobOffer;

    private Number agency ;
    private String title ;
    private Number positionsNumber ;
    private Number avaialablePositionsNumber;
    private Number jobTitle ;//nomocloture
    private String workAddress ;
    private Number minAge ;
    private Number maxAge ;
    private Number[]  skills;
    private boolean closed ;

    @Enumerated(EnumType.STRING)
    private Gender gender ;

    private String contractType ;
    private Date closedAt ;
    private Date duration ;

    private String qualificationLevel ;
    private String educationLevel ;

    @Enumerated(EnumType.STRING)
    private Mobility mobility ;

    @Enumerated(EnumType.STRING)
    private FamilySituation familySituation ;

    @Enumerated(EnumType.STRING)
    private MillitaryStatus milltarySituation ;

    private Boolean deviceEligibilty ;
    private String description ;
    private Boolean nightWork ;
    private Boolean teamWork ;
    private Number residencyCity ;
    private String[] languages;
    private Boolean accomodation ;
    private Boolean transport ;
    private Boolean restauration ;
    private Number salary ;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEmployer", nullable = false)
    private Employer employer;
}
