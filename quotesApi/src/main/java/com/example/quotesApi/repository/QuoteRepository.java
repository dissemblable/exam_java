package com.example.quotesApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quotesApi.model.Quote;


@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer>{
}
