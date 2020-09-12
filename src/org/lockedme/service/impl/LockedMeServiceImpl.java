package org.lockedme.service.impl;

import java.util.List;

import org.lockedme.dao.LockedMeDAO;
import org.lockedme.dao.impl.LockedMeDAOImpl;
import org.lockedme.exception.UserFileException;
import org.lockedme.model.UserFile;
import org.lockedme.service.LockedMeService;

public class LockedMeServiceImpl implements LockedMeService {
	
	private LockedMeDAO dao = new LockedMeDAOImpl();

	@Override
	public UserFile createUserFile(UserFile userfile) throws UserFileException {
		
		// Place validation Code
		if(!isValidName(userfile.getName())) {
			throw new UserFileException("Entered Name"+ userfile.getName()+"is invalid");
		}
		return dao.createUserFile(userfile);
	}
	

	
	
	private boolean isValidName(String name) {
		boolean b=false;
		return true;
	}
	
	
	@Override
	public boolean deleteUserFile(UserFile userfile) throws UserFileException {
		return dao.deleteUserFile(userfile);
	}

	
	
	
	
	
	@Override
	public List<UserFile> getUserFiles() throws UserFileException {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public boolean searchUserFile(UserFile userfile) throws UserFileException {
		
		
		return dao.searchUserFile(userfile);
	}
	
	

}
