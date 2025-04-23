package de.ait.javalessons.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "files")
public class FileEmptity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
