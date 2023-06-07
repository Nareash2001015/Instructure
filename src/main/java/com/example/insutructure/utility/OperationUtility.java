package com.example.insutructure.utility;

import com.example.insutructure.dao.*;
import com.example.insutructure.entity.*;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class OperationUtility {
    public static void usersOperations(UserDao userDao ) {
        createUsers(userDao);
        updateUser(userDao);
        deleteUser(userDao);
        fetchUser(userDao);
    }

    public static void roleOperations(RoleDao roleDao) {
        createRoles(roleDao);
        updateRoles(roleDao);
        deleteRole(roleDao);
        fetchRole(roleDao);
    }

    public static void instructorOperations(InstructorDao instructorDao, RoleDao roleDao, UserDao userDao) {
        createInstructor(instructorDao, roleDao, userDao);
        updateInstructor(instructorDao);
        deleteInstructor(instructorDao);
        fetchInstructor(instructorDao);
    }

    public static void studentOperation(StudentDao studentDao, RoleDao roleDao, UserDao userDao) {
        createStudent(studentDao, roleDao, userDao);
        updateStudent(studentDao);
        deleteStudent(studentDao);
        fetchStudent(studentDao);
    }

    public static void courseOperations(CourseDao courseDao, Instructor instructorDao, StudentDao studentDao) {
        createCourse(courseDao, instructorDao);
    }

    private static void createCourse(CourseDao courseDao, InstructorDao instructorDao) {
        Instructor instructor = instructorDao.findById(2L).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        Course course1 = new Course("Hibernate", "5 Hours", "Introduction to hibernate", instructor);
        courseDao.save(course1);
        Course course2 = new Course("Spring data jpa", "10 Hours", "Master spring JPA", instructor);
        courseDao.save(course2);
    }

    private static void fetchStudent(StudentDao studentDao) {
        List<Student> students = studentDao.findAll();
        students.forEach(student -> System.out.println(student.toString()));
    }

    private static void deleteStudent(StudentDao studentDao) {
        studentDao.deleteById(1L);
    }

    private static void updateStudent(StudentDao studentDao) {
        Student student = studentDao.findById(2L).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        student.setFirstName("updatedFirstname1");
        student.setLastName("updatedLastname1");
        studentDao.save(student);
    }

    private static void createStudent(StudentDao studentDao, RoleDao roleDao, UserDao userDao) {
        Role role = roleDao.findRoleByName("Student");
        if(role == null) throw new EntityNotFoundException("Entity not found");

        User user1 = new User("student1@gmail.com", "pass1");
        userDao.save(user1);
        user1.assignRoleToUsers(role);
        Student student = new Student("student1FN", "student1LN", "Master degree", user1);
        studentDao.save(student);

        User user2 = new User("student2@gmail.com", "pass2");
        userDao.save(user2);
        user1.assignRoleToUsers(role);
        Student student2 = new Student("student2FN", "student2LN", "Phd", user2);
        studentDao.save(student2);
    }

    private static void createInstructor(InstructorDao instructorDao, RoleDao roleDao, UserDao userDao) {
        Role role = roleDao.findRoleByName("Instructor");
        if(role == null) throw new EntityNotFoundException("Entity not found");
        User user1 = new User("instructorUser1@gmail.com", "pass1");
        userDao.save(user1);
        user1.assignRoleToUsers(role);
        Instructor instructor1 = new Instructor("instructor1FN", "instructor1LN", "Experienced instructor", user1);
        instructorDao.save(instructor1);

        User user2 = new User("instructorUser2@gmail.com", "pass2");
        userDao.save(user2);
        user1.assignRoleToUsers(role);
        Instructor instructor2 = new Instructor("instructor2FN", "instructor2LN", "Experienced instructor", user2);
        instructorDao.save(instructor2);
    }

    private static void updateInstructor(InstructorDao instructorDao) {
        Instructor instructor = instructorDao.findById(1L).orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        instructor.setSummary("Certified Instructor");
        instructorDao.save(instructor);
    }

    private static void fetchInstructor(InstructorDao instructorDao) {
        List<Instructor> instructors = instructorDao.findAll();
        instructors.forEach(instructor -> System.out.println(instructor.toString()));
    }

    private static void deleteInstructor(InstructorDao instructorDao) {
        instructorDao.deleteById(2L);
    }

    public static void assignRolesToUsers(UserDao userDao, RoleDao roleDao) {
        Role role = roleDao.findRoleByName("Admin");
        if(role == null) throw new EntityNotFoundException("Role not found");
        List<User> users = userDao.findAll();
        users.forEach(user -> {
            user.assignRoleToUsers(role);
            userDao.save(user);
        });
    }

    private static void fetchRole(RoleDao roleDao) {
        roleDao.findAll().forEach(role -> System.out.println(role.toString()));
    }

    private static void deleteRole(RoleDao roleDao) {
        roleDao.deleteById(2L);
    }

    private static void updateRoles(RoleDao roleDao) {
        Role role = roleDao.findById(1L).orElseThrow(() -> new EntityNotFoundException("Role not found"));
        role.setName("New Admin");
        roleDao.save(role);   //save checks whether the entity is already exists. If it is then the changes are merged else the entity is created
    }

    private static void createRoles(RoleDao roleDao) {
        Role role1 = new Role("Admin");
        roleDao.save(role1);
        Role role2 = new Role("Instructor");
        roleDao.save(role2);
        Role role3 = new Role("Student");
        roleDao.save(role3);
    }

    private static void fetchUser(@org.jetbrains.annotations.NotNull UserDao userDao) {
        userDao.findAll().forEach(user -> System.out.println(user.toString()));
    }

    private static void deleteUser(UserDao userDao) {
        User user = userDao.findById(3L).orElseThrow(() -> new EntityNotFoundException("User not found."));
        userDao.delete(user);
    }

    private static void updateUser(UserDao userDao) {
        User user = userDao.findById(2L).orElseThrow(() -> new EntityNotFoundException("User not found."));
        user.setEmail("newEmail@gmail.com");
        userDao.save(user);
    }

    private static void createUsers(UserDao userDao) {
        User user1 = new User("user1@gmail.com", "pass1");
        userDao.save(user1);
        User user2 = new User("user2@gmail.com", "pass2");
        userDao.save(user2);
        User user3 = new User("user3@gmail.com", "pass3");
        userDao.save(user3);
        User user4 = new User("user4@gmail.com", "pass4");
        userDao.save(user4);
    }
}
