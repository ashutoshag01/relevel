package com.relevel.backend.olx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.relevel.backend.olx.repository.*;
import org.springframework.http.*;
import java.util.regex.Matcher;
import java.util.regex.*;

import com.relevel.backend.olx.model.*;

@RestController
public class OlxItemController {
    
    private final UserRepository repository;
    String name_expression = "^[a-zA-Z\\s]+"; 

    OlxItemController(UserRepository repository) {
        this.repository = repository;
      }

    @GetMapping("/") 
    public String all() {
        return "Success";
    }  
    
	@GetMapping("/ping")
	public String ping() {
		return "Ping is Successful";
	}

    @PostMapping("/user")
    ResponseEntity<User> newEmployee(@RequestBody User newUser) {
        if(!newUser.getName().matches(this.name_expression) || newUser.getName().length() > 20) {
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }

        Pattern VALID_EMAIL_ADDRESS_REGEX = 
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(newUser.getEmailID());
        if(!matcher.find()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(newUser.getAge() < 10 || newUser.getAge() > 99) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if(newUser.getGender() != "male" && newUser.getGender() != "female") {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Pattern PHONE_NUMBER_REGEX = Pattern.compile("\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}");
        matcher = PHONE_NUMBER_REGEX.matcher(newUser.getPhoneNumber());
        if(!matcher.find()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
      return  ResponseEntity.ok(repository.save(newUser) );
    }
}

