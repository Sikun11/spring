package com.nt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.binding.Student;
import com.nt.entity.StudentEntiry;
import com.nt.repo.StudentRepository;

@Controller
public class StudentController {

	@Autowired
	private StudentRepository repo;
	//method to load the student form
	@GetMapping("/")
	public String loadForm(Model model) {
		
		loadFormData(model);
		
		
		return "index";
	}
	private void loadFormData(Model model) {
		List<String> coursesList=new ArrayList<>();
		coursesList.add("java");
		coursesList.add("python");
		coursesList.add("oracle");
		coursesList.add("aws");
		coursesList.add("springboot");
		
		List<String> timingsList=new ArrayList<>();
		timingsList.add("morning");
		timingsList.add("afternoon");
		timingsList.add("evening");
		
		model.addAttribute("courses",coursesList );
		model.addAttribute("timings", timingsList);
		
		Student student=new Student();
		model.addAttribute("students", student);
	}
	//method to save the students data
	@PostMapping("/save")
	public String handleSubmit(Student s,Model model) {
		System.out.println(s);
      
		//logic to save
		StudentEntiry entity=new StudentEntiry();
		//data store student class bt we need in entity class
		//copy data from binding obj to entity obj
		BeanUtils.copyProperties(s, entity);
		entity.setTimings(Arrays.toString(s.getTimings()));
		repo.save(entity);
		model.addAttribute("msg", "student saved");
		loadFormData(model);
		return "index";
	}
	//method to display the student data
	@GetMapping("/viewStudents")
	public String getStudentsData(Model model) {
		//logic to fetch and send students data
		List<StudentEntiry> studlist = repo.findAll();
		model.addAttribute("students", studlist);
		return "data";
	}
}
