package erecruitmentanem.msjobseeker.repositories;

import erecruitmentanem.msjobseeker.entities.DrivingLicense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrivingLicenseRespository
        extends JpaRepository<DrivingLicense,Long> {
}
