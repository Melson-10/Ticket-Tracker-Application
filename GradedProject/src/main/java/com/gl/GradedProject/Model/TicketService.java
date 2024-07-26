package com.gl.GradedProject.Model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;


@Service
public class TicketService {
	@Autowired
	 TicketRepo repo;
	
	public void addupdate(Ticket  ticket) {
		repo.save(ticket);
	}
	public void delete(Ticket ticket) {
		repo.delete(ticket);
	}
	public List<Ticket> getAll(){
		return repo.findAll();
	}
	public Ticket findById(int id) {
		if( repo.findById(id).isEmpty()) {
		return null;
		}
		else {
			 return repo.findById(id).get();
		}
	}
	public Ticket getById(int id) {
		Optional<Ticket> opt=repo.findById(id);
		Ticket temp=null;
		if(opt.get() !=null) {
			temp=opt.get();
		}
		return temp;
		
		}
	
	public List<Ticket> filter (String columnname,String searchKey){
		//1.create a dummy object based on the searchkey
		Ticket dummy = new Ticket();
			dummy.setTicketTitle(searchKey);
		//2.create Example JPA-where
		ExampleMatcher exampleMatcher=ExampleMatcher.matching().withMatcher("ticketTitle",ExampleMatcher.GenericPropertyMatchers.contains()).withIgnorePaths("id","ticketShortDescription","ticketCreatedOn");
		
		//3.Combining Dummy  with where
		Example<Ticket> example =Example.of(dummy,exampleMatcher);
		return repo.findAll(example);
	}
	
	}
	


	
	

