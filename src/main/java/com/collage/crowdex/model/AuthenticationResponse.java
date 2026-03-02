package com.collage.crowdex.model;

import java.io.Serializable;
/*
 * Used for Authetication Response
 */
public class AuthenticationResponse implements Serializable {

    private static final long serialVersionUID = 1L;
	private final String jwt;
	private int userRole;
	private Integer userId;

    public String getJwt() {
        return jwt;
    }

	
	
	public int getUserRole() {
		return userRole;
	}



	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}



	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public AuthenticationResponse(String jwt, int userRole, Integer userId) {
		super();
		this.jwt = jwt;
		this.userRole = userRole; 
		this.userId = userId;
	}
    
	
    
}
