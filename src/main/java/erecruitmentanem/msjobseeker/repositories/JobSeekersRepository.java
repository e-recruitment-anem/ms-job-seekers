package erecruitmentanem.msjobseeker.repositories;
import erecruitmentanem.msjobseeker.entities.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekersRepository
        extends JpaRepository<JobSeeker,Long> {
}
