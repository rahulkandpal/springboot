package com.example.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.repository.EmployeeJDBCRepository;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeJDBCRepository rs;

	@GetMapping("/employee")
	public Employee getEmployee(@RequestParam ("employee_id") int id) {
		//int id = Integer.parseInt(req.getParameter("employee_id"));
		Optional<Employee> e = Optional.empty();		
		try { e = rs.findById(id); }catch(Exception t) {}
		if(e.isPresent()) 
			return e.get();
		else return new Employee(-2,"","","");		
	}

	@GetMapping("/getAll") //http://localhost:8080/getAll?page=1&size=10
	public List<Employee> findByPage(@PageableDefault(size = 10) Pageable pageable,
            Model model)
	{		
		Page<Employee> page = rs.findByPage(pageable);
	      model.addAttribute("page", page);
		return page.getContent();
	}
	
	@DeleteMapping("/delete")
	public String deleteEmployee() {
		
		return "Employee Added";
	}

	@PostMapping("/add")
	public String addEmployee(@RequestBody Employee employee) {
		
		try {rs.insert(employee);}catch(Exception e) { System.out.println(e.toString());}
		
		return "Employee Added";
	}
	
	
}
