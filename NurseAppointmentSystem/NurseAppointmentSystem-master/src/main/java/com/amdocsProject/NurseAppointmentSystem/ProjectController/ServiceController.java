package com.amdocsProject.NurseAppointmentSystem.ProjectController;

import com.amdocsProject.NurseAppointmentSystem.ProjectEntity.Services;
import com.amdocsProject.NurseAppointmentSystem.ProjectService.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import  java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping("/getServices")
    public ResponseEntity<List<?>> getAllService(){
        return serviceService.getAllService();
    }

    @GetMapping("/getService/{serviceId}")
    public ResponseEntity<?> getServiceById(@PathVariable int serviceId){
        return serviceService.findById(serviceId);
    }
    @PostMapping("/addService")
    public ResponseEntity<?> addService(@RequestBody Services service){
        return serviceService.addService(service);
    }

    @DeleteMapping("/deleteService/{serviceId}")
    public ResponseEntity<?> deleteServiceById(@PathVariable int serviceId){
        return serviceService.deleteServiceById(serviceId);
    }

    @PutMapping("/updateService")
    public ResponseEntity<?> updateNurse(@RequestBody Services services){
        return serviceService.updateServiceDetails(services);
    }
}
