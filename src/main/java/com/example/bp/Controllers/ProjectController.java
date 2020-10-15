package com.example.bp.Controllers;

import com.example.bp.Dao.EmployeeRepository;
import com.example.bp.Dao.ProjectRepository;
import com.example.bp.Entities.Employee;
import com.example.bp.Entities.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository proRepo;

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/")
    public String displayProjects(Model model){
        List<Projects> projects = proRepo.findAll();
        model.addAttribute("projects", projects);
        return "projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model){

        Projects aProject = new Projects();
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("projects" , aProject);
        model.addAttribute("allEmployees" , employees);

        return "projects-new";
    }

    @PostMapping("/save")
    public String createProject(Projects project, Model model){
        // this should handle saving to the database
        proRepo.save(project);

        // Use a redirect to prevent duplicate submissions
        return"redirect:/projects/";
    }

}
