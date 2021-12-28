package com.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dao.AdministratorLoginDaoInterface;
import com.model.Administrator;

@Service
@Transactional
public class AdministratorLoginServiceImpl implements AdministratorLoginServiceInterface {

	@Autowired
	AdministratorLoginDaoInterface dao;
	
	
	public boolean checkCredential(Administrator administrator) {
		int checkUsernamePasswordExist = dao.checkCredential(administrator);
		 if(checkUsernamePasswordExist == 1) {
			 return true;
		 }
		 
		 else {
			 return false;
		 }
	 }
		
}

