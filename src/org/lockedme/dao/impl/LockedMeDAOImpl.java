package org.lockedme.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.lockedme.dao.LockedMeDAO;
import org.lockedme.exception.UserFileException;
import org.lockedme.model.UserFile;

public class LockedMeDAOImpl implements LockedMeDAO {
	
	private static Set<UserFile> userFileSet = new HashSet<>();
	private static int count;
	@Override
	public UserFile createUserFile(UserFile userfile) throws UserFileException {
		userFileSet.add(userfile);
		return userfile;
	}
	@Override
	public UserFile[] getUserFilesByName() throws UserFileException {
		return (UserFile[]) userFileSet.toArray(); 	
	}
	
	
	
	

}
