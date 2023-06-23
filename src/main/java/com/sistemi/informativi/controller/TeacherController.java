package com.sistemi.informativi.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sistemi.informativi.entity.Teacher;
import com.sistemi.informativi.service.TeacherService;

@RestController
@RequestMapping("/api/teachers/")
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	
	@GetMapping("")
	public List<Teacher> findAllTeachers() throws Exception{
		return teacherService.findAllTeachers();
	};
	
	@GetMapping("{fiscalCode}")
	public Teacher findTeacherByFiscalCode(@PathVariable String fiscalCode) throws Exception{
		return teacherService.findTeacherByFiscalCode(fiscalCode);
	};
	
	@PostMapping("")
	public Teacher saveTeacher(@RequestBody Teacher teacher) throws Exception{
		return teacherService.saveOrUpdateTeacher(teacher);
	};
	
	@PutMapping("")
	public Teacher updateTeacher(@RequestBody Teacher teacher) throws Exception{
		return teacherService.saveOrUpdateTeacher(teacher);
	};
	
	@DeleteMapping("{fiscalCode}")
	public Map<String, Boolean> removeTeacher(@PathVariable String fiscalCode) {
		return teacherService.removeTeacher(fiscalCode);
	};
	
	@DeleteMapping("experience-years/{experienceYears}")
	public Map<String, Object> removeTeacherByExpYearsGreaterThan(@PathVariable int experienceYears) {
		return teacherService.removeTeachersByExpYearsGreaterThan(experienceYears);
	};	
}
