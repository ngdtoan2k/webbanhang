package com.example.demo.controller;


import java.util.List;


import org.springframework.http.ResponseEntity;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ProductDTO;

import jakarta.validation.Valid;


@RestController
@RequestMapping("api/v1/products")
public class productcontroller {
	
	@PostMapping("")
	public ResponseEntity<?> createProduct(
			@Valid @RequestBody ProductDTO productDTO,
			BindingResult result
			){
		try {
			if (result.hasErrors()) {
				List<String> errorMessageList= result.getFieldErrors()
						.stream()
						.map(FieldError.getF)
						.toList();
			
				return ResponseEntity.badRequest().body(errorMessageList);
			}
			return ResponseEntity.ok("thêm product ");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	@GetMapping("")
	public ResponseEntity<String> getAllProducts(
			@RequestParam("page") int page,
			@RequestParam("limit") int limit
			){
		
	 return ResponseEntity.ok(" get all products here");	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<String> getProductById(
			@PathVariable("id") String productId){
		return ResponseEntity.ok("get product bt id "+ productId);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable long id){
		return ResponseEntity.ok("delete product by id" + id);
	}
	
	}
