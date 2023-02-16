package com.ltp.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class GradesController {

    List <Grade> studentGrades = Arrays.asList(
            new Grade("Greg", "Java", "A"),
            new Grade("John", "Java", "C"),
            new Grade("Bill", "Java", "B")
    );

    @GetMapping("/")
    public String gradeForm(Model model) {
        model.addAttribute("grade", new Grade());
        return "form";
    }

    @GetMapping("/grades")
    public String getGrades(Model model) {

        model.addAttribute("grades", studentGrades);

        Grade grade = new Grade("Greg", "Java", "A");
        model.addAttribute("grade", grade);
        return "grades";
    }

}
