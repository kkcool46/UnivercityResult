package com.jbk.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResultAlredyExistsException.class)
	public ResponseEntity<String> resultAlredyExistsException(ResultAlredyExistsException ex) {

		String message = ex.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}
	
	@ExceptionHandler(ResultNotFoundForThisPrn.class)
	public ResponseEntity<String> resultNotFoundForThisPrn (ResultNotFoundForThisPrn ex1) {

		String message = ex1.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}
	
	@ExceptionHandler(ListNotFoundException.class)
	public ResponseEntity<String> listNotFoundException (ListNotFoundException ex1) {

		String message = ex1.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}
	@ExceptionHandler(ResultNotFoundThisSeatNo .class)
	public ResponseEntity<String> resultNotFoundThisSeatNo  (ResultNotFoundThisSeatNo  ex2) {

		String message = ex2.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}
	@ExceptionHandler(CollegeCodeNotFoundException .class)
	public ResponseEntity<String> collegeCodeNotFoundException  (CollegeCodeNotFoundException  ex3) {

		String message = ex3.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}
	@ExceptionHandler(BranchNotFoundException .class)
	public ResponseEntity<String> branchNotFoundException  (BranchNotFoundException ex3) {

		String message = ex3.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}
	

}
