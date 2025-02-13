package com.example.chatApp.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "message")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	String content;
	
	Integer user_id;

	boolean is_user_message;
	
	Date timestampDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public boolean getIs_user_message() {
		return is_user_message;
	}

	public void setIs_user_message(boolean is_user_message) {
		this.is_user_message = is_user_message;
	}

	public Date getTimestampDate() {
		return timestampDate;
	}

	public void setTimestampDate(Date timestampDate) {
		this.timestampDate = timestampDate;
	}
	
	
	
}