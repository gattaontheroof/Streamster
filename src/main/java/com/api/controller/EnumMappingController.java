package com.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.Country;

@RestController
@RequestMapping("enummapping")
public class EnumMappingController {
	
	@GetMapping("/get")
	public String getByCountry(@RequestParam(required = false) Country country) {
		return country.name();
	}

}
