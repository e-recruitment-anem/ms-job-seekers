package erecruitmentanem.msjobseeker.repositories;

import erecruitmentanem.msjobseeker.entities.DrivingLicense;
import erecruitmentanem.msjobseeker.entities.Education;
import erecruitmentanem.msjobseeker.entities.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface EducationRepository extends JpaRepository<Education,Long>, JpaSpecificationExecutor<Education> {
    List<Education> findAllByJobSeeker(JobSeeker jobSeeker);

}

