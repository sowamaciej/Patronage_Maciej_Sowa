package com.sowamaciej.BackendApplication.Repository;

import com.sowamaciej.BackendApplication.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
