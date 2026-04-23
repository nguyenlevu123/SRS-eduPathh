package com.re.edupath.service;

import com.re.edupath.model.Course;
import com.re.edupath.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> search(String level, BigDecimal maxFee) {
        return courseRepository.findAll().stream()
                .filter(course -> "All".equalsIgnoreCase(level) || course.getLevel().equalsIgnoreCase(level))
                .filter(course -> maxFee == null || course.getTuitionFee().compareTo(maxFee) <= 0)
                .sorted(Comparator.comparing(Course::getStartDate))
                .toList();
    }

    public Optional<Course> findByCode(String code) {
        return courseRepository.findByCode(code);
    }

    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    public void updateCourse(Course updatedCourse) {
        Course course = courseRepository.findById(updatedCourse.getId())
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy khóa học"));
        course.setTuitionFee(updatedCourse.getTuitionFee());
        course.setStartDate(updatedCourse.getStartDate());
    }

    public boolean deleteCourse(Long id) {
        Optional<Course> course = courseRepository.findById(id);
        if (course.isEmpty() || course.get().getStudentCount() > 0) {
            return false;
        }
        courseRepository.delete(course.get());
        return true;
    }
}
