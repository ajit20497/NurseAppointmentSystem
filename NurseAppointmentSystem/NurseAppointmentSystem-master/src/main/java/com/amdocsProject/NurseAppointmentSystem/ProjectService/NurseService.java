package com.amdocsProject.NurseAppointmentSystem.ProjectService;


import com.amdocsProject.NurseAppointmentSystem.ProjectEntity.Nurse;
import com.amdocsProject.NurseAppointmentSystem.ProjectRepo.NurseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import  java.util.List;
import java.util.Optional;

@Service
public class NurseService {

    @Autowired
    private NurseRepository nurseRepository;

    public  ResponseEntity<List<Nurse>> getAllNurse(){
        return new ResponseEntity<List<Nurse>>(nurseRepository.findAll(),HttpStatus.OK);
    }
    public ResponseEntity<String> addNurse(Nurse nurse){
        try {
            nurseRepository.save(nurse);
            return new ResponseEntity<String>("Regestration Sucessful",HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>("Unsucessful",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> deleteNurseById(int nurseId){
        Optional<Nurse> nurse=nurseRepository.findById(nurseId);
        if(nurse.isEmpty()){
            return new ResponseEntity<String>("Nurse Does not Exists",HttpStatus.OK);
        }else{
            nurseRepository.deleteById(nurseId);
            return new ResponseEntity<String>("Nurse Details are Deleted Sucessfully",HttpStatus.OK);
        }
    }
    public ResponseEntity<String> getNurseById(int nurseId){
       Optional<Nurse> nurse=nurseRepository.findById(nurseId);
       if(nurse.isEmpty()){
           return (new ResponseEntity<String>("Nurse Not found", HttpStatus.OK));
       }else{
           return (new ResponseEntity<String>(nurse.toString(),HttpStatus.OK));
       }
    }

    public  ResponseEntity<String> updateNurseDetails(Nurse nurse){
        Optional<Nurse> nurse1=nurseRepository.findById(nurse.getNurseId());
        if(nurse1.isEmpty()){
            return new ResponseEntity<String>("Nurse Not Found",HttpStatus.OK);
        }else{
            nurseRepository.save(nurse);
            return new ResponseEntity<String>("Nurse Details updated Successfully",HttpStatus.OK);
        }
    }
}
