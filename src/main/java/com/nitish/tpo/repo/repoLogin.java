package com.nitish.tpo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nitish.tpo.api.loginTable;

@Repository
public interface repoLogin extends JpaRepository<loginTable, String>{

}