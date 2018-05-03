package com.guards;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GuardDao {

	private static Set<Guard> guards = new HashSet<>();
//	private static String FILE_NAME = "guards.dat";
	
	private final Map<String,String> guardPWMap = new HashMap<String,String>();
	private static final String SUCCESS_LOGIN = "<result>success_login</result>";
	private static final String FAILURE_LOGIN = "<result>failure_login</result>";
	
	public GuardDao()
	{
		setGuards();
	}
	
	public Set<Guard> getAllGuards(){
		return guards;
		
	}
	
	private void setGuards(){
		addGuard("guard1","guard1","guard1@email","password1",1);
		addGuard("guard2","guard2","guard2@email","password2",2);
	}
	
	public String getGuardName(int id){
		for(Guard g : guards){
			if(g.getId() == id){
				return g.getVorname() + " " + g.getNachname();
			}
		}
		return "Guard nicht vorhanden";
	}
	
	public Guard getGuard(int id) {
		return guards.stream().filter(g -> g.getId() == id).findAny().orElse(null);
	}
	
	public void addGuard(String v, String n, String e, String p, int id){
		Guard guard = new Guard(v,n,e,p,id);
		guards.add(guard);
		guardPWMap.put(guard.getEmail(), guard.getPassword());
	}


	public int addGuard(Guard guard) {
		if(guards.contains(guard)) {return 0;}
		guards.add(guard);
		guardPWMap.put(guard.getEmail(), guard.getPassword());

		return 1;
	}
	
	public String login(String email, String password){
		if(guardPWMap.containsKey(email)){
			String dbPW = guardPWMap.get(email);
			if(dbPW.equals(password)){
				return FAILURE_LOGIN;
			}
		}
		return SUCCESS_LOGIN;		
	}
	
	public String logout(String email){
//		Response.seeOther( URI.create("../guards")).build();
		return email + " is logged out.";
	}
}
