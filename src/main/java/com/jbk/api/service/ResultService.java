package com.jbk.api.service;

import java.util.List;

import com.jbk.api.entity.Student;

public interface ResultService {
	
	public boolean saveResult(Student student );
	
	public Student getStudentResultByPRN (long studentPrn);
	
	public List<Student> getAllStudentResult();
	
	public boolean deleteResult(long studentPrn );
	
	public boolean updateStudentResult(Student student);
	
	public List<Student> getAllStudentResultBySeatNo_Asc();
	
	public List<Student> getAllStudentResultBySeatNo_Dsc();
	
	public List<Student> getAllStudentResultByName_Asc();
	
	public List<Student> getAllStudentResultByName_Dsc();
	
	public List<Student> getAllStudentResultByCollegeCode (long collegeCode);
	
	public Student getSingleStudentResultBySeatNo (long  studentSeatNo);
	
	public  List<Student> getAllStudentResultByCollegeName (String collegeName);
	
	public  List<Student> getAllStudentResultByBranchName (String branchName);
	
	public List<Student> getAllStudentResultByBranchCode (long branchCode);
	
	public  List<Student> getStudentsResultFinelPassOrFail (String result);
	
	public List<String> getCollegeName();
	
	public List<String> getBranchNames();
	
	public List<Student> getStudentsSeatNowithStudentName ();
	
	public List<Student> getStudentPrnwithStudentName ();
	
	public List<Student> getSubjectNamesBranchWise ();
	
	public List<Student> getStudentsSeatNowithStudentNameinDscOrder();
	
	public List<Student> getStudentPrnwithStudentNameinDscOrder();
	
	public List<Student> getCollegeCodeWithCollegeName ();
	
	public List<Student> getBranchCodeWithBranchName();
	
	public List<Student> getCollegeCodeWithCollegeNameinDscOrder ();
	
	public List<Student> getBranchCodeWithBranchNameinDscOrder();
	
	public List<String> getFinelResultValues();
	
	public List<Student> getTopperInUnivercity ();
	
	public List<Student> getFirstRankInCollege(String collegeName);
	
	public List<Student> getFirstRankInUnivecityBranchWise (String branchName);
	
	public List<Student> getFirstRankInCollegebyCollegeCode(long collegeCode);
	
	public List<Student> getFirstRankInUnivecityBranchWiseUsingBranchCode (long branchCode);
	
	public List<Student> getFirstRankInCollegeBranchWise(long collegeCode,long branchCode);
	
	public long getTotalCountOfStudentResult ();
	
	public double getAvgOfTotalUnivercityResults ();
	
	public List<Student> getCollegeAvgResult ();
	
	public List<Student> getAvgOfUnivercityBranchWise ();
	
	public List<Student> getAvgOfCollegeBranchWise ();
	
	public String getTotalCountOfStudentsPassorFail (String result);
	
	public List<Student> findGreterStudentper (double percentage);
	
	public List<Student> findLessStudentPercentageUsingLessThen (double percentage);
	
	public List<Student> findBetweenPercentageinUnivercityResults (double percentage , double percentage1);
	

}
