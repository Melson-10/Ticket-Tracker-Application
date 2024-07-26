package com.gl.GradedProject.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
	@Id
	private int id;
	private String ticketTitle;
	private String ticketShortDescription;
	private String ticketCreatedOn;

}
