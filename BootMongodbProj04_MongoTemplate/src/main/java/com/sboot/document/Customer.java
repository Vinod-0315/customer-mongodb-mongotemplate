package com.sboot.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@Document
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Customer	 {
	
	@Id
	private String id;
	@NonNull
	private String name;
	@NonNull
	private String email;
	@NonNull
	private Long phoneNo;
	@NonNull
	private Integer cbillScore;
	@NonNull
	private String addrss;

}
