package com.example.bp.Controllers;

import com.example.bp.Dao.EmployeeRepository;
import com.example.bp.Dao.OrganisationRepository;
import com.example.bp.Dao.ProjectRepository;
import com.example.bp.Entities.Employee;
import com.example.bp.Entities.Organisation;
import com.example.bp.Entities.Projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/organisation")
public class OrganisationController {

    @Autowired
    OrganisationRepository orgRepo;

    @Autowired
    EmployeeRepository empRepo;

    @GetMapping("/")
    public String displayOrganisations(Model model){
        List<Organisation> organisations = orgRepo.findAll();
        model.addAttribute("organisations", organisations);
        return "organisation";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model){

        Organisation allOrganisations = new Organisation();
        List<Employee> employees = empRepo.findAll();
        model.addAttribute("allOrganisations" , allOrganisations);
        model.addAttribute("allEmployees" , employees);

        return "organisation-new";
    }

    @PostMapping("/save")
    public String createOrganisation(Organisation organisation, Model model){

        orgRepo.save(organisation);

        return"redirect:/organisation/";
    }
}
