package erecruitmentanem.msjobseeker.DTOs;

import java.util.Date;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import erecruitmentanem.msjobseeker.enums.Gender;
import lombok.Data;

@Data
public class CreateJobSeeker {
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
    private String phoneNumber ;
}
