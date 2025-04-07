package com.example.demo.Repository;

import com.example.demo.Entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    //tìm kiếm nhân viên theo tên (JPQL)
    //SQL: SELECT * FROM employee WHERE name LIKE '%John%';
    @Query("SELECT e FROM Employee e WHERE e.name LIKE %?1%")
    List<Employee> findByNameContaining (String name);

    //lọc nhân viên theo lương (Native Query)
    //SQL: SELECT * FROM employee WHERE salary BETWEEN min AND max;
    @Query(value = "SELECT * FROM employee WHERE salary BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Employee> findBySalaryBetween (double min, double max);

    // phân danh sách theo nhân viên
    Page<Employee> findAll (Pageable pageable);

}
