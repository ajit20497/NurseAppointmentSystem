package com.amdocsProject.NurseAppointmentSystem.ProjectRepo;

import com.amdocsProject.NurseAppointmentSystem.ProjectEntity.Services;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends MongoRepository<Services,Integer> {
    Services findByServiceId(Integer id);
}
