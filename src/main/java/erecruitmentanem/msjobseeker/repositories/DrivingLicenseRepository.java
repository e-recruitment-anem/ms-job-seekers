package erecruitmentanem.msjobseeker.repositories;

import erecruitmentanem.msjobseeker.entities.DrivingLicense;
import erecruitmentanem.msjobseeker.entities.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrivingLicenseRepository extends JpaRepository<DrivingLicense,Long> {
    List<DrivingLicense> findAllByJobSeeker(JobSeeker jobSeeker);

}
