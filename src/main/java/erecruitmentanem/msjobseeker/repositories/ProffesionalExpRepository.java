package erecruitmentanem.msjobseeker.repositories;

import erecruitmentanem.msjobseeker.entities.ProffesionalExperience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProffesionalExpRepository
        extends JpaRepository<ProffesionalExperience,Long> {
}
