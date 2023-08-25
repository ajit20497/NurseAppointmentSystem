package com.amdocsProject.NurseAppointmentSystem.ProjectRepo;

import com.amdocsProject.NurseAppointmentSystem.ProjectEntity.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends MongoRepository<Appointment,Integer> {

    Appointment findByAppointmentId(Integer id);
}
