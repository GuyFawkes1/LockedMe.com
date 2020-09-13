package org.lockedme.presentation.impl;

import org.lockedme.presentation.LockedMePresentation;

public class LockedMePresentationImpl implements LockedMePresentation  {

	@Override
	public void mainMenu() {
		// TODO Auto-generated method stub
		System.out.println("\n");
		System.out.println("Main Menu - LockedMe.com" );
		System.out.println("==================================");
		System.out.println("Please select one of the following options\n");
		System.out.println("1) List all the files in the directory in ascending order ");
		System.out.println("2) View options to modify the existing directory or search in it");
		System.out.println("3) Close the application");
		
	}

	@Override
	public void secondaryMenu() {
		// TODO Auto-generated method stub
		System.out.println("\n");
		System.out.println("Please select one of the following options");
		System.out.println("1) Add a file");
		System.out.println("2) Delete a file");
		System.out.println("3) Search for a file");
		System.out.println("4) Return to main menu");
		
	}

}
