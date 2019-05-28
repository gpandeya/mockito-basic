package com.rnd.unittesting.unittesting.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rnd.unittesting.unittesting.model.Item;

@RestController
public class ItemController {
	
	@GetMapping("/dummy-item")
	public Item dummyItem() {
		return new Item(1, "Ball",10,100);
	}

}
