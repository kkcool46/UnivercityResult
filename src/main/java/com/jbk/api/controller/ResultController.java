package com.jbk.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.api.entity.Student;
import com.jbk.api.exception.BranchNotFoundException;
import com.jbk.api.exception.CollegeCodeNotFoundException;
import com.jbk.api.exception.ListNotFoundException;
import com.jbk.api.exception.ResultAlredyExistsException;
import com.jbk.api.exception.ResultNotFoundForThisPrn;
import com.jbk.api.exception.ResultNotFoundThisSeatNo;
import com.jbk.api.service.ResultService;

@RestController
@RequestMapping(value = "/nmuresult")
public class ResultController {

	@Autowired
	private ResultService resultService;

	@PostMapping(value = "/saveresult")
	public ResponseEntity<Boolean> saveResult(@Valid @RequestBody Student student) {

		boolean isAdded = resultService.saveResult(student);

		if (isAdded) {

			return new ResponseEntity<Boolean>(isAdded, HttpStatus.OK);

		} else {

			throw new ResultAlredyExistsException("Result Alredy Exists By This Prn " + student.getStudentPrn());

		}

	}

	@GetMapping(value = "/getstudentresultbyprn/{studentPrn}")
	public ResponseEntity<Student> getStudentResultByPRN(@Valid @PathVariable long studentPrn) {

		Student student = resultService.getStudentResultByPRN(studentPrn);
		if (student != null) {

			return new ResponseEntity<Student>(student, HttpStatus.OK);

		} else {

			throw new ResultNotFoundForThisPrn("Result Not Found For this PRN " + studentPrn);

		}
	}

	@GetMapping(value = "/getallstudentsresults")
	public ResponseEntity<List<Student>> gelAllStudentResult() {

		List<Student> list = resultService.getAllStudentResult();
		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("List Not Found For This Url ");

		}

	}

	@DeleteMapping(value = "/deletestudentresult")
	public ResponseEntity<Boolean> deleteResult(@RequestParam long studentPrn) {

		boolean isDeleted = resultService.deleteResult(studentPrn);

		if (isDeleted) {

			return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);

		} else {

			throw new ResultNotFoundForThisPrn("Result Not Found For this PRN " + studentPrn);

		}

	}

	@PutMapping(value = "/updatestudentresult")
	public ResponseEntity<Boolean> updateStudentResult(@Valid @RequestBody Student student) {
		boolean isUpdated = resultService.updateStudentResult(student);

		if (isUpdated) {

			return new ResponseEntity<Boolean>(isUpdated, HttpStatus.OK);

		} else {

			throw new ResultNotFoundForThisPrn("Result Not Found For this PRN " + student.getStudentPrn());

		}

	}

	@GetMapping(value = "/getallstudentsresultsbyseatno_asc")
	public ResponseEntity<List<Student>> getAllStudentResultBySeatNo_Asc() {

		List<Student> list = resultService.getAllStudentResultBySeatNo_Asc();

		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("List Not Found For This Url ");

		}

	}

	@GetMapping(value = "/getallstudentsresultsbyseatno_dsc")
	public ResponseEntity<List<Student>> getAllStudentResultBySeatNo_Dsc() {

		List<Student> list = resultService.getAllStudentResultBySeatNo_Dsc();

		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("List Not Found For This Url ");

		}

	}

	@GetMapping(value = "/getallstudentsresultsbyname_asc")
	public ResponseEntity<List<Student>> getAllStudentResultByName_Asc() {

		List<Student> list = resultService.getAllStudentResultByName_Asc();

		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("List Not Found For This Url ");

		}

	}

	@GetMapping(value = "/getallstudentsresultsbyname_dsc")
	public ResponseEntity<List<Student>> getAllStudentResultByName_Dsc() {

		List<Student> list = resultService.getAllStudentResultByName_Dsc();

		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("List Not Found For This Url ");

		}

	}

	@GetMapping(value = "/getallstudentresultbycollegecode/{collegeCode}")
	public ResponseEntity<List<Student>> getAllStudentResultByCollegeCode(@Valid @PathVariable long collegeCode) {

		List<Student> list = resultService.getAllStudentResultByCollegeCode(collegeCode);

		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new CollegeCodeNotFoundException("College Not Found For this Code " + collegeCode);

		}
 
	}

	@GetMapping(value = "/getsinglestudentresultbyseatno/{studentSeatNo}")
	public ResponseEntity<Student> getSingleStudentResultBySeatNo(@Valid @PathVariable long studentSeatNo) {

		Student student = resultService.getSingleStudentResultBySeatNo(studentSeatNo);

		if (student != null) {

			return new ResponseEntity<Student>(student, HttpStatus.OK);

		} else {

			throw new ResultNotFoundThisSeatNo("Result Not Found This SeatNo - " + studentSeatNo);

		}

	}

	@GetMapping(value = "/getresultbycollegename/{collegeName}")
	public ResponseEntity<List<Student>> getAllStudentResultByCollegeName(@Valid @PathVariable String collegeName) {
		List<Student> list3 = resultService.getAllStudentResultByCollegeName(collegeName);
		if (!list3.isEmpty()) {

			return new ResponseEntity<List<Student>>(list3, HttpStatus.OK);

		} else {

			throw new CollegeCodeNotFoundException("College Not Found For this Name " + collegeName);

		}

	}

	@GetMapping(value = "/getresultbybranchneme/{branchName}")
	public ResponseEntity<List<Student>> getAllStudentResultByBranchName(@Valid @PathVariable String branchName) {

		List<Student> list = resultService.getAllStudentResultByBranchName(branchName);
		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new BranchNotFoundException ("Branch Not Found For This Name " + branchName);

		}

	}

	@GetMapping(value = "/getresultbybranchcode/{branchCode}")
	public ResponseEntity<List<Student>> getAllStudentResultByBranchCode(@Valid @PathVariable long branchCode) {

		List<Student> list = resultService.getAllStudentResultByBranchCode(branchCode);

		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new BranchNotFoundException ("Branch Not Found For This Code " + branchCode);

		}

	}

	@GetMapping(value = "/getfinelresultpassorfail/{result}")
	public ResponseEntity<List<Student>> getStudentsResultFinelPassOrFail(@Valid @PathVariable String result) {

		List<Student> list = resultService.getStudentsResultFinelPassOrFail(result);
		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new ResultNotFoundForThisPrn("Result Not Found For This Keyword :- " + result + " (Use Pass Or Fail Only)");

		}

	}

	@GetMapping(value = "/getcollegename")
	public ResponseEntity<List<String>> getCollegeName() {

		List<String> list = resultService.getCollegeName();
		if (!list.isEmpty()) {

			return new ResponseEntity<List<String>>(list, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("List Not Found For This Url ");
		}

	}

	@GetMapping(value = "/getbranchnames")
	public ResponseEntity<List<String>> getBranchNames() {

		List<String> list = resultService.getBranchNames();
		if (!list.isEmpty()) {

			return new ResponseEntity<List<String>>(list, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("List Not Found For This Url ");

		}

	}

	@GetMapping(value = "/getstudentseatnoandname")
	public ResponseEntity<List<Student>> getStudentsSeatNowithStudentName() {

		List<Student> list = resultService.getStudentsSeatNowithStudentName();
		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {
			throw new ListNotFoundException("List Not Found For This Url ");

		}
	}

	@GetMapping(value = "/getstudentprnandname")
	public ResponseEntity<List<Student>> getStudentPrnwithStudentName() {

		List<Student> list = resultService.getStudentPrnwithStudentName();
		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("List Not Found For This Url ");

		}

	}

	@GetMapping(value = "/getstudentsubjectbranchwise")
	public ResponseEntity<List<Student>> getSubjectNamesBranchWise() {

		List<Student> list = resultService.getSubjectNamesBranchWise();
		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("List Not Found For This Url ");

		}

	}

	@GetMapping(value = "/getstudent/seatnoandname/in/dscorder")
	public ResponseEntity<List<Student>> getStudentsSeatNowithStudentNameinDscOrder() {

		List<Student> list = resultService.getStudentsSeatNowithStudentNameinDscOrder();
		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("List Not Found For This Url ");

		}
	}

	@GetMapping(value = "/getstudent/seatnoandname/in/dsc/order")
	public ResponseEntity<List<Student>> getStudentPrnwithStudentNameinDscOrder() {

		List<Student> list = resultService.getStudentPrnwithStudentNameinDscOrder();
		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("List Not Found For This Url ");

		}

	}

	@GetMapping(value = "/getstudent/collegecodeandcollegename")
	public ResponseEntity<List<Student>> getCollegeCodeWithCollegeName() {

		List<Student> list = resultService.getCollegeCodeWithCollegeName();
		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("List Not Found For This Url ");

		}

	}

	@GetMapping(value = "/getstudent/branchcodeandbranchname")
	public ResponseEntity<List<Student>> getBranchCodeWithBranchName() {

		List<Student> list = resultService.getBranchCodeWithBranchName();
		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("List Not Found For This Url ");

		}

	}

	@GetMapping(value = "/getstudent/collegecodeandcollegename/in/dsc/order")
	public ResponseEntity<List<Student>> getCollegeCodeWithCollegeNameinDscOrder() {
		List<Student> list = resultService.getCollegeCodeWithCollegeNameinDscOrder();
		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("List Not Found For This Url ");

		}

	}

	@GetMapping(value = "/getstudent/branchcodeandbranchname/in/dsc/order")
	public ResponseEntity<List<Student>> getBranchCodeWithBranchNameinDscOrder() {

		List<Student> list = resultService.getBranchCodeWithBranchNameinDscOrder();
		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("List Not Found For This Url ");

		}

	}

	@GetMapping(value = "/getfinelresultvalues")
	public ResponseEntity<List<String>> getFinelResultValues() {

		List<String> list = resultService.getFinelResultValues();
		if (!list.isEmpty()) {

			return new ResponseEntity<List<String>>(list, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("List Not Found For This Url ");

		}

	}

	@GetMapping(value = "/gettopperfromunivercity")
	public ResponseEntity<List<Student>> getTopperInUnivercity() {

		List<Student> topperlist = resultService.getTopperInUnivercity();
		if (!topperlist.isEmpty()) {

			return new ResponseEntity<List<Student>>(topperlist, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("List Not Found For This Url ");

		}
	}

	@GetMapping(value = "/gettopperfromperticularcollege/{collegeName}")
	public ResponseEntity<List<Student>> getFirstRankInCollege(@Valid @PathVariable String collegeName) {

		List<Student> list2 = resultService.getFirstRankInCollege(collegeName);
		if (!list2.isEmpty()) {

			return new ResponseEntity<List<Student>>(list2, HttpStatus.OK);

		} else {

			throw new CollegeCodeNotFoundException("College Not Found For this Name " + collegeName);

		}
	}

	@GetMapping(value = "/gettopperfromuinvercity/branchwise/{branchName}")
	public ResponseEntity<List<Student>> getFirstRankInUnivecityBranchWise(@Valid @PathVariable String branchName) {
		List<Student> list2 = resultService.getFirstRankInUnivecityBranchWise(branchName);

		if (!list2.isEmpty()) {

			return new ResponseEntity<List<Student>>(list2, HttpStatus.OK);

		} else {

			throw new BranchNotFoundException ("Branch Not Found For This Name " + branchName);

		}

	}

	@GetMapping(value = "/gettopperfromcollege/{collegeCode}")
	public ResponseEntity<List<Student>> getFirstRankInCollegebyCollegeCode(@Valid @PathVariable long collegeCode) {

		List<Student> list2 = resultService.getFirstRankInCollegebyCollegeCode(collegeCode);
		if (!list2.isEmpty()) {

			return new ResponseEntity<List<Student>>(list2, HttpStatus.OK);

		} else {

			throw new CollegeCodeNotFoundException("College Not Found For this Code " + collegeCode);

		}
	

	}

	@GetMapping(value = "/gettopperfromuinvercity/branchwise/{branchCode}")
	public ResponseEntity<List<Student>> getFirstRankInUnivecityBranchWiseUsingBranchCode(
			@Valid @PathVariable long branchCode) {

		List<Student> list2 = resultService.getFirstRankInUnivecityBranchWiseUsingBranchCode(branchCode);
		if (!list2.isEmpty()) {

			return new ResponseEntity<List<Student>>(list2, HttpStatus.OK);

		} else {

			throw new BranchNotFoundException ("Branch Not Found For This Code " + branchCode);
			

		}

	}

	@GetMapping(value = "/gettopperfromcollege/{collegeCode}/{branchCode}")
	public ResponseEntity<List<Student>> getFirstRankInCollegeBranchWise(@Valid @PathVariable long collegeCode,
			@Valid @PathVariable long branchCode) {
		List<Student> list = resultService.getFirstRankInCollegeBranchWise(collegeCode, branchCode);
		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("Count Not Found For This Url ");
		}
	}

	@GetMapping(value = "/gettotalcountofstudentresults")
	public ResponseEntity<Long> getTotalCountOfStudentResult() {

		long count = resultService.getTotalCountOfStudentResult();
		if (count > 0) {

			return new ResponseEntity<Long>(count, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("Count Not Found For This Url ");

		}

	}

	@GetMapping(value = "/gettotalavgofstudentresults")
	public ResponseEntity<Double> getAvgOfTotalUnivercityResults() {
		double avg = resultService.getAvgOfTotalUnivercityResults();
		if (avg > 0) {

			return new ResponseEntity<Double>(avg, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("Avg Not Found For This Url ");

		}

	}

	@GetMapping(value = "/gettotalavgofcollegeresults")
	public ResponseEntity<List<Student>> getCollegeAvgResult() {
		List<Student> list = resultService.getCollegeAvgResult();

		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("List Not Found For This Url ");

		}

	}

	@GetMapping(value = "/getavgofunivercitybranchwise")
	public ResponseEntity<List<Student>> getAvgOfUnivercityBranchWise() {
		List<Student> list = resultService.getAvgOfUnivercityBranchWise();
		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("List Not Found For This Url ");

		}

	}
	@GetMapping(value = "/getavgofcollegebranchwise")
	public ResponseEntity<List<Student>>getAvgOfCollegeBranchWise () {
		
		List<Student> list = resultService.getAvgOfCollegeBranchWise();
		
		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("List Not Found For This Url ");

		}
	}
	@GetMapping(value = "/gettotalcountstudentpassandfail")
	public ResponseEntity<String> getTotalCountOfStudentsPassorFail (String result) {
		String count = resultService.getTotalCountOfStudentsPassorFail(result);
		
		if (! count.isEmpty()) {

			return new ResponseEntity<String>(count, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("Count Not Found For This Url ");

		}
		
	}
	@GetMapping(value = "/findabovestudentpercentage/{percentage}")
	public ResponseEntity<List<Student>> findGreterStudentper (@Valid @PathVariable double percentage) {
		List<Student> list = resultService.findGreterStudentper(percentage);
		
		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("List Not Found For This Url ");

		}
	}
	@GetMapping(value = "/findlessthenstudentpercentage/{percentage}")
	public ResponseEntity<List<Student>> findLessStudentPercentageUsingLessThen (@Valid @PathVariable double percentage) {
		List<Student> list = resultService.findLessStudentPercentageUsingLessThen(percentage);
		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("List Not Found For This Url ");

		}
	}
	@GetMapping(value = "/findbetweenpercentage/{percentage}/{percentage1}")
	public ResponseEntity<List<Student>> findBetweenPercentageinUnivercityResults (@PathVariable double percentage , @PathVariable double percentage1){
		
		List<Student> list = resultService.findBetweenPercentageinUnivercityResults(percentage, percentage1);
		
		if (!list.isEmpty()) {

			return new ResponseEntity<List<Student>>(list, HttpStatus.OK);

		} else {

			throw new ListNotFoundException("List Not Found For This Url ");

		}
	}

}
