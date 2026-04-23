package com.re.edupath.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

public class Course {
    private Long id;
    private String code;
    private String name;
    private String level;
    private BigDecimal tuitionFee;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    private String description;
    private String instructor;
    private String duration;
    private int studentCount;
    private int capacity;

    public Course() {
    }

    public Course(Long id, String code, String name, String level, BigDecimal tuitionFee,
                  LocalDate startDate, String description, String instructor, String duration,
                  int studentCount, int capacity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.level = level;
        this.tuitionFee = tuitionFee;
        this.startDate = startDate;
        this.description = description;
        this.instructor = instructor;
        this.duration = duration;
        this.studentCount = studentCount;
        this.capacity = capacity;
    }

    public boolean isFull() {
        return studentCount >= capacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public BigDecimal getTuitionFee() {
        return tuitionFee;
    }

    public void setTuitionFee(BigDecimal tuitionFee) {
        this.tuitionFee = tuitionFee;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
