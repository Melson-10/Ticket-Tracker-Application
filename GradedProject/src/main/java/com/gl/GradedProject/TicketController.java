package com.gl.GradedProject;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.GradedProject.Model.Ticket;
import com.gl.GradedProject.Model.TicketService;


@Controller
public class TicketController {
	@Autowired
	TicketService service;
	
	@RequestMapping("/")
	public String home( Model data) {
		List<Ticket> tickets=service.getAll();
		data.addAttribute("tickets",tickets);
		return "home";
	}
	@RequestMapping("/add_form")
	public String Add() {
		return "add_ticket";
	}
	@PostMapping("/save_ticket")
	public String show(@RequestParam int id,@RequestParam  String ticketTitle ,@RequestParam String ticketShortDescription,@RequestParam String ticketCreatedOn,Model data) {
		Ticket t1= new Ticket( id,ticketTitle,ticketShortDescription,ticketCreatedOn);
		service.addupdate(t1);
		List<Ticket> tickets=service.getAll();
		data.addAttribute("tickets",tickets);
		return "home";
}
	@GetMapping("/show_page")
	public String viewForm(@RequestParam int id,Model data) {
		Ticket t2=service.getById(id);
			if(t2 !=null) {
				data.addAttribute("tickets",t2);
				return "view_form";
			}
		
			else {
		List<Ticket> tickets=service.getAll();
		data.addAttribute("tickets",tickets);
		return "home";
			}
	}
	@PostMapping("/view_page")
	public String view(Model data) {
		List<Ticket> tickets=service.getAll();
		data.addAttribute("tickets",tickets);
		return "home";
	}
	@GetMapping("/edit_page")
	public String editform(@RequestParam int id,Model data) {
		Ticket t2=service.getById(id);
			if(t2 !=null) {
				data.addAttribute("tickets",t2);
				return "edit_form";
			}
		
			else {
		List<Ticket> tickets=service.getAll();
		data.addAttribute("tickets",tickets);
		return "home";
			}
	}
	@PostMapping("/edit_page")
	public String edit(@RequestParam int id,@RequestParam  String ticketTitle ,@RequestParam String ticketShortDescription,@RequestParam String ticketCreatedOn,Model data) {
		Ticket t1= new Ticket( id,ticketTitle,ticketShortDescription,ticketCreatedOn);
		service.addupdate(t1);
		List<Ticket> tickets=service.getAll();
		data.addAttribute("tickets",tickets);
		return "home";
}
	@GetMapping("/delete_page")
	public String delete(@RequestParam int id,Model data) {
		Ticket t1= new Ticket(id,"","","");
		service.delete(t1);
		
		List<Ticket> tickets=service.getAll();
		data.addAttribute("tickets",tickets);
		return "home";
	}
	@GetMapping("/search_page")
	public String search(@RequestParam String search,Model data) {
		List<Ticket> tickets=service.filter("ticketTitle", search);
		data.addAttribute("tickets",tickets);
		return "home";
	}
	
}
