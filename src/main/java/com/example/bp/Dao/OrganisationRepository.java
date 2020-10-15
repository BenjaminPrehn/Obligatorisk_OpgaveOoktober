package com.example.bp.Dao;

import com.example.bp.Entities.Employee;
import com.example.bp.Entities.Organisation;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrganisationRepository extends CrudRepository<Organisation, Long> {

    @Override
    public List<Organisation> findAll();

}
