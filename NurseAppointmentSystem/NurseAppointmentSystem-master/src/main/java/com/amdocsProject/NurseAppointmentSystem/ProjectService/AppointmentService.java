package com.amdocsProject.NurseAppointmentSystem.ProjectService;

import com.amdocsProject.NurseAppointmentSystem.ProjectEntity.Appointment;
import com.amdocsProject.NurseAppointmentSystem.ProjectEntity.Nurse;
import com.amdocsProject.NurseAppointmentSystem.ProjectEntity.Services;
import com.amdocsProject.NurseAppointmentSystem.ProjectRepo.AppointmentRepository;
import com.amdocsProject.NurseAppointmentSystem.ProjectRepo.NurseRepository;
import com.amdocsProject.NurseAppointmentSystem.ProjectRepo.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import  java.util.List;

import java.util.Optional;

@Service
public class AppointmentService {

    private static int appointmentId=0;
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Autowired
    private NurseRepository nurseRepository;
    public ResponseEntity<?> addAppointment(Appointment appointment){
//        1. generate automatic appointmentId
        appointmentId++;
        appointment.setAppointmentId(appointmentId);

//        2. find Service is valid or not
        Optional<Services> services=serviceRepository.findById(appointment.getServiceId());
        if(services.isEmpty()){
            return new ResponseEntity<String>("Invalid Service",HttpStatus.OK);
        }
//          3. Nurse is Available or Not
        List<Nurse> nurseList=nurseRepository.findAll();
        Nurse nurse=null;
        for(Nurse x:nurseList){
            if(x.getAvailable()==0){
                x.setAvailable(1);
                nurseRepository.save(x);
                nurse=x;
                break;
            }
        }
        if(nurse==null) return new ResponseEntity<String>("Nurse is Not available",HttpStatus.OK);
//        4. Book New Appointment
        appointment.setNurseId(nurse.getNurseId());
        return new ResponseEntity<Appointment>(appointmentRepository.save(appointment), HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateAppointmentService(Appointment appointment){
        Optional<Appointment> appointment1=appointmentRepository.findById(appointment.getAppointmentId());
        if (appointment1.isEmpty()) {
            return new ResponseEntity<String>("Appointment Id is wrong",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Appointment>(appointmentRepository.save(appointment),HttpStatus.OK);
    }
    public ResponseEntity<?> deleteAppointment(int appointmentId){
        Appointment appointment = appointmentRepository.findByAppointmentId(appointmentId);
        if(appointment==null){
            return new ResponseEntity<String>("Appointment is not found",HttpStatus.OK);
        }
        int id=appointment.getNurseId();
//        Nurse nurse=null;
        Nurse nurse=nurseRepository.findByNurseId(id);
        nurse.setAvailable(0);
        nurseRepository.save(nurse);
        appointmentRepository.deleteById(appointmentId);
        return new ResponseEntity<String>("Appointment delete Sucessfully",HttpStatus.OK);
    }
}
