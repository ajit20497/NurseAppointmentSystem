package com.amdocsProject.NurseAppointmentSystem.ProjectRepo;

import com.amdocsProject.NurseAppointmentSystem.ProjectEntity.Nurse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository extends MongoRepository<Nurse, Integer> {
    Nurse findByNurseId(Integer nurseId);
//    Nurse findByAvailable(Integer available);

}
