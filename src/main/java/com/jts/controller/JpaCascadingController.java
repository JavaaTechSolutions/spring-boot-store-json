package com.jts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jts.service.JpaService;

@RestController
@RequestMapping("/api")
public class JpaCascadingController {

	@Autowired
	private JpaService jpaService;

	@PostMapping("/save")
	public ResponseEntity<String> save() throws JsonProcessingException {
		jpaService.save();
		return ResponseEntity.status(HttpStatus.OK).body("Data saved successfully");
	}

}
