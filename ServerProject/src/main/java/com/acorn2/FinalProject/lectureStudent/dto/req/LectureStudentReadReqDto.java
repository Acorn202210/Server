package com.acorn2.FinalProject.lectureStudent.dto.req;

import com.acorn2.FinalProject.common.dto.PagingDto;

public class LectureStudentReadReqDto extends PagingDto{

	private String Lec_Stu_User_Id;
	private int lec_Stu_Ref_Group;
	private String large_category;
	private String small_category;

	
	public LectureStudentReadReqDto() {}


	public LectureStudentReadReqDto(String lec_Stu_User_Id, int lec_Stu_Ref_Group, String large_category,
			String small_category) {
		super();
		Lec_Stu_User_Id = lec_Stu_User_Id;
		this.lec_Stu_Ref_Group = lec_Stu_Ref_Group;
		this.large_category = large_category;
		this.small_category = small_category;
	}


	public String getLec_Stu_User_Id() {
		return Lec_Stu_User_Id;
	}


	public void setLec_Stu_User_Id(String lec_Stu_User_Id) {
		Lec_Stu_User_Id = lec_Stu_User_Id;
	}


	public int getLec_Stu_Ref_Group() {
		return lec_Stu_Ref_Group;
	}


	public void setLec_Stu_Ref_Group(int lec_Stu_Ref_Group) {
		this.lec_Stu_Ref_Group = lec_Stu_Ref_Group;
	}


	public String getLarge_category() {
		return large_category;
	}


	public void setLarge_category(String large_category) {
		this.large_category = large_category;
	}


	public String getSmall_category() {
		return small_category;
	}


	public void setSmall_category(String small_category) {
		this.small_category = small_category;
	}


	
	

	
	
	
}
