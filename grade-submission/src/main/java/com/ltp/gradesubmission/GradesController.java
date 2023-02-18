package com.ltp.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GradesController {

    List <Grade> studentGrades = new ArrayList<>();

    @GetMapping("/")
    public String gradeForm(Model model, @RequestParam(required = false) String name) {
        Grade grade;
        if (getGradeIndex(name) == -1) {
            grade = new Grade();
        } else {
            grade = studentGrades.get(getGradeIndex(name));
        }
        model.addAttribute("grade", grade);
        return "form";
    }

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", studentGrades);
        return "grades";
    }

    public Integer getGradeIndex(String name) {
        for (int i = 0; i < studentGrades.size(); i++) {
            if (studentGrades.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    @PostMapping("/handleSubmit")
    public String submitForm(Grade grade) {
        int index = getGradeIndex(grade.getName());
        if (index == -1) {
            studentGrades.add(grade);
        } else {
            studentGrades.set(index, grade);
        }
        return "redirect:/grades";
    }

}
