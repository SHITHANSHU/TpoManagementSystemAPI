package com.nitish.tpo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nitish.tpo.api.studentProfile;

@Repository
public interface repoStudent extends JpaRepository<studentProfile, Integer>{

}