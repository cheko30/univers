package com.spo.ui.universites;

import org.springframework.beans.factory.annotation.Autowired;

import com.spo.ui.commons.UniversMainUI;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;

@SpringView(name = UniversityLayoutFactory.NAME, ui = UniversMainUI.class)
public class UniversityLayoutFactory extends VerticalLayout implements View, UniversitySavedListener
{
	public static final String NAME = "operations";
	
	private TabSheet tabSheet;
	
	@Autowired
	private AddUniversityLayoutFactory addUniversityFactory;
	
	@Autowired
	private ShowUniversitiesLayoutFactory showUniversitiesLayoutFactory;
	
	@Autowired
	private StatiticsUniversityLayoutFactory statiticsUniversityLayoutFactory;
	
	private void addLayout() 
	{
		setMargin(true);
		
		tabSheet = new TabSheet();
		tabSheet.setWidth("100%");
		
		
		Component addUniversityTab = addUniversityFactory.createComponent(this);
		Component showAllUniversityTab = showUniversitiesLayoutFactory.createComponent();
		Component showStaticsTab = statiticsUniversityLayoutFactory.createComponent();
		
		tabSheet.addTab(addUniversityTab, "ADD UNIVERSITY");
		tabSheet.addTab(showAllUniversityTab, "SHOW ALL UNIVERSITY");
		tabSheet.addTab(showStaticsTab, "STATISTICS");
		
		addComponent(tabSheet);
		
	}	
	
	public void universitySaved() 
	{
		showUniversitiesLayoutFactory.refreshTable();
		statiticsUniversityLayoutFactory.refresh();
	}

	public void enter(ViewChangeEvent event) 
	{
		removeAllComponents();
		addLayout();		
	}

	
}
