package com.example.TodoManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TodoManager.entity.Personal;

public interface PersonalRepository extends JpaRepository<Personal,Integer> {
	Personal findByAddressAndPersonalPass(String address, String personalPass);

}
