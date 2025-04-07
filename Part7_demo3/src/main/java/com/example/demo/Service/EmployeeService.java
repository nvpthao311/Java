package com.example.demo.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //create
    public Employee save (Employee employee){
        return employeeRepository.save(employee);
    }

    //read
    public List<Employee> findAll (){
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById (Long id){
        return employeeRepository.findById(id);
    }

    //update
    public Employee updateById (Long id, Employee emp){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if(optionalEmployee.isPresent()){
            Employee employee = optionalEmployee.get();
            employee.setName(emp.getName());
            employee.setPhone(emp.getPhone());
            employee.setSalary(emp.getSalary());

            return employeeRepository.save(employee);
        }
        return null;
    }

    //delete
    public void deleteById(Long id){
        employeeRepository.deleteById(id);
    }

    //search by name
    public List<Employee> searchByName (String name){
        return employeeRepository.findByNameContaining(name);
    }

    //filter by salary
    public List<Employee> filterBySalary (double min, double max){
        return employeeRepository.findBySalaryBetween(min, max);
    }

    //
    public Page<Employee> getEmployeeWithPagination (int page, int size, String sortBy, String direction){
        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeRepository.findAll(pageable);
    }





}
