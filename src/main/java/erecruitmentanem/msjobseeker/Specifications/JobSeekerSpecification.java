package erecruitmentanem.msjobseeker.Specifications;

import erecruitmentanem.msjobseeker.entities.JobSeeker;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JobSeekerSpecification {
    public Specification<JobSeeker> getJobSeekers(JobSeeker request) {
        return (root, query, criteriaBuilder) -> {
            System.out.print("Spec");
            List<Predicate> predicates = new ArrayList<>();
            if (request.getFirstName() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("firstName"),request.getFirstName()));
            }
            if (request.getLastName() != null) {
                predicates.add(criteriaBuilder.equal(root.get("lastName"), request.getLastName()));
            }
            if (request.getGender() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("gender"), request.getGender()));
            }
            if (request.getBirthDate() != null) {
                predicates.add(criteriaBuilder.equal(root.get("birthDate"), request.getBirthDate()));
            }
            if (request.getBirthPlace() != null) {
                predicates.add(criteriaBuilder.equal(root.get("birthPlace"), request.getBirthPlace()));
            }
            if (request.getAddress() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("address"), request.getAddress()));
            }
            if (request.getPostalCode() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("postalCode"), request.getPostalCode()));
            }
            if (request.getResidenceCity() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("residenceCity"), request.getResidenceCity()));
            }
            if (request.getNationality() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("nationality"), request.getNationality()));
            }
            if (request.getIdentityCardType() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("identityCardType"), request.getIdentityCardType()));
            }
            if (request.getIdentityCardNumber() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("identityCardNumber"), request.getIdentityCardNumber()));
            }
            if (request.getIdentityCardDelivryDate() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("identityCardDelivryDate"), request.getIdentityCardDelivryDate()));
            }
            if (request.getIdentityCardDelivryCity() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("identityCardDelivryCity"), request.getIdentityCardDelivryCity()));
            }
            if (request.getPhoneNumber() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("phoneNumber"), request.getPhoneNumber()));
            }
            if (request.getEducationalLevel() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("educationalLevel"), request.getEducationalLevel()));
            }
            if (request.getQualificationLevel() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("qualificationLevel"), request.getQualificationLevel()));
            }
            if (request.getLanguages() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("languages"), request.getLanguages()));
            }
            if (request.getSkills() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("skills"), request.getSkills()));
            }
            if (request.getMilltarySituation() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("milltarySituation"), request.getMilltarySituation()));
            }
            if (request.getFamilySituation() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("familySituation"), request.getFamilySituation()));
            }
            if (request.getChildren() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("children"), request.getChildren()));
            }
            if (request.getMinSalary() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("minSalary"), request.getMinSalary()));
            }
            if (request.getDisability() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("disability"), request.getDisability()));
            }


            query.orderBy(criteriaBuilder.desc(root.get("lastName")));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
