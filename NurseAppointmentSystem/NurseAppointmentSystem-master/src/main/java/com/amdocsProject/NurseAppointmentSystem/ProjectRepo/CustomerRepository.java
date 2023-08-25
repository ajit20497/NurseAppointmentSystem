package com.amdocsProject.NurseAppointmentSystem.ProjectRepo;

import com.amdocsProject.NurseAppointmentSystem.ProjectEntity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer,Integer> {
}
