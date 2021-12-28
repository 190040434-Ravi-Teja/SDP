package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Patient;
import com.model.PatientDiagnosis;
import com.model.PatientHistory;

@Repository
public class ViewPatientHistorDaoImpl implements ViewPatientHistoryDaoInterface {

	@Autowired
	SessionFactory sessionFactory;
	
	public int checkPatientId(PatientHistory patientHistory) {
		
		String SQL_QUERY = "select * from patient_details as o where o.patientId=:patientId and o.firstName=:firstName and o.lastName=:lastName";
		Query query = sessionFactory.openSession().createSQLQuery(SQL_QUERY);
		query.setParameter("patientId",(patientHistory.getPatientId() != null ? patientHistory.getPatientId().intValue() : 0));
		query.setParameter("firstName",patientHistory.getFirstName());
		query.setParameter("lastName",patientHistory.getLastName());
		@SuppressWarnings("unchecked")
		List<Patient> list = query.list();
		if ((list != null) && (list.size() > 0)) {
			return 1;
		} 
		else {
			return 0;
		}
		
	}

	
	public List<PatientDiagnosis> viewPatientHistory(PatientHistory patientHistory) {
		String HQL_QUERY = "from PatientDiagnosis as o where o.patientId=:patientId";
		Query query = sessionFactory.openSession().createQuery(HQL_QUERY);
		query.setParameter("patientId",patientHistory.getPatientId());
		@SuppressWarnings("unchecked")
		List<PatientDiagnosis> list = query.list();
		if ((list != null) && (list.size() > 0)) {
			return list;
		} 
		else {
			return null;
		}
		
	}

}
