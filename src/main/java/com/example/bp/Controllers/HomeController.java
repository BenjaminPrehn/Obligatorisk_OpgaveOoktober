package com.example.bp.Controllers;

import com.example.bp.Dao.EmployeeRepository;
import com.example.bp.Dao.ProjectRepository;
import com.example.bp.Dto.EmployeeProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository proRepo;
    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/")
    public String displayHome(Model model)  {

        List<EmployeeProject> employeesProjectCnt = empRepo.employeeProjects();
        model.addAttribute("employeesListProjectCnt", employeesProjectCnt);

        return"index";
    }

}
