package erecruitmentanem.msjobseeker.repositories;

import erecruitmentanem.msjobseeker.entities.ProfessionalExperience;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProfessionalExperienceRepository
        extends JpaRepository<ProfessionalExperience,Long> {
                @Query("SELECT e FROM ProfessionalExperience e WHERE e.jobSeeker.idJobSeeker=:id")
                public List<ProfessionalExperience> findAllByJobSeekerId(Long id);
}
