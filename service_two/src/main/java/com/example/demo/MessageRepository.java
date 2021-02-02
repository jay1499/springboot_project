package com.example.demo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model;


public interface MessageRepository extends JpaRepository<Model,Long> {
 
}