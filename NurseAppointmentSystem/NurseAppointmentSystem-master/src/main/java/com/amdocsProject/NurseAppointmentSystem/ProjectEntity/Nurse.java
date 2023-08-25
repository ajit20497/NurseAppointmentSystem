package com.amdocsProject.NurseAppointmentSystem.ProjectEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "nurse")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Nurse {
    @Id
    private  int nurseId;
    private String name;
    private  String address;
    private  String contactNo;
    private int available;
    public int getNurseId(){
        return this.nurseId;
    }
    public void setAvailableToOne(){
        this.available=1;
    }
    public void setAvaliableToZero(){
        this.available=0;
    }
    public int getAvailable(){
        return this.available;
    }

    public void setAvailable(int i) {
        this.available=1;
    }
}
