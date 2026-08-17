package com.codealpa.redundancy.service;

import com.codealpa.redundancy.entity.DataEntry;
import com.codealpa.redundancy.repository.DataEntryRepository;
import org.springframework.stereotype.Service;

@Service
public class DataEntryService {

    private final DataEntryRepository repository;

    public DataEntryService(DataEntryRepository repository) {
        this.repository = repository;
    }

    public DataEntry addData(String data) {

        if (data == null || data.trim().isEmpty()) {

            return new DataEntry(
                    data,
                    "FALSE_POSITIVE"
            );
        }

        if (repository.existsByData(data.trim())) {

            return new DataEntry(
                    data,
                    "REDUNDANT"
            );
        }

        DataEntry newEntry = new DataEntry(
                data.trim(),
                "UNIQUE"
        );

        return repository.save(newEntry);
    }
}