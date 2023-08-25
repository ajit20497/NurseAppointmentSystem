package com.amdocsProject.NurseAppointmentSystem.ProjectController;


import com.amdocsProject.NurseAppointmentSystem.ProjectEntity.Nurse;
import com.amdocsProject.NurseAppointmentSystem.ProjectService.NurseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nurse")
public class NurseController {
    @Autowired
    private NurseService nurseService;


    @GetMapping("/getNurses")
    public  ResponseEntity<List<Nurse>> getAllNurse(){
        return nurseService.getAllNurse();
    }

    @GetMapping("/getNurse/{nurseId}")
    public ResponseEntity<?> getNurseById(@PathVariable int nurseId){
//        Nurse existingNurse= nurseService.getNurseById();
        return nurseService.getNurseById(nurseId);
    }

    @DeleteMapping("/deleteNurse/{nurseId}")
    public ResponseEntity<String> deleteNurseById(@PathVariable int nurseId){
        return nurseService.deleteNurseById(nurseId);
    }

    @PostMapping("/addNurse")
    public ResponseEntity<String> addNurse(@RequestBody Nurse nurse){
        return nurseService.addNurse(nurse);
    }

    @PutMapping("/updateNurse")
    public ResponseEntity<String> updateNurse(@RequestBody Nurse nurse){
        return nurseService.updateNurseDetails(nurse);
    }


}
