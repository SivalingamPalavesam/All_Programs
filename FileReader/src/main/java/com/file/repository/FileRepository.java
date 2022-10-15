package com.file.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.file.entity.FileDB;
@Repository
public interface FileRepository extends JpaRepository<FileDB, String>{

	Optional<FileDB> findByName(String fileName);

}
