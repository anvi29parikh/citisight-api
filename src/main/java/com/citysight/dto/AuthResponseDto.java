package com.citysight.dto;

public class AuthResponseDto {
	    private String token;
	    private String tokenExpiry;
	    
	    //Setters and getters
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		public String getTokenExpiry() {
			return tokenExpiry;
		}
		public void setTokenExpiry(String tokenExpiry) {
			this.tokenExpiry = tokenExpiry;
		}
		
		
		/**
		 * @param token
		 * @param tokenExpiry
		 */
		public AuthResponseDto(String token, String tokenExpiry) {
			super();
			this.token = token;
			this.tokenExpiry = tokenExpiry;
		}
		
		/**
		 * 
		 */
		public AuthResponseDto() {
			super();
		}
	    
		
	    
}
