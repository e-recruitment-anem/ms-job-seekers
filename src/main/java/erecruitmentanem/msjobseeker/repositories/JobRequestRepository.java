package erecruitmentanem.msjobseeker.repositories;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import erecruitmentanem.msjobseeker.entities.JobRequest;
import erecruitmentanem.msjobseeker.entities.JobSeeker;


@RepositoryRestResource
public interface JobRequestRepository
    extends JpaRepository<JobRequest,Long>, JpaSpecificationExecutor<JobRequest>
    {

         Page<JobRequest> findAll(Specification<JobRequest> spec, Pageable pageable);
         List<JobRequest> findAll(Specification<JobRequest> spec);
         List<JobRequest> findAllByJobSeeker(JobSeeker jobSeeker);

    }


