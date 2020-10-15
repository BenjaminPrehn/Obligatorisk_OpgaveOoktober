package com.example.bp.Entities;

import javax.naming.Name;
import javax.persistence.*;
import java.util.List;

@Entity
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long organisationId;
    private String name;

    @OneToMany(mappedBy = "organisation")
    private List<Employee> employees;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Organisation(String name) {
        this.name = name;
    }

    public Organisation() {
    }

    public long getOrganisationId() {
        return organisationId;
    }

    public void setOrganisationId(long organisationId) {
        this.organisationId = organisationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
