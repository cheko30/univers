package com.spo.ui.universites;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spo.model.entity.University;
import com.spo.service.showuniversities.ShowAllUniversitiesService;
import com.spo.service.universitystatitics.UniversityStatiticsService;
import com.spo.ui.commons.UIComponentBuilder;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@org.springframework.stereotype.Component
public class StatiticsUniversityLayoutFactory implements UIComponentBuilder 
{
	private List<University> universities;
	private StatiticsUniversityLayout statiticsLayout;
	
	@Autowired
	private UniversityStatiticsService universityStatiticsService;
	
	@Autowired
	private ShowAllUniversitiesService showAllUniversitiesService;
	
	private class StatiticsUniversityLayout extends VerticalLayout
	{

		public StatiticsUniversityLayout load()
		{
			universities = showAllUniversitiesService.getAllUniversities();
		
			return this;
		}
		
		public StatiticsUniversityLayout layout()
		{
			setMargin(true);
			
			for(University university : universities)
			{
				int numOfStudents = universityStatiticsService.getNumOfStudentsForUniversity(university.getId());
				Label label = new Label("<p><b>" + university.getUniversityName() + "</b>" 
										+ "  -  " + numOfStudents + " student(s)" + "</p>", ContentMode.HTML);
				addComponent(label);
			}
		
			return this;
		}		
		
	}
	
	public void refresh() 
	{
		if(statiticsLayout == null) return;
		statiticsLayout.removeAllComponents();
		statiticsLayout.load();
		statiticsLayout.layout();
		
	}

	public Component createComponent() 
	{
		statiticsLayout = new StatiticsUniversityLayout();
		return statiticsLayout.load().layout();
	}

	

}
