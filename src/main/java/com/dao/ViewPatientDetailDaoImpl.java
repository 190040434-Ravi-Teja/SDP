package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Patient;
import com.model.PatientDiagnosis;

@Repository
public class ViewPatientDetailDaoImpl implements ViewPatientDetailDaoInterface {

	@Autowired
	SessionFactory sessionFactory;

	
	public int checkDiagnosisId(int diagnosisId) {
		String SQL_QUERY = "select * from patientdiagnosisdetail as o where o.diagnosisId=:diagnosisId";
		Query query = sessionFactory.openSession().createSQLQuery(SQL_QUERY);
		query.setParameter("diagnosisId",diagnosisId);
		@SuppressWarnings("unchecked")
		List<Patient> list = query.list();
		if ((list != null) && (list.size() > 0)) {
			return 1;
		} 
		else {
			return 0;
		}
	}

	
	public PatientDiagnosis viewPatientDetail(int diagnosisId) {
		
		PatientDiagnosis patientDiagnosis = (PatientDiagnosis) sessionFactory.openSession().get(PatientDiagnosis.class,diagnosisId);
		return patientDiagnosis;
	}
}
