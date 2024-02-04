package com.project.parkingLot.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Operator extends BaseModel{
    private String name;
    private String phoneNo;
    private String emailId;
}
