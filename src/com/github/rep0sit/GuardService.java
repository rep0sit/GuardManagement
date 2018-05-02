package com.github.rep0sit;


import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/GuardService")
public class GuardService {
	GuardDao gd = new GuardDao();
	
	@POST
	@Path("{vorname},{nachname},{email},{password}")
	public void register(@PathParam("vorname")String vorname, 
			@PathParam("name")String nachname, 
			@PathParam("email")String email, 
			@PathParam("password")String password){
		
		Guard ng = new Guard(vorname, nachname, email, password);
		gd.register(ng);
		
	}
}
