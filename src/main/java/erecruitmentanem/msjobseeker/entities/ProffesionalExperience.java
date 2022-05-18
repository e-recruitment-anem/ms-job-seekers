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
@Table(name = "proffesionalExperiences")
public class ProffesionalExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfExperinece ;
    private Date startDate ;
    private Date endDate ;
    private Long idJobTitle ;
    private String description ;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idJobSeeker", nullable = false)
    private JobSeeker jobSeeker;

}
