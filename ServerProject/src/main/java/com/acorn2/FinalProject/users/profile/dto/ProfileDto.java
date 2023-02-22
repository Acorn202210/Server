package com.acorn2.FinalProject.users.profile.dto;

public class ProfileDto {
	private Integer profileId;
    private String mimetype;
    private String originalName;
    private byte[] data;
    private String created;
    
    public ProfileDto(){}

	public ProfileDto(Integer profileId, String mimetype, String originalName, byte[] data, String created) {
		super();
		this.profileId = profileId;
		this.mimetype = mimetype;
		this.originalName = originalName;
		this.data = data;
		this.created = created;
	}

	public Integer getProfileId() {
		return profileId;
	}

	public void setProfileId(Integer profileId) {
		this.profileId = profileId;
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

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}
    
    
}
