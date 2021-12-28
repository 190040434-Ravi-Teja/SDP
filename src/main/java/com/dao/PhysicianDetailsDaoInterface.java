package com.dao;

import java.util.List;

import com.model.Physician;
import com.model.SearchPhysician;

public interface PhysicianDetailsDaoInterface {

	int savePhysician(Physician physician);

	int checkSearchPhysician(SearchPhysician searchPhysician);

	List<Physician> searchPhysician(SearchPhysician searchPhysician);

	void updatePhysicianCustomId(Physician physician);

}
