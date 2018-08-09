package com.spo.ui.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spo.service.security.RegiterUserService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.themes.ValoTheme;

@Component
public class SignupFromFactory
{
	@Autowired
	private RegiterUserService registerUserService;
	
	private class SignupFrom
	{
		private VerticalLayout root;
		private Panel panel;
		private TextField username;
		private PasswordField passwordField;
		private PasswordField passwordLoginField;
		private Button saveButton;
		
		public SignupFrom init() 
		{
			root = new VerticalLayout();
			root.setMargin(true);
			root.setHeight("100%");
			
			panel = new Panel("Signup");
			panel.setSizeUndefined();
			
			saveButton = new Button("Save");
			saveButton.setStyleName(ValoTheme.BUTTON_FRIENDLY);
			
			username = new TextField("Username");
			passwordField = new PasswordField("Password");
			passwordLoginField = new PasswordField("Password again");
			
			saveButton.addClickListener(new ClickListener() {
				
				public void buttonClick(ClickEvent event) 
				{
					if(!passwordLoginField.getValue().equals(passwordField.getValue()))
					{
						Notification.show("Error", "Password do not match", Type.ERROR_MESSAGE);
						return;
					}
					registerUserService.save(username.getValue(), passwordField.getValue());
					UI.getCurrent().getPage().setLocation("/univers-web/login");
				}
			});
			
			return this;
		}
		
		
		public com.vaadin.ui.Component layout()
		{
			root.addComponent(panel);
			root.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
			
			FormLayout signLayout = new FormLayout();
			signLayout.addComponent(username);
			signLayout.addComponent(passwordField);
			signLayout.addComponent(passwordLoginField);
			
			signLayout.addComponent(saveButton);
			signLayout.setSizeUndefined();
			signLayout.setMargin(true);
			
			panel.setContent(signLayout);
			
			return root;
		}
		
	}
	
	public com.vaadin.ui.Component createComponent()
	{
		return new SignupFrom().init().layout();
	}

}
