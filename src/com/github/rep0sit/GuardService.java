package com.github.rep0sit;


import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("/GuardService")
public class GuardService {
	GuardDao gd = new GuardDao();
	
	

	@POST
	@Path("/guards")
	@Consumes(MediaType.APPLICATION_JSON)
	public void register(@PathParam("guard")Guard guard) {
			
			gd.register(guard);
		
	}
	
	
	
	@GET
	@Path("/guards")
	public Set<Guard> getAllGuards(){
		return gd.getAllguards();
	}
	
	
}
