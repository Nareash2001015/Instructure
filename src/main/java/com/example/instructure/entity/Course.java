package com.example.instructure.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "course")     //To specify the name in the DB
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto-increment Strategy
    @Column(name = "courseId", nullable = false)
    private Long courseId;

    @Basic
    @Column(name = "courseName", nullable = false, length = 45)
    private String courseName;

    @Basic
    @Column(name = "courseDuration", nullable = false, length = 45)
    private String courseDuration;

    @Basic
    @Column(name = "courseDescription", nullable = false, length = 64)
    private String courseDescription;

    //Foreign classes
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "enrolled_in",
    joinColumns = {@JoinColumn(name = "courseId")},
    inverseJoinColumns = {@JoinColumn(name = "studentId")})
    private Set<Student> students = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructorId", referencedColumnName = "instructorId", nullable = false)
    private Instructor instructor;

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void assignStudentToCourse(Student student){
        this.students.add(student);
        student.getCourses().add(this);
    }

    public void removeStudentFromCourse(Student student){
        this.students.remove(student);
        student.getCourses().remove(this);
    }

    public Course() {
    }

    public Course(String courseName, String courseDuration, String courseDescription, Instructor instructor) {
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.courseDescription = courseDescription;
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseDuration='" + courseDuration + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseId.equals(course.courseId) && Objects.equals(courseName, course.courseName) && Objects.equals(courseDuration, course.courseDuration) && Objects.equals(courseDescription, course.courseDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName, courseDuration, courseDescription);
    }
}
