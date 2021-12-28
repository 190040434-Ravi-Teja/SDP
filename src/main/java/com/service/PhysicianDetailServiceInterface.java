package com.service;

import org.springframework.ui.Model;

import com.model.Physician;
import com.model.SearchPhysician;

public interface PhysicianDetailServiceInterface {

	void savePhysician(Physician physician);

	boolean checkSearchPhysician(SearchPhysician searchPhysician, Model model);

}
