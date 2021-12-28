package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Patient;
import com.model.PatientDiagnosis;

@Repository
public class PatientDiagnosisDaoImpl implements PatientDiagnosisDaoInterface {

	@Autowired
	SessionFactory sessionFactory;

	public void addPatientDiagnosis(PatientDiagnosis patientDiagnosis) {
		sessionFactory.openSession().save(patientDiagnosis);

	}

	public int checkPatientId(PatientDiagnosis patientDiagnosis) {

		String HQL_QUERY = "from Patient as o where o.patientId=:patientId";
		Query query = sessionFactory.openSession().createQuery(HQL_QUERY);
		query.setParameter("patientId",
				(patientDiagnosis.getPatientId() != null ? patientDiagnosis.getPatientId().intValue() : 0));
		@SuppressWarnings("unchecked")
		List<Patient> list = query.list();
		if ((list != null) && (list.size() > 0)) {
			return 1;
		} else {
			return 0;
		}
	}

}
