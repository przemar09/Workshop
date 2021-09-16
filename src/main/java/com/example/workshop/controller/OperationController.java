package com.example.workshop.controller;

import com.example.workshop.model.Operation;
import com.example.workshop.service.OperationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/operation")
public class OperationController {
    private final OperationService operationService;

    public OperationController(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Operation>> getAllOperations() {
        List<Operation> operations = operationService.findAllOperations();
        return new ResponseEntity<>(operations, HttpStatus.OK);
    }

    @GetMapping("find/{id}")
    public ResponseEntity<Operation> getOperationById(@PathVariable("id") Long id) {
        Operation operation = operationService.findOperationById(id);
        return new ResponseEntity<>(operation, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Operation> addOperation(@RequestBody Operation operation) {
        Operation newOperation = operationService.addOperation(operation);
        return new ResponseEntity<>(newOperation, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Operation> updateOperation(@RequestBody Operation operation) {
        Operation updateOperation = operationService.updateOperation(operation);
        return new ResponseEntity<>(updateOperation, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOperation(@PathVariable("id") Long id) {
        operationService.deleteOperation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
