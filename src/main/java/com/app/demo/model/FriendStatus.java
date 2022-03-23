package com.app.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;



import lombok.Data;

@Component
@Data
@Entity
@Table
public class FriendStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
//	@NotNull
//	@Column(length=10)
	private String code;
//	@NotNull
//	@Column(length=15)
	private String name;
}
