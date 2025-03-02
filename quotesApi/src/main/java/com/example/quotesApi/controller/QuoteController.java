package com.example.quotesApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.quotesApi.model.Quote;
import com.example.quotesApi.service.QuoteService;

@RestController
public class QuoteController {
	
	@Autowired
	private QuoteService quoteService;	
	
	@GetMapping("quote")
	public Quote getQuote() {
		return quoteService.getList();
	}
}
