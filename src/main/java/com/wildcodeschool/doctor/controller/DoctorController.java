package com.wildcodeschool.doctor.controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import com.wildcodeschool.doctor.model.Doctor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;

@Controller
public class DoctorController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/doctor/{number}")
    @ResponseBody
    public Doctor getDoctor(@PathVariable ("number") int number) {
        if (number == 13) {
            return new Doctor(13, "Jodie Whittaker");
        } else if (number >= 1 && number <= 12) {
            throw new ResponseStatusException(HttpStatus.SEE_OTHER);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation " + number);
    }
}
}
