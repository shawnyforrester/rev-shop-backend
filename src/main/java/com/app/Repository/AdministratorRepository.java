package com.app.Repository;

import com.app.Model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdministratorRepository extends JpaRepository <Administrator, Long> {
}