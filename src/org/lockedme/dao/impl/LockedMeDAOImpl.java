package org.lockedme.dao.impl;

import java.util.HashSet;
import java.util.Set;

import org.lockedme.dao.LockedMeDAO;
import org.lockedme.exception.UserFileException;
import org.lockedme.model.UserFile;

public class LockedMeDAOImpl implements LockedMeDAO {
	
	private static Set<UserFile> userFileSet = new HashSet<>();
	@Override
	public UserFile createUserFile(UserFile userfile) throws UserFileException {
		userFileSet.add(userfile);
		return userfile;
	}
	@Override
	public UserFile[] getUserFilesByName() throws UserFileException {
		return (UserFile[]) userFileSet.toArray(); 	
	}
	@Override
	public boolean deleteUserFile(UserFile userfile) throws UserFileException {
		
//		boolean flag = userFileSet.remove(userfile);
//		System.out.println(userFileSet.size());
//		for (UerFile s : userFileSet) {
//		    System.out.println(s);
//		}
//		return flag;
		return userFileSet.remove(userfile);
	}
	
	
	
	

}
