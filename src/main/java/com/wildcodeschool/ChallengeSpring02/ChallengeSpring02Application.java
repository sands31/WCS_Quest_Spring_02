package com.wildcodeschool.ChallengeSpring02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SpringBootApplication
public class ChallengeSpring02Application {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeSpring02Application.class, args);
	}	
	
	@RequestMapping("/doctor/{num}")
	@ResponseBody
	public Doctor doctor(@PathVariable String num, @RequestParam(required = false) String name) {
		Doctor d1 = new Doctor("Christopher Eccleston", 9);
		Doctor d2 = new Doctor("David Tennant", 10);
		Doctor d3 = new Doctor("Matt Smith", 11);
		Doctor d4 = new Doctor("Peter Capaldi", 12);
		Doctor d5 = new Doctor("Jodie Whittaker", 13);
		
		Doctor[] doctorList = {d1, d2, d3, d4, d5};
		
		int id = Integer.parseInt(num);
		if (id >= 9 && id <=13) {
			return doctorList[id - 9];
		} else if (id >= 1 && id <=8 ) {
			throw new ResponseStatusException(HttpStatus.SEE_OTHER);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, ("Impossible de récupérer l'incarnation " + id));
		}	
		
	}

}
