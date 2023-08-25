package com.amdocsProject.NurseAppointmentSystem.ProjectService;

import com.amdocsProject.NurseAppointmentSystem.ProjectEntity.Customer;
import com.amdocsProject.NurseAppointmentSystem.ProjectRepo.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<List<Customer>>(customerRepository.findAll(), HttpStatus.OK);
    }
    public ResponseEntity<?> getCustomerById(int userId){
        Optional<Customer> customer=customerRepository.findById(userId);
        if(customer.isEmpty()){
            return new ResponseEntity<String>("Customer Not Found",HttpStatus.OK);
        }else{
            return new ResponseEntity<>(customer,HttpStatus.OK);
        }
    }
    public ResponseEntity<?> deleteById(int userId){
        Optional<Customer> customer=customerRepository.findById(userId);
        if(customer.isEmpty()){
            return  new ResponseEntity<>("User Not Found",HttpStatus.OK);
        }else{
            customerRepository.deleteById(userId);
            return new ResponseEntity<>("User deleted Sucessfully",HttpStatus.OK);
        }
    }

    public ResponseEntity<Customer> addCustomer(Customer customer){
        Customer customer1=customerRepository.save(customer);
        return new ResponseEntity<Customer>(customer1,HttpStatus.CREATED);
    }

    public ResponseEntity<?> updateCustomer(Customer customer){
        Optional<Customer> customer1=customerRepository.findById(customer.getUserId());
        if(customer1.isEmpty()){
            return new ResponseEntity<>("Customer Not Found",HttpStatus.NOT_FOUND);
        }else{
            customerRepository.save(customer);
            return new ResponseEntity<>(customer1,HttpStatus.OK);
        }
    }


}
