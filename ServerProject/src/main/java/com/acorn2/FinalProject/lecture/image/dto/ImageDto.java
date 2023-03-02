package com.acorn2.FinalProject.lecture.image.dto;

public class ImageDto {
	private int lecNum;
	private String mimetype;
    private String originalName;
    private byte[] data;
    private String regdate;
    private String updateRegdate;
    
    public ImageDto() {}

	public ImageDto(int lecNum, String mimetype, String originalName, byte[] data, String regdate,
			String updateRegdate) {
		super();
		this.lecNum = lecNum;
		this.mimetype = mimetype;
		this.originalName = originalName;
		this.data = data;
		this.regdate = regdate;
		this.updateRegdate = updateRegdate;
	}

	public int getLecNum() {
		return lecNum;
	}

	public void setLecNum(int lecNum) {
		this.lecNum = lecNum;
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
