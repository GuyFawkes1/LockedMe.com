package org.lockedme.dao;

import java.util.List;

import org.lockedme.exception.UserFileException;
import org.lockedme.model.UserFile;


public interface LockedMeDAO {
	public UserFile createUserFile(UserFile userfile) throws UserFileException;
	public boolean deleteUserFile(UserFile userfile) throws UserFileException;
	
	public List<UserFile> getUserFilesByName() throws UserFileException;
	
	public boolean searchUserFile(UserFile userfile) throws UserFileException;
	
}
