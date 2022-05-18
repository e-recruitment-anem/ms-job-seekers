package erecruitmentanem.msjobseeker.repositories;

import erecruitmentanem.msjobseeker.entities.ProfessionalExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProffesionalExpRepository
        extends JpaRepository<ProfessionalExperience,Long> {
}
