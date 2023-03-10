package com.ltp.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GradesController {

    List <Grade> studentGrades = new ArrayList<>();

    @GetMapping("/")
    public String gradeForm(Model model, @RequestParam(required = false) String id) {
        Grade grade;
        if (getGradeIndex(id) == -1) {
            grade = new Grade();
        } else {
            grade = studentGrades.get(getGradeIndex(id));
        }
        model.addAttribute("grade", grade);
        return "form";
    }

    @GetMapping("/grades")
    public String getGrades(Model model) {
        model.addAttribute("grades", studentGrades);
        return "grades";
    }

    public Integer getGradeIndex(String id) {
        for (int i = 0; i < studentGrades.size(); i++) {
            if (studentGrades.get(i).getId().equals(id)) return Constants.NOT_FOUND;
        }
        return Constants.NOT_FOUND;
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Grade grade, BindingResult result) {
        if (result.hasErrors()) return "form";
        int index = getGradeIndex(grade.getId());
        if (index == -1) {
            studentGrades.add(grade);
        } else {
            studentGrades.set(index, grade);
        }
        return "redirect:/grades";
    }

}
