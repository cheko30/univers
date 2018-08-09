package com.spo.ui.students;

import org.springframework.beans.factory.annotation.Autowired;

import com.spo.ui.commons.UniversMainUI;
import com.spo.utils.StudentsStringUtils;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = StudentLayoutfactory.NAME, ui = UniversMainUI.class)
public class StudentLayoutfactory extends VerticalLayout implements View, StudentSavedListener
{
	public static final String NAME = "addstudent";
	private TabSheet tabSheet;
	
	@Autowired
	private AddStudentMainLayoutfactory mainLayoutFactory;
	
	@Autowired
	private ShowAllStudentsLayoutFactory showStudentsLayoutFactory;
	
		
	private void addLayout()
	{
		setMargin(true);
		
		tabSheet = new TabSheet();
		tabSheet.setWidth("100%");
		
		Component addStudentMainTab = mainLayoutFactory.createComponent(this);
		Component showStudentsTab = showStudentsLayoutFactory.createComponent();
		
		tabSheet.addTab(addStudentMainTab, StudentsStringUtils.MAIN_MENU.getString());
		tabSheet.addTab(showStudentsTab, StudentsStringUtils.SHOW_ALL_STUDENTS.getString());
		
		addComponent(tabSheet);
	}
	
	public void studentSaved() 
	{
		showStudentsLayoutFactory.refreshTable();
		
	}

	public void enter(ViewChangeEvent event) 
	{
		removeAllComponents();
		addLayout();
	}

}