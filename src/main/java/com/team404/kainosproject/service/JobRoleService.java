package com.team404.kainosproject.service;

import com.team404.kainosproject.model.JobRole;
import com.team404.kainosproject.repository.JobRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobRoleService {

    private final JobRoleRepository repository;

    @Autowired
    public JobRoleService(JobRoleRepository repository) {
        this.repository = repository;
    }

    public Iterable<JobRole> getAll(){
        return repository.findAll();
    }


}
