package com.example.zoho_crm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.zoho_crm.entity.Lead;
@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {

}
