package org.lockedme.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.lockedme.dao.LockedMeDAO;
import org.lockedme.exception.UserFileException;
import org.lockedme.model.UserFile;

public class LockedMeDAOImpl implements LockedMeDAO {
	
	private static Set<UserFile> userFileSet = new HashSet<>();
	@Override
	public UserFile createUserFile(UserFile userfile) throws UserFileException {
		if(userFileSet.contains(userfile)) {
			throw new UserFileException("File with the same name already exists. Please use a different name");
		}
		userFileSet.add(userfile);
		return userfile;
	}
	@Override
	public List<UserFile> getUserFilesByName() throws UserFileException {
		
		if (userFileSet.size()==0) throw new UserFileException("Currently there are no files in the directory. You will see them here, when you add some");
		List<UserFile> listOfUserFiles = new ArrayList<>();
	
		for(UserFile uf: userFileSet) {
			listOfUserFiles.add(uf);
		}
		
		return listOfUserFiles; 	
	}
	@Override
	public boolean deleteUserFile(UserFile userfile) throws UserFileException {
		

		if(userFileSet.remove(userfile)) {
			return true;
		}else {
			throw new UserFileException("No File with name - "+userfile.name+" exists in the directory");
		}
	}
	
	public boolean searchUserFile(UserFile userfile) throws UserFileException{
		
		if(userFileSet.contains(userfile)) {
			return true;
		}else {
			throw new UserFileException("No File with name - "+userfile.name+" exists in the directory");
		}
	}
	
	
	

}
