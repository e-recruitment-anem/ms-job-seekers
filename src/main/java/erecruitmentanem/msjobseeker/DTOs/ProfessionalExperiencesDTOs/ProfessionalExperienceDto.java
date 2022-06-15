package erecruitmentanem.msjobseeker.DTOs.ProfessionalExperiencesDTOs;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessionalExperienceDto {
    private Date startDate ;
    private Date endDate ;
    private Long idJobTitle ;
    private String description ;
}
