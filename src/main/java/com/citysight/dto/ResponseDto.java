package com.citysight.dto;

public class ResponseDto {
	private Object metadata;
    private Object data;
    
    // Setters and Getters
	public Object getMetadata() {
		return metadata;
	}
	public void setMetadata(Object metadata) {
		this.metadata = metadata;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	/**
	 * @param metadata
	 * @param data
	 */
	public ResponseDto(Object metadata, Object data) {
		super();
		this.metadata = metadata;
		this.data = data;
	}
	/**
	 * 
	 */
	public ResponseDto() {
		super();
	}
    
    
}
