package com.example.quotesApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quotesApi.model.Quote;
import com.example.quotesApi.repository.QuoteRepository;

@Service
public class QuoteService {
	
	@Autowired
	private QuoteRepository quoteRepository;
	
	
	public List<Quote> getList(){
		return quoteRepository.findAll();
	}
}
