package com.jbk.api.dao;

import java.util.List;

import com.jbk.api.entity.Student;

public interface ResultDao {
	// Clint wants To save StudentResult
	public boolean saveResult(Student student);

	// clints Wants to get StudentResult by Prn
	public Student getStudentResultByPRN(long studentPrn);

	// clints Wants to get All UnivercityStudent Result
	public List<Student> getAllStudentResult();

	// Clint wants to DeleteStudent Result
	public boolean deleteResult(long studentPrn);

	// Clints Wants to UpdateStudent Result
	public boolean updateStudentResult(Student student);

	// Clints Wants to getAllStudentResultByRollNo In Asc Order
	public List<Student> getAllStudentResultBySeatNo_Asc();

	// Clints Wants to getAllStudentResultByRollNo In Dsc Order
	public List<Student> getAllStudentResultBySeatNo_Dsc();

	// Clint Want to get All Student Result By Name In Asc Order
	public List<Student> getAllStudentResultByName_Asc();

	// Clint Want to get All Student Result By Name In Dsc Order
	public List<Student> getAllStudentResultByName_Dsc();

	// Clint want to get all Result of perticular College by College code
	public List<Student> getAllStudentResultByCollegeCode(long collegeCode);

	// Clint Wants to Get Single Result By Seat no
	public Student getSingleStudentResultBySeatNo(long studentSeatNo);

	// Clint Want to get Result by College Name
	public List<Student> getAllStudentResultByCollegeName(String collegeName);

	// Clint Want to get Result by Branch Name
	public List<Student> getAllStudentResultByBranchName(String branchName);

	// Clint Want to get Result By Branch Code
	public List<Student> getAllStudentResultByBranchCode(long branchCode);

	// Clints Wants to A GetStudentResult Pass Or Fail
	public List<Student> getStudentsResultFinelPassOrFail(String result);

	// Clint Wants to College Names
	public List<String> getCollegeName();

	// Clint Wants To Branch Names
	public List<String> getBranchNames();

	// Clint Want To get all Students SeatNo with Student Name in Asc Order
	public List<Student> getStudentsSeatNowithStudentName();

	// Clint Want To get All StudentPrn with Student Name in Asc Order
	public List<Student> getStudentPrnwithStudentName();

	// Clint Wants To get Subject Names Branch Wise
	public List<Student> getSubjectNamesBranchWise();

	// Clint Want To get All Students Seat no with Student Name in Dsc Order
	public List<Student> getStudentsSeatNowithStudentNameinDscOrder();
	
	// Clint Want To get All StudentPrn with Student Name in Dsc Order
	public List<Student> getStudentPrnwithStudentNameinDscOrder();
	
	// Clint want to get CollegeCode With College Name in Asc Order
	public List<Student> getCollegeCodeWithCollegeName ();
	
	// Clint want to get BranchCode With Branch Name in Asc Order
	public List<Student> getBranchCodeWithBranchName();
	
	// Clint want to get CollegeCode With College Name in Dsc Order
	public List<Student> getCollegeCodeWithCollegeNameinDscOrder ();
	
	// Clint want to get BranchCode With Branch Name in Dsc Order
	public List<Student> getBranchCodeWithBranchNameinDscOrder();
	
	// Clint Want to get What is The Values in Finel Result (Pass/Fail)
	public List<String> getFinelResultValues();
	
	// Clint Want To get Univercity Topper
	public List<Student> getTopperInUnivercity ();
	
	// Clint Want to get College Topper From College1/College2   Students 
	public List<Student> getFirstRankInCollege(String collegeName);
	
	// Clint Want To get Univercity FirstRank By Branch Wise
	public List<Student> getFirstRankInUnivecityBranchWise (String branchName);
	
	// Clint Want to get College Topper From College1/College2   Students by College code
	public List<Student> getFirstRankInCollegebyCollegeCode(long collegeCode);
	
	// Clint Want To get Univercity FirstRank By Branch Wise using BranchCode
	public List<Student> getFirstRankInUnivecityBranchWiseUsingBranchCode (long branchCode);

	// Clint Want to FirstRank Student In College Branch Wise
	public List<Student> getFirstRankInCollegeBranchWise(long collegeCode,long branchCode);
	
	// Clint Want Total Count of Students In Univercity
	public long getTotalCountOfStudentResult ();
	
	// Clint wants To Get Univercity OverAll Avrage of Results
	public double getAvgOfTotalUnivercityResults ();
	
	// Clints Want to Get College Result Avg
	public List<Student> getCollegeAvgResult ();
	
	// Clint Wants To Get Branch Wise Avg 
	public List<Student> getAvgOfUnivercityBranchWise ();
	
	// Clint Wants to get avg of College Branch Wise
	public List<Student> getAvgOfCollegeBranchWise ();
	
	// Clint Want to get Total Count Of pass/fail Student In Univercity
	public String getTotalCountOfStudentsPassorFail (String result);
	
	// Clint Want to find StudentPercentae Above or Greter the Reqiurment Percentage using Greter then
	public List<Student> findGreterStudentper (double percentage);
	
	// Clint Want to find StudentPercentage Less  the Reqiurment Percentage
	public List<Student> findLessStudentPercentageUsingLessThen (double percentage);
	
	//Clint Wants to find Student Percentage in Between 
	public List<Student> findBetweenPercentageinUnivercityResults (double percentage , double percentage1);
	
	//  Upload Excel Sheet
	// Extract Excel Sheet 
	//Clint Wants to greter Percentage in College (For College Only)
	//Clint Wants to less Percentage in College (For College Only)
	//Clint Wants to between Percentage in College (For College Only)
	// Clint Wants to branch Wise Greter then Percentage 
	// Clint Wants to branch Wise less then Percentage
	// Clint Wants to branch Wise between Percentage
	// Clint Wants To get Subject1 Topper in univercity with Perticular Branch
	// Clint Wants To get Subject2 Topper in univercity with Perticular Branch
	// Clint Wants To get Subject3 Topper in univercity with Perticular Branch
	// Clint Wants To get Subject4 Topper in univercity with Perticular Branch
	// Clint Wants To get Subject5 Topper in univercity with Perticular Branch
	// Clint wants To get Subject1 topper in College with perticular Branch
	// Clint wants To get Subject2 topper in College with perticular Branch
	// Clint wants To get Subject3 topper in College with perticular Branch
	// Clint wants To get Subject4 topper in College with perticular Branch
	// Clint wants To get Subject5 topper in College with perticular Branch
}
