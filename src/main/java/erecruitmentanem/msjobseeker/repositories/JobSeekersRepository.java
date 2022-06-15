package erecruitmentanem.msjobseeker.repositories;
import erecruitmentanem.msjobseeker.entities.JobRequest;
import erecruitmentanem.msjobseeker.entities.JobSeeker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface JobSeekersRepository extends JpaRepository<JobSeeker,Long>, JpaSpecificationExecutor<JobSeeker> {
     Page<JobSeeker> findAll(Specification<JobSeeker> spec, Pageable pageable);
     List<JobSeeker> findAll(Specification<JobSeeker> spec);
}
