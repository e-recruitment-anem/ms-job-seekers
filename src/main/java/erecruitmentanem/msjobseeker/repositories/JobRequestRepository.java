package erecruitmentanem.msjobseeker.repositories;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import erecruitmentanem.msjobseeker.entities.JobRequest;

@Repository
public interface JobRequestRepository
    extends JpaRepository<JobRequest,Long>, JpaSpecificationExecutor<JobRequest> {

        public Page<JobRequest> findAll(Specification<JobRequest> spec, Pageable pageable);
        public List<JobRequest> findAll(Specification<JobRequest> spec);
}


