package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.PhysicianDetailsDaoInterface;
import com.model.Physician;
import com.model.SearchPhysician;

@Service
@Transactional
public class PhysicianDetailServiceImpl implements PhysicianDetailServiceInterface {

	@Autowired
	PhysicianDetailsDaoInterface dao;

	public void savePhysician(Physician physician) {
		 int physicianId = dao.savePhysician(physician);
		if(physicianId < 10) {
			String physicianCustomId="PR00";
			physicianCustomId = physicianCustomId.concat(String.valueOf(physicianId));
			physician.setPhysicianId(physicianId);
			physician.setPhysicianCustomId(physicianCustomId);
			dao.updatePhysicianCustomId(physician);
		}
		else if(physicianId >=10 && physicianId <=99) {
			String physicianCustomId="PR0";
			physicianCustomId = physicianCustomId.concat(String.valueOf(physicianId));
			physician.setPhysicianId(physicianId);
			physician.setPhysicianCustomId(physicianCustomId);
			dao.updatePhysicianCustomId(physician);
		}
		else if(physicianId >=100 && physicianId <=999) {
			String physicianCustomId="PR";
			physicianCustomId = physicianCustomId.concat(String.valueOf(physicianId));
			physician.setPhysicianId(physicianId);
			physician.setPhysicianCustomId(physicianCustomId);
			dao.updatePhysicianCustomId(physician);
		}
		

	}

	public boolean checkSearchPhysician(SearchPhysician searchPhysician, Model model) {
		
		int checkSearchPhysician = dao.checkSearchPhysician(searchPhysician);
		if (checkSearchPhysician == 1) {
			List<Physician> physicians = dao.searchPhysician(searchPhysician);
			
			model.addAttribute("physicians", physicians);
			return true;
		} else {
			return false;
		}

	}

}
