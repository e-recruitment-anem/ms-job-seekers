package erecruitmentanem.msjobseeker.repositories;

import erecruitmentanem.msjobseeker.entities.Education;
import erecruitmentanem.msjobseeker.entities.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EmployerRepository extends JpaRepository<Employer,Long>, JpaSpecificationExecutor<Employer> {
}
