package com.acorn2.FinalProject.lectureStudent.dto.req;

public class LectureStudentUpdateReqDto {
	private String lec_Stu_User_Id;
	private int lec_Stu_Ref_Group;
	private String Complete_Yn;
	
	public String getLec_Stu_User_Id() {
		return lec_Stu_User_Id;
	}
	public void setLec_Stu_User_Id(String lec_Stu_User_Id) {
		this.lec_Stu_User_Id = lec_Stu_User_Id;
	}
	public int getLec_Stu_Ref_Group() {
		return lec_Stu_Ref_Group;
	}
	public void setLec_Stu_Ref_Group(int lec_Stu_Ref_Group) {
		this.lec_Stu_Ref_Group = lec_Stu_Ref_Group;
	}
	public String getComplete_Yn() {
		return Complete_Yn;
	}
	public void setComplete_Yn(String complete_Yn) {
		Complete_Yn = complete_Yn;
	}
	
}
