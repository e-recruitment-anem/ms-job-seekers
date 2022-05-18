package erecruitmentanem.msjobseeker.repositories;

import erecruitmentanem.msjobseeker.entities.JobRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRequestRepository
        extends JpaRepository<JobRequest,Long> {
}
