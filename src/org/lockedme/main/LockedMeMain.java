package org.lockedme.main;

import java.util.List;
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
				mainmenuoption=100;
			}
			
			switch(mainmenuoption) {
			case 1:
				try{
					List<UserFile> userFilesByName = service.getUserFiles();
					System.out.println("The following is the list of files currently in the system (sorted alphabetically)");
					for(UserFile uf: userFilesByName ) {
						System.out.println(uf);
					}
				}catch(UserFileException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				do {
				presentation.secondaryMenu();
				try {
					smenuoption = Integer.parseInt(scanner.nextLine());
					
				} catch (NumberFormatException e) {
					smenuoption = 100;
				}
				
				switch(smenuoption) {
					case 1:
						System.out.println("Enter the file name to be be created");
						System.out.println("A valid filename cannot contain any of these symbols ^*&%#");
						UserFile uf = new UserFile(scanner.nextLine().trim());
						try {
							uf = service.createUserFile(uf);
							System.out.println("File created with name " + uf);
						}catch(UserFileException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 2:
						System.out.println("Enter file name to be deleted");
						UserFile duf = new UserFile(scanner.nextLine().trim());
						try {
							service.deleteUserFile(duf);
							System.out.println("File Successfully Deleted");
							
						}catch(UserFileException e) {
							System.out.println(e.getMessage());
						}
						
						break;
					case 3:
						System.out.println("Enter file name to search");
						UserFile suf = new UserFile(scanner.nextLine().trim());
						
						try {
							service.searchUserFile(suf);
							System.out.println("File exists in the directory");
							
						}catch(UserFileException e) {
							System.out.println(e.getMessage());
						}
						
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
				System.out.println("Exiting the application.....");
				break;
			
			default:
				System.out.println("Entered choice is invalid it should be numbers between 1-3 only");
				break;
			}
			
			
		}while(mainmenuoption != 3);
		
		
	
	}


}
