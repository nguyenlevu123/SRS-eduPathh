package com.re.edupath.repository;

import com.re.edupath.model.Course;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepository {
    private static final List<Course> COURSES = new ArrayList<>();

    static {
        COURSES.add(new Course(1L, "ENG-START", "English Starter", "Beginner",
                new BigDecimal("3500000"), LocalDate.of(2026, 5, 10),
                "Làm quen phát âm, từ vựng nền tảng và hội thoại hằng ngày.",
                "Ms. Linh Nguyễn", "8 tuần", 0, 20));
        COURSES.add(new Course(2L, "COMM-A2", "Communication A2", "Beginner",
                new BigDecimal("4200000"), LocalDate.of(2026, 5, 18),
                "Tăng phản xạ giao tiếp, nghe nói theo tình huống học tập và công việc.",
                "Mr. An Trần", "10 tuần", 12, 18));
        COURSES.add(new Course(3L, "IELTS-5.5", "IELTS Foundation 5.5", "Intermediate",
                new BigDecimal("6200000"), LocalDate.of(2026, 6, 1),
                "Luyện 4 kỹ năng IELTS từ nền tảng lên mức mục tiêu 5.5.",
                "Ms. Mai Phạm", "12 tuần", 16, 16));
        COURSES.add(new Course(4L, "TOEIC-750", "TOEIC Target 750", "Intermediate",
                new BigDecimal("5800000"), LocalDate.of(2026, 6, 12),
                "Tập trung chiến lược nghe đọc TOEIC và quản lý thời gian làm bài.",
                "Mr. Khoa Lê", "10 tuần", 8, 20));
        COURSES.add(new Course(5L, "IELTS-6.5", "IELTS Intensive 6.5", "Advanced",
                new BigDecimal("8200000"), LocalDate.of(2026, 7, 3),
                "Lộ trình tăng band Writing và Speaking, kèm chấm bài hằng tuần.",
                "Ms. Hà Đỗ", "14 tuần", 18, 18));
    }

    public List<Course> findAll() {
        return COURSES;
    }

    public Optional<Course> findById(Long id) {
        return COURSES.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst();
    }

    public Optional<Course> findByCode(String code) {
        return COURSES.stream()
                .filter(course -> course.getCode().equalsIgnoreCase(code))
                .findFirst();
    }

    public void delete(Course course) {
        COURSES.remove(course);
    }
}
