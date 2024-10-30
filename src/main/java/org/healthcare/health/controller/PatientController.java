package org.healthcare.health.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



@RestController
@RequestMapping("/patients")

public class PatientController {

    @RequestMapping(value="/index.html", method=RequestMethod.GET)
    @ResponseBody
    public String requestMethodName() {
        return "testinggggg ";
    }
    

}


