package com.example.instructure.mapper;

import com.example.instructure.dto.InstructorDTO;
import com.example.instructure.entity.Instructor;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class InstructorMapper {

    //This is the method we use to fetch info from database to frontend
    public InstructorDTO fromInstructor(Instructor instructor){
        InstructorDTO instructorDTO = new InstructorDTO();
        BeanUtils.copyProperties(instructor, instructorDTO);
        return instructorDTO ;
    }

    //This is the method we use to send request from the frontend to the database
    public Instructor fromInstructorDTO(InstructorDTO instructorDTO){
        Instructor instructor = new Instructor();
        BeanUtils.copyProperties(instructorDTO, instructor);
        return instructor;
    }
}
