package com.sistemi.informativi.service;

import java.util.List;
import java.util.Map;
import com.sistemi.informativi.entity.Teacher;

public interface TeacherService {
	
	public List<Teacher> findAllTeachers() throws Exception;
	public Teacher findTeacherByFiscalCode(String fiscalCode) throws Exception;
	public Teacher saveOrUpdateTeacher(Teacher teacher) throws Exception;
	public Map<String,Boolean> removeTeacher(String fiscalCode);
	public Map<String,Object> removeTeachersByExpYearsGreaterThan(int experienceYears);
}
