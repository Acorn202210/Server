package com.acorn2.plec.users.profile.dto;

public class ProfileDto {
	private String lecUserId;
    private String mimetype;
    private String originalName;
    private byte[] data;
    private String regdate;
    private String updateRegdate;
    
    public ProfileDto(){}

	public ProfileDto(String lecUserId, String mimetype, String originalName, byte[] data, String regdate,
			String updateRegdate) {
		super();
		this.lecUserId = lecUserId;
		this.mimetype = mimetype;
		this.originalName = originalName;
		this.data = data;
		this.regdate = regdate;
		this.updateRegdate = updateRegdate;
	}

	public String getLecUserId() {
		return lecUserId;
	}

	public void setLecUserId(String lecUserId) {
		this.lecUserId = lecUserId;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getUpdateRegdate() {
		return updateRegdate;
	}

	public void setUpdateRegdate(String updateRegdate) {
		this.updateRegdate = updateRegdate;
	}    
}