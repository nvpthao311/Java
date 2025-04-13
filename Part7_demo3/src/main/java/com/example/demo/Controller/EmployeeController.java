package com.example.demo.Controller;

import com.example.demo.Entity.Employee;
import com.example.demo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping
    public Employee createEmployee (@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById (@PathVariable Long id){
        return employeeService.findById(id);
    }

    @GetMapping
    public List<Employee> getAllEmployees (){
        return employeeService.findAll();
    }

    @PutMapping("/{id}")
    public Employee updateEmployeeByID(@PathVariable Long id,@RequestBody Employee employee){
        return employeeService.updateById(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteById (@PathVariable Long id){
        employeeService.deleteById(id);
    }

    @GetMapping("/search")
    public List<Employee> searchByName (@RequestParam String name){
        return employeeService.searchByName(name);
    }

    @GetMapping("/salary")
    public List<Employee> filterBySalary (@RequestParam double min, @RequestParam double max){
        return employeeService.filterBySalary(min, max);
    }

    @GetMapping("/page")
    public Page<Employee> getEmployeeWithPagination(@RequestParam int page, @RequestParam int size,
                                                    @RequestParam String sortBy, @RequestParam String direction) {
        return employeeService.getEmployeeWithPagination(page, size, sortBy, direction);
    }


}
