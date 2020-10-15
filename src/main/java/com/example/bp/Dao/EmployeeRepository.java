package com.example.bp.Dao;

import com.example.bp.Dto.EmployeeProject;
import com.example.bp.Entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Override
    public List<Employee> findAll();

    @Query(nativeQuery = true, value="SELECT e.firstname, e.lastname, COUNT(pe.employee_id) as projectCount " +
            "FROM employee e left join project_employee pe ON pe.employee_id = e.employee_id " +
            "GROUP BY e.firstname, e.lastname ORDER BY 3 DESC")
    public List<EmployeeProject> employeeProjects();

}
