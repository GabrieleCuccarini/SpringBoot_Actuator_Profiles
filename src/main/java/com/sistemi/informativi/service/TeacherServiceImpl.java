package com.sistemi.informativi.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sistemi.informativi.entity.Teacher;
import com.sistemi.informativi.repository.TeacherRepository;

@Service
public class TeacherServiceImpl implements TeacherService {
	
	@Autowired
	TeacherRepository teacherRepository;

	@Override
	public List<Teacher> findAllTeachers() throws Exception {
		List<Teacher> teachers = new ArrayList<>();
		teachers = teacherRepository.findAll();
		
		if (teachers.isEmpty()) {
			throw new Exception("No Teachers Found");
		} 
		return teachers;
	}

	@Override
	public Teacher findTeacherByFiscalCode(String fiscalCode) throws Exception {
		return teacherRepository.findById(fiscalCode).orElseThrow(()->new Exception("Teacher Not Found"));
	}

	@Override
	public Teacher saveOrUpdateTeacher(Teacher teacher) throws Exception {
		Teacher savedOrUpdated = teacherRepository.save(teacher);
		if (!savedOrUpdated.getFiscalCode().equals(teacher.getFiscalCode())) {
			throw new Exception("Insert/Update of Teacher Failed");
		} 
		
		return savedOrUpdated;
	}

	@Override
	public Map<String, Boolean> removeTeacher(String fiscalCode) {
		Map<String,Boolean> deletionMap = new HashMap<>();
		try {
			teacherRepository.deleteById(fiscalCode);
			deletionMap.put("Deleted", true);
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
			deletionMap.put("Deleted", false);
		}
		return deletionMap;
	}

	@Override
	public Map<String, Object> removeTeachersByExpYearsGreaterThan(int experienceYears) {
		List<Teacher> teachers = new ArrayList<>();
		Map<String,Object> deletionMap = new HashMap<>();
		
		//Recuperiamo la lista di Teacher che rispettano la query
		teachers = teacherRepository.findByExperienceYearsGreaterThan(experienceYears);
		if (teachers.isEmpty()) {
			deletionMap.put("Deletion", "Failed");
		} else {
			try {
				for (Teacher teacher: teachers) {
				teacherRepository.deleteById(teacher.getFiscalCode());
				deletionMap.put("deletion ok for", teacher.getFiscalCode());
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				deletionMap.put("Deletion", "Failed");
			}
		}
		
		return deletionMap;
	}
	
}
