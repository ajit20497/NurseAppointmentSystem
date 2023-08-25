package com.amdocsProject.NurseAppointmentSystem.ProjectController;

import com.amdocsProject.NurseAppointmentSystem.ProjectEntity.Customer;
import com.amdocsProject.NurseAppointmentSystem.ProjectService.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import  java.util.List;
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/getCustomer")
    public ResponseEntity<List<Customer>> getCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping("/getCustomer/{userId}")
    public ResponseEntity<?> getCustomerById(@PathVariable int userId){
        return customerService.getCustomerById(userId);
    }

    @DeleteMapping("/deleteCustomer/{userId}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable int userId){
        return customerService.deleteById(userId);
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }

}
