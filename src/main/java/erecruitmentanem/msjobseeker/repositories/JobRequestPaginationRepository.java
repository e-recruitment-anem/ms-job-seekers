package erecruitmentanem.msjobseeker.repositories;

import erecruitmentanem.msjobseeker.entities.JobRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface JobRequestPaginationRepository extends PagingAndSortingRepository<JobRequest, Integer> {

    List<JobRequest> findAllByReason(String reason, Pageable pageable);
}
