package dev.jpa.entity.jpql.join.dto;

import dev.jpa.entity.jpql.join.Enrollment;
import dev.jpa.entity.jpql.join.Student;

public record EnrolledStudentDto(
        Student student,
        Enrollment enrollment
) {
}
