package com.example.bp.Controllers;

import com.example.bp.Dao.EmployeeRepository;
import com.example.bp.Entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/")
    public String displayEmployees(Model model){
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("employee", employees);
        return"employee";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model){
        Employee anEmployee = new Employee();
        model.addAttribute("employee",anEmployee);
        return"employee-new";
    }

    @PostMapping("/save")
    public String createEmployee(Employee employee, Model model){
        empRepo.save(employee);

        return"redirect:/employee/";
    }

}
