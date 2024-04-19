package com.example.demo.controller;

import java.lang.reflect.Field;
import java.util.List;

import org.aspectj.apache.bcel.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.categorydtos;

import jakarta.validation.Valid;

@RestController

@RequestMapping("api/v1/categories")
public class categorycontroller {
	
	@GetMapping("")
	public ResponseEntity<String>getAllCategories(
			@RequestParam("page") int page,
			@RequestParam("limit") int limit){
		return ResponseEntity.ok(String.format(" getallcategories,page=%d, limit=%d", page,limit));
	}
	
	@PostMapping("")
	public ResponseEntity<?> insertCategories(
			@Valid @RequestBody categorydtos categorydtos1,
			BindingResult result){
		if (result.hasErrors()) {
			List<String> errorMessageList= result.getFieldErrors()
					.stream()
					.map(FieldError::getDefaultMessage)
					.toList();
			return ResponseEntity.badRequest().body(errorMessageList);
		}
		return ResponseEntity.ok("post category "+ categorydtos1.getName());
	}
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCategories(@PathVariable long id){
		return ResponseEntity.ok("put method" + id);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategories(@PathVariable long id){
		return ResponseEntity.ok("delete method");
	}

}
