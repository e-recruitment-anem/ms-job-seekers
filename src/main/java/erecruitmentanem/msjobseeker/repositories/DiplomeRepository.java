package erecruitmentanem.msjobseeker.repositories;

import erecruitmentanem.msjobseeker.entities.Diplome;
import erecruitmentanem.msjobseeker.entities.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface DiplomeRepository extends JpaRepository<Diplome,Long> {
    List<Diplome> findAllByJobSeeker(JobSeeker jobSeeker);
}