package com.example.workshop.service;

import com.example.workshop.exception.OperationNotFoundException;
import com.example.workshop.model.Operation;
import com.example.workshop.repo.OperationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {
    private final OperationRepo operationRepo;

    @Autowired
    public OperationService(OperationRepo operationRepo) {
        this.operationRepo = operationRepo;
    }

    public Operation addOperation(Operation operation){
        return operationRepo.save(operation);
    }

    public List<Operation> findAllOperations() {
        return operationRepo.findAll();
    }

    public Operation findOperationById(Long id) {
        return operationRepo.findOperationById(id)
                .orElseThrow(() -> new OperationNotFoundException("Operation by id " + id + " was not found."));
    }

    public Operation updateOperation(Operation operation) {
        return operationRepo.save(operation);
    }

    public void deleteOperation(Long id) {
        operationRepo.deleteOperationById(id);
    }
}
