package com.example.workshop.repo;

import com.example.workshop.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

public interface OperationRepo extends JpaRepository<Operation, Long> {
    @Transactional
    void deleteOperationById(Long id);
    Optional<Operation> findOperationById(Long id);
}
