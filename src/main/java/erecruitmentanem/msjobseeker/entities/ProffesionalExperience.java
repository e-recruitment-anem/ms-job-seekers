package erecruitmentanem.msjobseeker.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProffesionalExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfExperinece ;
    private Date startDate ;
    private Date endDate ;
    private Long idJobTitle ;
    private String description ;

}
