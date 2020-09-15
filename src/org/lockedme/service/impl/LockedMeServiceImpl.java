package org.lockedme.service.impl;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

import org.lockedme.dao.LockedMeDAO;
import org.lockedme.dao.impl.LockedMeDAOImpl;
import org.lockedme.exception.UserFileException;
import org.lockedme.model.UserFile;
import org.lockedme.service.LockedMeService;

public class LockedMeServiceImpl implements LockedMeService {
	
	private LockedMeDAO dao = new LockedMeDAOImpl();

	@Override
	public UserFile createUserFile(UserFile userfile) throws UserFileException {
		
		if(!isValidName(userfile.getName())) {
			throw new UserFileException("Entered Name"+ userfile.getName()+"is invalid");
		}
		return dao.createUserFile(userfile);
	}
	
	
	private boolean isValidName(String name) {
		String regex = "^[^*&%#]+$";
		boolean b=false;
		if(name.matches(regex)) {
			b=true;
		}
		return b;
	}
	
	
	@Override
	public boolean deleteUserFile(UserFile userfile) throws UserFileException {
		return dao.deleteUserFile(userfile);
	}
	
	
	@Override
	public List<UserFile> getUserFiles() throws UserFileException {
		// TODO Auto-generated method stub
		List<UserFile> userFilesByName = dao.getUserFilesByName();
		Collections.sort(userFilesByName, new SortByName());
		
		return userFilesByName;
	}




	@Override
	public boolean searchUserFile(UserFile userfile) throws UserFileException {
		
		
		return dao.searchUserFile(userfile);
	}
}


class SortByName implements Comparator<UserFile>{

	private static final Locale LOCALE = Locale.US;
	
	@Override
	public int compare(UserFile arg0, UserFile arg1) {
		// TODO Auto-generated method stub
		Collator collater = Collator.getInstance(LOCALE);	
		return -1*collater.compare(arg1.name, arg0.name);
	}
	
	
	
	
}
