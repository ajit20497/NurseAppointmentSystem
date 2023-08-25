package com.amdocsProject.NurseAppointmentSystem.ProjectService;

import com.amdocsProject.NurseAppointmentSystem.ProjectEntity.Services;
import com.amdocsProject.NurseAppointmentSystem.ProjectRepo.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import  java.util.List;
import java.util.Optional;

@Service
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepository;
    public ResponseEntity<List<?>> getAllService(){
        return new ResponseEntity<List<?>>(serviceRepository.findAll(),HttpStatus.OK);
    }
    public ResponseEntity<?> addService(Services service){
        Optional<Services> service1=serviceRepository.findById(service.getServiceId());
        if(service1.isEmpty()){
            serviceRepository.save(service);
            return new ResponseEntity<String>("Service Added Sucessfully"+service.toString(),HttpStatus.OK);
        }else{
            return new ResponseEntity<String>("Service is already registered",HttpStatus.OK);
        }
    }

    public ResponseEntity<?> findById(int serviceId){
        Optional<Services> services=serviceRepository.findById(serviceId);
        if(services.isEmpty()){
            return new ResponseEntity<String>("Service Not Found",HttpStatus.OK);
        }else{
            return new ResponseEntity<>(services,HttpStatus.FOUND);
        }
    }
    public ResponseEntity<?> deleteServiceById(int serviceId){
        Optional<Services>services=serviceRepository.findById(serviceId);
        if(services.isEmpty()){
            return new ResponseEntity<String>("Service Not Found ",HttpStatus.NOT_FOUND);
        }else{
            serviceRepository.deleteById(serviceId);
            return new ResponseEntity<String>("Service Deleted Sucessfully",HttpStatus.OK);
        }
    }
    public ResponseEntity<?> updateServiceDetails(Services services){
        Optional<Services> temp=serviceRepository.findById(services.getServiceId());
        if(temp.isEmpty()){
            return new ResponseEntity<String>("Service Id is Invalid",HttpStatus.OK);
        }else{
            serviceRepository.save(services);
            return new ResponseEntity<String>("Service Updated Successfully",HttpStatus.OK);
        }
    }
}
