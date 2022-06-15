package erecruitmentanem.msjobseeker.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "professionalExperiences")
public class ProfessionalExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfessionalExperinece ;
    private Date startDate ;
    private Date endDate ;
    private Long idJobTitle ;
    private String description ;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false )
    @JoinColumn(name = "idJobSeeker", nullable = false)
    private JobSeeker jobSeeker;

}
