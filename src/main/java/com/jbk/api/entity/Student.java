package com.jbk.api.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Student {
	@Id
	@Min(1)
	private long studentPrn;
	@Min(1)
	private long  studentSeatNo;
	@NotNull(message = "Student name is required")
	private String studentName;
	@Min(1)
	private long collegeCode;
	@NotNull(message = "College name is required")
	private String collegeName;
	@Min(1)
	private long branchCode;
	@NotNull(message = "Branch name is required")
	private String branchName;
	@Min(1)
	private long sub1Code;
	@NotNull(message = "Subject 1 name is required")
	private String sub1Name;
	@Min(0)
	@Max(100)
	private double sub1marks;
	@Min(1)
	private long sub2Code;
	@NotNull(message = "Subject 2 name is required")
	private String sub2Name;
	@Min(0)
	@Max(100)
	private double sub2marks;
	@Min(1)
	private long sub3Code;
	@NotNull(message = "Subject 3 name is required")
	private String sub3Name;
	@Min(0)
	@Max(100)
	private double sub3marks;
	@Min(1)
	private long sub4Code;
	@NotNull(message = "Subject 4 name is required")
	private String sub4Name;
	@Min(0)
	@Max(100)
	private double sub4marks;
	@Min(1)
	private long sub5Code;
	@NotNull(message = "Subject 5 name is required")
	private String sub5Name;
	@Min(0)
	@Max(100)
	private double sub5marks;
	@Min(0)
	@Max(500)
	private long totalMarksobtain;
	@Max(500)
	private long totalmarks;
	
	private double percentage;
	@NotNull(message = "Result is required")
	private String result;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(long studentPrn, long studentSeatNo, String studentName, long collegeCode, String collegeName,
			long branchCode, String branchName, long sub1Code, String sub1Name, double sub1marks, long sub2Code,
			String sub2Name, double sub2marks, long sub3Code, String sub3Name, double sub3marks, long sub4Code,
			String sub4Name, double sub4marks, long sub5Code, String sub5Name, double sub5marks, long totalMarksobtain,
			long totalmarks, double percentage, String result) {
		super();
		this.studentPrn = studentPrn;
		this.studentSeatNo = studentSeatNo;
		this.studentName = studentName;
		this.collegeCode = collegeCode;
		this.collegeName = collegeName;
		this.branchCode = branchCode;
		this.branchName = branchName;
		this.sub1Code = sub1Code;
		this.sub1Name = sub1Name;
		this.sub1marks = sub1marks;
		this.sub2Code = sub2Code;
		this.sub2Name = sub2Name;
		this.sub2marks = sub2marks;
		this.sub3Code = sub3Code;
		this.sub3Name = sub3Name;
		this.sub3marks = sub3marks;
		this.sub4Code = sub4Code;
		this.sub4Name = sub4Name;
		this.sub4marks = sub4marks;
		this.sub5Code = sub5Code;
		this.sub5Name = sub5Name;
		this.sub5marks = sub5marks;
		this.totalMarksobtain = totalMarksobtain;
		this.totalmarks = totalmarks;
		this.percentage = percentage;
		this.result = result;
	}
	public long getStudentPrn() {
		return studentPrn;
	}
	public void setStudentPrn(long studentPrn) {
		this.studentPrn = studentPrn;
	}
	public long getStudentSeatNo() {
		return studentSeatNo;
	}
	public void setStudentSeatNo(long studentSeatNo) {
		this.studentSeatNo = studentSeatNo;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public long getCollegeCode() {
		return collegeCode;
	}
	public void setCollegeCode(long collegeCode) {
		this.collegeCode = collegeCode;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public long getBranchCode() {
		return branchCode;
	}
	public void setBranchCode(long branchCode) {
		this.branchCode = branchCode;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	public long getSub1Code() {
		return sub1Code;
	}
	public void setSub1Code(long sub1Code) {
		this.sub1Code = sub1Code;
	}
	public String getSub1Name() {
		return sub1Name;
	}
	public void setSub1Name(String sub1Name) {
		this.sub1Name = sub1Name;
	}
	public double getSub1marks() {
		return sub1marks;
	}
	public void setSub1marks(double sub1marks) {
		this.sub1marks = sub1marks;
	}
	public long getSub2Code() {
		return sub2Code;
	}
	public void setSub2Code(long sub2Code) {
		this.sub2Code = sub2Code;
	}
	public String getSub2Name() {
		return sub2Name;
	}
	public void setSub2Name(String sub2Name) {
		this.sub2Name = sub2Name;
	}
	public double getSub2marks() {
		return sub2marks;
	}
	public void setSub2marks(double sub2marks) {
		this.sub2marks = sub2marks;
	}
	public long getSub3Code() {
		return sub3Code;
	}
	public void setSub3Code(long sub3Code) {
		this.sub3Code = sub3Code;
	}
	public String getSub3Name() {
		return sub3Name;
	}
	public void setSub3Name(String sub3Name) {
		this.sub3Name = sub3Name;
	}
	public double getSub3marks() {
		return sub3marks;
	}
	public void setSub3marks(double sub3marks) {
		this.sub3marks = sub3marks;
	}
	public long getSub4Code() {
		return sub4Code;
	}
	public void setSub4Code(long sub4Code) {
		this.sub4Code = sub4Code;
	}
	public String getSub4Name() {
		return sub4Name;
	}
	public void setSub4Name(String sub4Name) {
		this.sub4Name = sub4Name;
	}
	public double getSub4marks() {
		return sub4marks;
	}
	public void setSub4marks(double sub4marks) {
		this.sub4marks = sub4marks;
	}
	public long getSub5Code() {
		return sub5Code;
	}
	public void setSub5Code(long sub5Code) {
		this.sub5Code = sub5Code;
	}
	public String getSub5Name() {
		return sub5Name;
	}
	public void setSub5Name(String sub5Name) {
		this.sub5Name = sub5Name;
	}
	public double getSub5marks() {
		return sub5marks;
	}
	public void setSub5marks(double sub5marks) {
		this.sub5marks = sub5marks;
	}
	public long getTotalMarksobtain() {
		return totalMarksobtain;
	}
	public void setTotalMarksobtain(long totalMarksobtain) {
		this.totalMarksobtain = totalMarksobtain;
	}
	public long getTotalmarks() {
		return totalmarks;
	}
	public void setTotalmarks(long totalmarks) {
		this.totalmarks = totalmarks;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	@Override
	public String toString() {
		return "Student [studentPrn=" + studentPrn + ", studentSeatNo=" + studentSeatNo + ", studentName=" + studentName
				+ ", collegeCode=" + collegeCode + ", collegeName=" + collegeName + ", branchCode=" + branchCode
				+ ", branchName=" + branchName + ", sub1Code=" + sub1Code + ", sub1Name=" + sub1Name + ", sub1marks="
				+ sub1marks + ", sub2Code=" + sub2Code + ", sub2Name=" + sub2Name + ", sub2marks=" + sub2marks
				+ ", sub3Code=" + sub3Code + ", sub3Name=" + sub3Name + ", sub3marks=" + sub3marks + ", sub4Code="
				+ sub4Code + ", sub4Name=" + sub4Name + ", sub4marks=" + sub4marks + ", sub5Code=" + sub5Code
				+ ", sub5Name=" + sub5Name + ", sub5marks=" + sub5marks + ", totalMarksobtain=" + totalMarksobtain
				+ ", totalmarks=" + totalmarks + ", percentage=" + percentage + ", result=" + result + "]";
	}
	
	
	
	
	

}
