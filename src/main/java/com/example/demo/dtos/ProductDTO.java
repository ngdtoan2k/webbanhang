package com.example.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	
	@NotBlank(message = "title is required")
	@Size(min = 3, max = 200, message = "title is between 3 and 200 character")
	private String name;
	
	@Min(value = 0,message = "price must be greater than or equal to 0")
	@Max(value = 10000000, message = "price must be less than 10,000,000")
	private float price;
	
	private String thumbnail;
	private String description;
	
	@JsonProperty("category_id")
	private String catogeryId;
	
}
