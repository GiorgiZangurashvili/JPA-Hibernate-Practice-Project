package dev.jpa.entity.jpql.join.dto;

import dev.jpa.entity.jpql.join.Student;

public record CountedEnrollmentForStudent(
        Student student,
        long count
) {
}
