package com.codealpa.redundancy.repository;

import com.codealpa.redundancy.entity.DataEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataEntryRepository extends JpaRepository<DataEntry, Long> {

    boolean existsByData(String data);

}