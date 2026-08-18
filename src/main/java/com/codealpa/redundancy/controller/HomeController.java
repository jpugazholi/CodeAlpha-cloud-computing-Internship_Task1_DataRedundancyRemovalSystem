package com.codealpa.redundancy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

@GetMapping("/")
public String home() {
    return "Data Redundancy Removal System is Running";
}

}
