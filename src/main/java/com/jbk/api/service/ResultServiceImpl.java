package com.jbk.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.api.dao.ResultDao;
import com.jbk.api.entity.Student;

@Service
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultDao dao;

	@Override
	public boolean saveResult(Student student) {

		boolean isAdded = dao.saveResult(student);

		return isAdded;
	}

	@Override
	public Student getStudentResultByPRN(long studentPrn) {
		Student student = dao.getStudentResultByPRN(studentPrn);
		return student;
	}

	@Override
	public List<Student> getAllStudentResult() {
		List<Student> list = dao.getAllStudentResult();
		return list;
	}

	@Override
	public boolean deleteResult(long studentPrn) {
		boolean isDeleted = dao.deleteResult(studentPrn);
		return isDeleted;
	}

	@Override
	public boolean updateStudentResult(Student student) {
		boolean isUpdated = dao.updateStudentResult(student);
		return isUpdated;
	}

	@Override
	public List<Student> getAllStudentResultBySeatNo_Asc() {
		List<Student> list = dao.getAllStudentResultBySeatNo_Asc();
		return list;
	}

	@Override
	public List<Student> getAllStudentResultBySeatNo_Dsc() {
		List<Student> list = dao.getAllStudentResultBySeatNo_Dsc();
		return list;
	}

	@Override
	public List<Student> getAllStudentResultByName_Asc() {
		List<Student> list = dao.getAllStudentResultByName_Asc();
		return list;
	}

	@Override
	public List<Student> getAllStudentResultByName_Dsc() {
		List<Student> list = dao.getAllStudentResultByName_Dsc();
		return list;
	}

	@Override
	public List<Student> getAllStudentResultByCollegeCode(long collegeCode) {
		List<Student> list = dao.getAllStudentResultByCollegeCode(collegeCode);
		return list;
	}

	@Override
	public Student getSingleStudentResultBySeatNo(long studentSeatNo) {
		Student student = dao.getSingleStudentResultBySeatNo(studentSeatNo);
		return student;
	}

	@Override
	public List<Student> getAllStudentResultByCollegeName(String collegeName) {
		
		return dao.getAllStudentResultByCollegeName(collegeName);
	}

	@Override
	public List<Student> getAllStudentResultByBranchName(String branchName) {
	
		return dao.getAllStudentResultByBranchName(branchName);
	}

	@Override
	public List<Student> getAllStudentResultByBranchCode(long branchCode) {
		
		return dao.getAllStudentResultByBranchCode(branchCode);
	}

	@Override
	public List<Student> getStudentsResultFinelPassOrFail(String result) {
		List<Student> list = dao.getStudentsResultFinelPassOrFail(result);
		return list;
	}

	@Override
	public List<String> getCollegeName() {
		
		return dao.getCollegeName();
	}

	@Override
	public List<String> getBranchNames() {
	
		return dao.getBranchNames();
	}

	@Override
	public List<Student> getStudentsSeatNowithStudentName() {
		List<Student> list = dao.getStudentsSeatNowithStudentName();
		return list;
	}

	@Override
	public List<Student> getStudentPrnwithStudentName() {
		
		return dao.getStudentPrnwithStudentName();
	}

	@Override
	public List<Student> getSubjectNamesBranchWise() {
		
		return dao.getSubjectNamesBranchWise();
	}

	@Override
	public List<Student> getStudentsSeatNowithStudentNameinDscOrder() {
		
		return dao.getStudentsSeatNowithStudentNameinDscOrder();
	}

	@Override
	public List<Student> getStudentPrnwithStudentNameinDscOrder() {
		
		return dao.getStudentPrnwithStudentNameinDscOrder();
	}

	@Override
	public List<Student> getCollegeCodeWithCollegeName() {
		
		return dao.getCollegeCodeWithCollegeName();
	}

	@Override
	public List<Student> getBranchCodeWithBranchName() {
		
		return dao.getBranchCodeWithBranchName();
	}

	@Override
	public List<Student> getCollegeCodeWithCollegeNameinDscOrder() {
		
		return dao.getCollegeCodeWithCollegeNameinDscOrder();
	}

	@Override
	public List<Student> getBranchCodeWithBranchNameinDscOrder() {
		
		return dao.getBranchCodeWithBranchNameinDscOrder();
	}

	@Override
	public List<String> getFinelResultValues() {
		
		return dao.getFinelResultValues();
	}

	@Override
	public List<Student> getTopperInUnivercity() {
		
		return dao.getTopperInUnivercity();
	}

	@Override
	public List<Student> getFirstRankInCollege(String collegeName) {
		
		return dao.getFirstRankInCollege(collegeName);
	}

	@Override
	public List<Student> getFirstRankInUnivecityBranchWise(String branchName) {
		
		return dao.getFirstRankInUnivecityBranchWise(branchName);
	}

	@Override
	public List<Student> getFirstRankInCollegebyCollegeCode(long collegeCode) {
		
		return dao.getFirstRankInCollegebyCollegeCode(collegeCode);
	}

	@Override
	public List<Student> getFirstRankInUnivecityBranchWiseUsingBranchCode(long branchCode) {
		
		return dao.getFirstRankInUnivecityBranchWiseUsingBranchCode(branchCode);
	}

	@Override
	public List<Student> getFirstRankInCollegeBranchWise(long collegeCode, long branchCode) {
	
		return dao.getFirstRankInCollegeBranchWise(collegeCode, branchCode);
	}

	@Override
	public long getTotalCountOfStudentResult() {
		
		return dao.getTotalCountOfStudentResult();
	}

	@Override
	public double getAvgOfTotalUnivercityResults() {
	
		return dao.getAvgOfTotalUnivercityResults();
	}

	@Override
	public List<Student> getCollegeAvgResult() {
		
		return dao.getCollegeAvgResult();
	}

	@Override
	public List<Student> getAvgOfUnivercityBranchWise() {
		
		return dao.getAvgOfUnivercityBranchWise();
	}

	@Override
	public List<Student> getAvgOfCollegeBranchWise() {
		
		return dao.getAvgOfCollegeBranchWise();
	}

	@Override
	public String getTotalCountOfStudentsPassorFail(String result) {
		
		return dao.getTotalCountOfStudentsPassorFail(result);
	}

	@Override
	public List<Student> findGreterStudentper(double percentage) {
	
		return dao.findGreterStudentper(percentage);
	}

	@Override
	public List<Student> findLessStudentPercentageUsingLessThen(double percentage) {
		
		return dao.findLessStudentPercentageUsingLessThen(percentage);
	}

	@Override
	public List<Student> findBetweenPercentageinUnivercityResults(double percentage, double percentage1) {
		
		return dao.findBetweenPercentageinUnivercityResults(percentage, percentage1);
	}

	

	
	

	
}
