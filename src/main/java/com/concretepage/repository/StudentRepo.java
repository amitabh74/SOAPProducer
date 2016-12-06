package com.concretepage.repository;

import org.springframework.data.repository.CrudRepository;

import com.concretepage.soap.Student;

public interface StudentRepo extends CrudRepository<Student, Integer> {

}
