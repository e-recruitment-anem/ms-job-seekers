package erecruitmentanem.msjobseeker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import erecruitmentanem.msjobseeker.entities.JobRequest;

public interface JobRequestRepository
    extends JpaRepository<JobRequest,Long> {
}


