package com.nitish.tpo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nitish.tpo.api.driveregistration;

@Repository
public interface repoDriveReg extends JpaRepository<driveregistration, String>{

}