package com.sistemi.informativi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sistemi.informativi.entity.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, String> {

	public List<Teacher> findByExperienceYearsGreaterThan(int experienceYears);
}
