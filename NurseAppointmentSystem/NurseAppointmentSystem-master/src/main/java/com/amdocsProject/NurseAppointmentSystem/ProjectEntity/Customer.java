package com.amdocsProject.NurseAppointmentSystem.ProjectEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private  int userId;
    private  String name;
    private String address;
    private  String contactNo;
    public int getUserId(){
        return this.userId;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }

}
