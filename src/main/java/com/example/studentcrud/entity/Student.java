package com.example.studentcrud.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * This class represents entity of Student table.
 *
 * @author Nanda Kishore
 * 
 */
@Data
@Entity
@Getter
@Setter
public class Student implements Serializable {
	@Id
	private int sId;
	private String sName;
	private String schoolName;
	private String address;

	
}
