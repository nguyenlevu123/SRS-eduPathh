package com.re.edupath.controller;

import com.re.edupath.model.Course;
import com.re.edupath.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;

@Controller
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping({"/", "/course/list", "/courses/list"})
    public String listCourses(@RequestParam(name = "level", defaultValue = "All") String level,
                              @RequestParam(name = "maxFee", required = false) BigDecimal maxFee,
                              Model model) {
        model.addAttribute("courses", courseService.search(level, maxFee));
        model.addAttribute("selectedLevel", level);
        model.addAttribute("maxFee", maxFee);
        model.addAttribute("levels", new String[]{"All", "Beginner", "Intermediate", "Advanced"});
        return "course/list";
    }

    @GetMapping("/course/detail/{code}")
    public String courseDetail(@PathVariable("code") String code, Model model) {
        Course course = courseService.findByCode(code)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy khóa học"));
        model.addAttribute("course", course);
        return "course/detail";
    }

    @GetMapping("/course/edit/{id}")
    public String editCourse(@PathVariable("id") Long id, Model model) {
        Course course = courseService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy khóa học"));
        model.addAttribute("course", course);
        return "course/form";
    }

    @PostMapping("/course/update")
    public String updateCourse(@ModelAttribute("course") Course course,
                               RedirectAttributes redirectAttributes) {
        courseService.updateCourse(course);
        redirectAttributes.addFlashAttribute("successMessage", "Đã cập nhật thông tin khóa học thành công");
        return "redirect:/course/list";
    }

    @PostMapping("/course/delete/{id}")
    public String deleteCourse(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        boolean deleted = courseService.deleteCourse(id);
        if (deleted) {
            redirectAttributes.addFlashAttribute("successMessage", "Đã hủy khóa học thành công");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "Không thể hủy khóa học đã có học viên đăng ký");
        }
        return "redirect:/course/list";
    }
}
