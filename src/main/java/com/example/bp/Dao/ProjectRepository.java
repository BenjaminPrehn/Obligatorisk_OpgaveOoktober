package com.example.bp.Dao;

import com.example.bp.Entities.Projects;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepository extends CrudRepository<Projects, Long> {

    @Override
    public List<Projects> findAll();

}
