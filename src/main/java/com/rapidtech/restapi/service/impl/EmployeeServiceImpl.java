package com.rapidtech.restapi.service.impl;

import com.rapidtech.restapi.entity.EmployeeEntity;
import com.rapidtech.restapi.model.EmployeeModel;
import com.rapidtech.restapi.repository.EmployeeRepo;
import com.rapidtech.restapi.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepo repo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo repo) {
        this.repo = repo;
    }

    @Override
    public List<EmployeeModel> getAll() {
        return this.repo.findAll().stream().map(EmployeeModel::new)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EmployeeModel> getById(Long id) {
        if(id == 0) {
            return Optional.empty();
        }
        Optional<EmployeeEntity> result = this.repo.findById(id);
        return result.map(EmployeeModel::new);
    }

    @Override
    public Optional<EmployeeModel> save(EmployeeModel model) {
        if(model == null) {
            return Optional.empty();
        }
        EmployeeEntity entity = new EmployeeEntity(model);
        try {
            this.repo.save(entity);
            return Optional.of(new EmployeeModel(entity));
        }catch (Exception e){
            log.error("Customer save is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<EmployeeModel> update(Long id, EmployeeModel model) {
        if(id == 0) {
            return Optional.empty();
        }

        EmployeeEntity result = this.repo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }

        // copy property
        BeanUtils.copyProperties(model, result);
        try {
            this.repo.save(result);
            return Optional.of(new EmployeeModel(result));
        }catch (Exception e){
            log.error("Customer update is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public Optional<EmployeeModel> delete(Long id) {
        if(id == 0) {
            return Optional.empty();
        }

        EmployeeEntity result = this.repo.findById(id).orElse(null);
        if(result == null){
            return Optional.empty();
        }

        try {
            this.repo.delete(result);
            return Optional.of(new EmployeeModel(result));
        }catch (Exception e){
            log.error("Customer delete is failed, error: {}", e.getMessage());
            return Optional.empty();
        }
    }
}
