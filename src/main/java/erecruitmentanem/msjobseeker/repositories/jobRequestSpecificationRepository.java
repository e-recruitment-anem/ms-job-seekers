package erecruitmentanem.msjobseeker.repositories;


import erecruitmentanem.msjobseeker.entities.JobRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import java.util.List;

@Repository
public interface jobRequestSpecificationRepository extends JpaRepository<JobRequest, String>, JpaSpecificationExecutor<JobRequest> {
    public Page<JobRequest> findAll(Specification<JobRequest> spec, Pageable pageable);
    public List<JobRequest> findAll(Specification<JobRequest> spec);
}
