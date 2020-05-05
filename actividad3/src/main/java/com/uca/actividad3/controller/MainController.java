package com.uca.actividad3.controller;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.actividad3.domain.Student;

@Controller()
public class MainController {

    private List<Student> students = new ArrayList<Student>();

    @GetMapping(path = "ejemplo1", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String ejemplo1() {
	return "Bienvenidos\n" + "Programación N-Capas";
    }

    @GetMapping("ejemplo2")
    public @ResponseBody List<Student> ejemplo2() {
	return Arrays.asList(new Student("Alexis", "Javier", "01/01/2017", "Ingenieria Informatica", true),
		new Student("Pepe", "Barahona", "11/09/2001", "Ingenieria Aeronautica", false));
    }

    @GetMapping("inicio")
    public String inicio(Student student) {
	return "index";
    }

    @PostMapping("formData")
    public ModelAndView procesarStudent(Student student) {
	students.add(student);
	ModelAndView mav = new ModelAndView();
	mav.setViewName("index");
	mav.addObject(student);
	mav.addObject("student", new Student());

	return mav;
    }

    @GetMapping("listado")
    public ModelAndView listado() {
	ModelAndView mav = new ModelAndView();
	mav.setViewName("listado");
	mav.addObject("studentList",students);
	return mav;
    }
}
