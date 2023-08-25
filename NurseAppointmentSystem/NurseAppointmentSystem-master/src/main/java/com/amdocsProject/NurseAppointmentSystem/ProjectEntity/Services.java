package com.amdocsProject.NurseAppointmentSystem.ProjectEntity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "service")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Services {
    @Id
    private  int serviceId;
    private int  description ;
    private double charges;
    private String serviceName;

    public Integer getServiceId() {
        return this.serviceId;
    }
    public void setCharges(double val){
        this.charges=val;
    }
    public double getCharges(){
        return this.charges;
    }
}
