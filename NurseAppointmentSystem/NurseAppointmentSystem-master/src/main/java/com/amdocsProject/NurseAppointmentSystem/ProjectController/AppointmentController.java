package com.amdocsProject.NurseAppointmentSystem.ProjectController;

import com.amdocsProject.NurseAppointmentSystem.ProjectEntity.Appointment;
import com.amdocsProject.NurseAppointmentSystem.ProjectRepo.AppointmentRepository;
import com.amdocsProject.NurseAppointmentSystem.ProjectService.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @PostMapping("/addAppointment")
    public ResponseEntity<?> addAppointment(@RequestBody Appointment appointment){
        return appointmentService.addAppointment(appointment);
//        return new ResponseEntity<Appointment>(appointmentRepository.save(appointment), HttpStatusCode.valueOf(200));
    }
    @GetMapping("/getAppointment")
    public ResponseEntity<List<?>> getAppointment(){
        return new ResponseEntity<List<?>>(appointmentRepository.findAll(),HttpStatusCode.valueOf(200));
    }

    @PutMapping("/updateAppointment")
    public ResponseEntity<?>updateAppointment(@RequestBody Appointment appointment){
        return appointmentService.updateAppointmentService(appointment);
    }

    @DeleteMapping("/deleteAppointment/{appointmentId}")
    public ResponseEntity<?> deleteAppointment(@PathVariable int appointmentId){
        return appointmentService.deleteAppointment(appointmentId);
    }


}
