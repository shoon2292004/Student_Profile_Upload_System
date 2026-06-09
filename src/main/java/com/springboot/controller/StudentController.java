package com.springboot.controller;

//import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.model.StudentBean;
import com.springboot.repository.StudentRepo;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentRepo sRepo;

	@GetMapping("/form")
	public ModelAndView showForm() {
		return new ModelAndView("upload-student", "stuObj", new StudentBean());
	}

	@PostMapping("/upload")
	public String uploadStudent(@ModelAttribute("stuObj") StudentBean obj, Model m,
			@RequestParam("photoFile") MultipartFile photo) throws IOException {

		String fileName = photo.getOriginalFilename();

		String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/img/upload/";

		Path path = Paths.get(uploadDir + fileName);

		Files.write(path, photo.getBytes());

		obj.setPhoto(fileName);
		sRepo.save(obj);
		m.addAttribute("stuObj", obj);
		/*
		 * System.out.println(uploadDir); System.out.println(path);
		 * System.out.println(Files.exists(path));
		 */

		return "student-info";
	}

}
