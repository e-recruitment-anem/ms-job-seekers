package erecruitmentanem.msjobseeker.DTOs.JobSeekersDTOs;

import java.sql.Date;

import erecruitmentanem.msjobseeker.enums.Disability;
import erecruitmentanem.msjobseeker.enums.FamilySituation;
import erecruitmentanem.msjobseeker.enums.Gender;
import erecruitmentanem.msjobseeker.enums.IdentityCardType;
import erecruitmentanem.msjobseeker.enums.MillitaryStatus;
import lombok.Data;

@Data
public class JobSeekerDto {
    private String firstName ;
    private String lastName ;
    private Gender gender ;
    private Date birthDate ;
    private String birthPlace ;
    private String address ;
    private String postalCode ;
    private Number residenceCity ;
    private String nationality ;
    private IdentityCardType identityCardType ;
    private Number identityCardNumber ;
    private Date identityCardDelivryDate;
    private Number identityCardDelivryCity ;
    private String phoneNumber ;
    private String educationalLevel ;
    private String qualificationLevel ;
    private MillitaryStatus milltarySituation ;
    private FamilySituation familySituation ;
    private Number children ;
    private Number minSalary ;
    private Disability disability ;
}
