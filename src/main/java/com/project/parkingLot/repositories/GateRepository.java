package com.project.parkingLot.repositories;

import com.project.parkingLot.models.Gate;
import com.project.parkingLot.models.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GateRepository extends JpaRepository<Gate, Long> {
    @Query("SELECT g.operator FROM Gate g where g.number=:gateNumber")
    Operator findOperatorIdByGateNumber(int gateNumber);


    @Query("SELECT g.id FROM Gate g where g.number=:gateNumber")
    long findByGateNumber(int gateNumber);
}
