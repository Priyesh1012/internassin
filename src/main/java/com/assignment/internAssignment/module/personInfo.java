package com.assignment.internAssignment.module;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="personInfo")
public class personInfo {
    @Id
    private String employId;
    private String name;
    private String country;
    private String age;
}
