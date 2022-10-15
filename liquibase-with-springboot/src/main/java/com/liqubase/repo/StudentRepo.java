package com.liqubase.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.liqubase.model.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student, Long>
{
//	--precondition-sql-check expectedResult:0 SELECT COUNT(*) FROM users
//	--comment: /*comments should go after preCondition. If they are located before the precondition, then Liquibase usually gives error.*/

}
