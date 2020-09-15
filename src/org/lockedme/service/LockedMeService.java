package org.lockedme.service;

import java.util.List;

import org.lockedme.exception.UserFileException;
import org.lockedme.model.UserFile;

public interface LockedMeService {
	
	public UserFile createUserFile( UserFile userfile) throws UserFileException;
	public boolean deleteUserFile(UserFile userfile) throws UserFileException;
	public boolean searchUserFile(UserFile userfile) throws UserFileException;
	public List<UserFile> getUserFiles() throws UserFileException;
	

}
