package com.example.quotesApi.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quotesApi.model.Quote;
import com.example.quotesApi.repository.QuoteRepository;

@Service
public class QuoteService {
	
	@Autowired
	private QuoteRepository quoteRepository;
	
	
	public Quote getList(){
		List<Quote> listQuotes = quoteRepository.findAll();
		Random randomNumbers = new Random();
		
		return listQuotes.get(randomNumbers.nextInt(listQuotes.size()));
	}
}
