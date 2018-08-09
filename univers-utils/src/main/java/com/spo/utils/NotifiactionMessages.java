package com.spo.utils;

public enum NotifiactionMessages
{
	STUDENT_SAVE_VALIDATION_ERROR_TITLE("ERROR"),
	STUDENT_SAVE_VALIDATION_ERROR_DESCRIPTION("Fields must be filled!"),
	
	STUDENT_SAVE_SUCCESS_TITLE("SAVE"),
	STUDENT_SAVE_SUCCESS_DESCRIPTION("Student has been saved"), 
	
	STUDENT_REMOVE_BUTTON("Remove"), 
	STUDENT_REMOVE_SUCCESS_TITLE("REMOVE"), 
	STUDENT_REMOVE_SUCCESS_DESCRIPTION("Students(s) successfully remove"), 
	
	UNIVERSITY_SAVED_VALIDATION_ERROR_TITLE("ERROR"), 
	UNIVERSITY_SAVED_VALIDATION_ERROR_DESCRIPTION("Field must be filled"),
	
	UNIVERSITY_SAVE_SUCCESS_TITLE("SAVE"),
	UNIVERSITY_SAVE_SUCCESS_DESCRIPTION("University saved successfully"), 
	STUDENT_SAVE_INVALID_TITLE("ERROR"), 
	STUDENT_SAVE_INVALID_DESCRIPTION("Must have at least one university")
	
	;
	
	private String string;
	
	private NotifiactionMessages(String string)
	{
		this.string = string;
		
	}
	
	public String getString()
	{
		return this.string;
	}
}
