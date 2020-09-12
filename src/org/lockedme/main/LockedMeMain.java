package org.lockedme.main;

import java.util.Scanner;

import org.lockedme.exception.UserFileException;
import org.lockedme.model.UserFile;
import org.lockedme.presentation.LockedMePresentation;
import org.lockedme.presentation.impl.LockedMePresentationImpl;
import org.lockedme.service.LockedMeService;
import org.lockedme.service.impl.LockedMeServiceImpl;

public class LockedMeMain {
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to LockedMe.com");
		System.out.println("----------------------------------");
		System.out.println("Developed by K Isaac Prasanth");
		Scanner scanner = new Scanner(System.in);
		LockedMeService service = new LockedMeServiceImpl();
		LockedMePresentation presentation = new LockedMePresentationImpl();

		int mainmenuoption=0,smenuoption=0;
		do {
			presentation.mainMenu();
			try {
				mainmenuoption = Integer.parseInt(scanner.nextLine());
			} catch (NumberFormatException e) {
				//System.out.println("I detected error");
			}
			
			switch(mainmenuoption) {
			case 1:
				System.out.println("Thank you for your interest,this option is underconstruction");
				break;
			case 2:
				do {
				presentation.secondaryMenu();
				try {
					smenuoption = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
				}
				
				switch(smenuoption) {
					case 1:
						System.out.println("Enter the file name to be be created");
						UserFile uf = new UserFile(scanner.nextLine());
						try {
							uf = service.createUserFile(uf);
							System.out.println("File created with details " + uf);
						}catch(UserFileException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 2:
						System.out.println("Thank you for your interest,this option is underconstruction");
						break;
					case 3:
						System.out.println("Thank you for your interest,this option is underconstruction");
						break;
					case 4:
						System.out.println("You will be redirected to the main menu.......");
						break;
					default:
						System.out.println("Entered choice is invalid it should be numbers between 1-4 only");
						break;
				}
				
				}while(smenuoption!=4);
				break;
			case 3:
				System.out.println("Thank you for using LockedMe.com prototype");
				break;
			
			default:
				System.out.println("Entered choice is invalid it should be numbers between 1-3 only");
				break;
			}
			
			
		}while(mainmenuoption != 3);
		
		
//		UserFile us = new UserFile("Test");
//		
//		
//		
//		try {
//			UserFile returned = service.createUserFile(us);
//			System.out.println(returned);
//		} catch (UserFileException e) {
//			System.out.println(e.getMessage());
//		}
//			
		
	}


}
