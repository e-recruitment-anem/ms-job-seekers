package erecruitmentanem.msjobseeker.Specifications;
import erecruitmentanem.msjobseeker.entities.JobRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JobRequestSpecification {
    public Specification<JobRequest> getUsers(JobRequest request) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();
            if (request.getAgency() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("agency"), request.getAgency()));
            }
            if (request.getAdmin() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("admin"), request.getDate()));
            }
            if (request.getDate() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("date"), request.getDate()));
            }
            if (request.getReason() != null && !request.getReason().isEmpty()) {
                predicates.add(criteriaBuilder.equal(root.get("reason"), request.getReason()));
            }
            if (request.getDeviceEligibility() != null) {
                predicates.add(criteriaBuilder.equal(root.get("deviceEligibility"), request.getDeviceEligibility()));
            }
            if (request.getTraining() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("training"), request.getTraining()));
            }
            if (request.getLearning() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("learning"), request.getLearning()));
            }
            if (request.getNightWork() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("nightWork"), request.getNightWork()));
            }
            if (request.getTeamWork() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("teamWork"), request.getTeamWork()));
            }
            if (request.getAvalibility() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("avalibility"), request.getAvalibility()));
            }
            query.orderBy(criteriaBuilder.desc(root.get("experience")));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
