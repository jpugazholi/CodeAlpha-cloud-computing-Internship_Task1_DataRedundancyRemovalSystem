package com.codealpa.redundancy.controller;

import com.codealpa.redundancy.entity.DataEntry;
import com.codealpa.redundancy.service.DataEntryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/data")
@CrossOrigin
public class DataEntryController {

    private final DataEntryService service;

    public DataEntryController(DataEntryService service) {
        this.service = service;
    }

    @PostMapping
    public DataEntry addData(@RequestParam String data) {
        return service.addData(data);
    }
}