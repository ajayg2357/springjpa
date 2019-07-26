package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.entities.Employee;
import com.cg.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/index")
	public String getHomePage(Model model) {

		model.addAttribute("designation", new String[] { "System Associate",
				"Asst Manager", "Dy Manager" });
		model.addAttribute("employee", new Employee());
		model.addAttribute("empList", employeeService.loadAll());

		return "index";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee,
			Model model) {

		Employee empRes = employeeService.save(employee);
		return "redirect:/index.html";
	}

}
