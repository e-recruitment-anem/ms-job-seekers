package erecruitmentanem.msjobseeker.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import erecruitmentanem.msjobseeker.entities.JobRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface JobRequestPaginationRepository<T, ID> extends CrudRepository<T, ID> {
    //Page<T> findAll(Pageable pageable);

    Page<JobRequest> findAll(Pageable pageable);
}
