package com.nitish.tpo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nitish.tpo.api.placementdrive;

@Repository
public interface repoPlacement extends JpaRepository<placementdrive, Integer>{

}