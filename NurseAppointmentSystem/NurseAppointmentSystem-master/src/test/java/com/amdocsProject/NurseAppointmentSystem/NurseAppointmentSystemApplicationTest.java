package com.amdocsProject.NurseAppointmentSystem;

import com.amdocsProject.NurseAppointmentSystem.ProjectEntity.Appointment;
import com.amdocsProject.NurseAppointmentSystem.ProjectEntity.Customer;
import com.amdocsProject.NurseAppointmentSystem.ProjectEntity.Nurse;
import com.amdocsProject.NurseAppointmentSystem.ProjectEntity.Services;
import com.amdocsProject.NurseAppointmentSystem.ProjectRepo.AppointmentRepository;
import com.amdocsProject.NurseAppointmentSystem.ProjectRepo.CustomerRepository;
import com.amdocsProject.NurseAppointmentSystem.ProjectRepo.NurseRepository;
import com.amdocsProject.NurseAppointmentSystem.ProjectRepo.ServiceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import  java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class NurseAppointmentSystemApplicationTests {

    @Autowired
    private NurseRepository nurseRepository;
    @Test
    public void insertNurseTest(){
        nurseRepository.deleteAll();
        Nurse nurse = Mockito.mock(Nurse.class);
        nurseRepository.save(nurse);
        assertNotNull(nurseRepository.findByNurseId(nurse.getNurseId()));
    }
    @Test
    public void getNurses(){
        List<Nurse> nurseList=nurseRepository.findAll();
        assertTrue(nurseList.size()>0);
    }
    @Test
    public  void deleteNurse(){
        nurseRepository.deleteAll();
        Nurse nurse=Mockito.mock(Nurse.class);
        nurseRepository.save(nurse);
        nurseRepository.deleteById(nurse.getNurseId());
        assertNull(nurseRepository.findByNurseId(nurse.getNurseId()));
    }
    @Test
    public  void updateNurse(){
        nurseRepository.deleteAll();
        Nurse nurse= Mockito.mock(Nurse.class);
        nurseRepository.save(nurse);
        nurse.setAvailableToOne();
        nurseRepository.deleteById(nurse.getNurseId());
        nurseRepository.save(nurse);
        assertEquals(nurseRepository.findByNurseId(nurse.getNurseId()).getAvailable(),nurse.getAvailable());
    }
    @Test
    public void findNurse(){
        Nurse nurse= Mockito.mock(Nurse.class);
        nurseRepository.deleteAll();
        nurseRepository.save(nurse);
        assertEquals(nurseRepository.findByNurseId(nurse.getNurseId()).getNurseId(),nurse.getNurseId());
    }

    // Service Tests
    @Autowired
    private ServiceRepository serviceRepository;
    @Test
    public void insertService(){
        serviceRepository.deleteAll();
        Services service = Mockito.mock(Services.class);

        serviceRepository.save(service);

        assertNotNull(serviceRepository.findById(service.getServiceId()));
    }
    @Test
    public void getServices(){
        List<Services> list=serviceRepository.findAll();
        assertTrue(list.size()>0);
    }
    @Test
    public  void deleteService(){
        serviceRepository.deleteAll();
        Services services=Mockito.mock(Services.class);
        serviceRepository.save(services);
        serviceRepository.deleteById(services.getServiceId());
        assertNull(serviceRepository.findByServiceId(services.getServiceId()));
    }
    @Test
    public  void updateService(){

        serviceRepository.deleteAll();
        Services services=Mockito.mock(Services.class);
        serviceRepository.save(services);
        services.setCharges(32.23);
        serviceRepository.deleteById(services.getServiceId());
        serviceRepository.save(services);
        assertEquals(serviceRepository.findByServiceId(services.getServiceId()).getCharges(),services.getCharges());
    }
    @Test
    public void findService(){
        Services services=Mockito.mock(Services.class);
        serviceRepository.deleteAll();
        serviceRepository.save(services);
        assertNotNull(serviceRepository.findById(services.getServiceId()));
    }


//  Customer
    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void insertCustomer(){
        customerRepository.deleteAll();
        Customer customer=Mockito.mock(Customer.class);
        customerRepository.save(customer);
        assertNotNull(customerRepository.findById(customer.getUserId()));
    }
    @Test
    public void getCustomer(){
        List<Customer>list=customerRepository.findAll();
        assertTrue(list.size()>0);
    }

    @Test
    public  void deleteCustomer(){
        customerRepository.deleteAll();
        Customer customer=Mockito.mock(Customer.class);
        customerRepository.save(customer);
        customerRepository.deleteById(customer.getUserId());
        Optional<Customer> customer1=customerRepository.findById(customer.getUserId());
        assertTrue(customer1.isEmpty());

    }
    @Test
    public  void updateCustomer(){
        customerRepository.deleteAll();
        Customer customer= Mockito.mock(Customer.class);
        customerRepository.save(customer);
        customer.setName("abcd");
        customerRepository.deleteById(customer.getUserId());
        customerRepository.save(customer);
        assertNotNull(customerRepository.findById(customer.getUserId()));
    }
    @Test
    public void findCustomer(){
        Customer customer=Mockito.mock(Customer.class);
        customerRepository.deleteAll();
        customerRepository.save(customer);
        assertNotNull(serviceRepository.findById(customer.getUserId()));
    }


    //appointment
    @Autowired
    private AppointmentRepository ap;

    @Test
    public void insertAppointment(){
        ap.deleteAll();
        Appointment appointment=Mockito.mock(Appointment.class);
       ap.save(appointment);
        assertNotNull(ap.findById(appointment.getAppointmentId()));
    }

    @Test
    public void getAppointment(){
        List<Appointment>list=ap.findAll();
        assertTrue(list.size()>0);
    }

    @Test
    public  void deleteAppointment(){
        ap.deleteAll();
        Appointment appointment =Mockito.mock(Appointment.class);
        ap.save(appointment);
        ap.deleteById(appointment.getAppointmentId());
        Optional<Appointment> appointment1=ap.findById(appointment.getAppointmentId());
        assertTrue(appointment1.isEmpty());
    }

    @Test
    public  void updateAppointment(){
        ap.deleteAll();
        Appointment appointment=Mockito.mock(Appointment.class);
        ap.save(appointment);
        appointment.setServiceId(22);
        ap.deleteById(appointment.getAppointmentId());
        ap.save(appointment);
        assertNotNull(ap.findByAppointmentId(appointment.getAppointmentId()));
    }

    @Test
    public void findAppointment(){
        Appointment appointment=Mockito.mock(Appointment.class);
        ap.deleteAll();
        ap.save(appointment);
        assertNotNull(ap.findByAppointmentId(appointment.getAppointmentId()));
    }


}