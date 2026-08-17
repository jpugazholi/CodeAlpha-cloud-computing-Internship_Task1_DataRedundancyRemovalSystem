package com.codealpa.redundancy.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "data_entries")
public class DataEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String data;

    @Column(nullable = false)
    private String status;

    public DataEntry() {
    }

    public DataEntry(String data, String status) {
        this.data = data;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}