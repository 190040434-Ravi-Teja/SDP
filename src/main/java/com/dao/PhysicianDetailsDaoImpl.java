package com.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.model.Physician;
import com.model.SearchPhysician;

@Repository
public class PhysicianDetailsDaoImpl implements PhysicianDetailsDaoInterface {

	@Autowired
	SessionFactory sessionFactory;

	public int savePhysician(Physician physician) {

		sessionFactory.openSession().save(physician);
		return physician.getPhysicianId();
	}

	public int checkSearchPhysician(SearchPhysician searchPhysician) {

		String HQL_QUERY = "from Physician as o where o.department=:department and o.state=:state and o.insurancePlan=:insurancePlan";
		Query query = sessionFactory.openSession().createQuery(HQL_QUERY);
		query.setParameter("department", searchPhysician.getDepartment());
		query.setParameter("state", searchPhysician.getState());
		query.setParameter("insurancePlan", searchPhysician.getInsurancePlan());
		@SuppressWarnings("unchecked")
		List<Physician> list = query.list();
		if ((list != null) && (list.size() > 0)) {
			return 1;
		} else {
			return 0;
		}
	}

	public List<Physician> searchPhysician(SearchPhysician searchPhysician) {

		String HQL_QUERY = "from Physician as o where o.department=:department and o.state=:state and o.insurancePlan=:insurancePlan";
		Query query = sessionFactory.openSession().createQuery(HQL_QUERY);
		query.setParameter("department", searchPhysician.getDepartment());
		query.setParameter("state", searchPhysician.getState());
		query.setParameter("insurancePlan", searchPhysician.getInsurancePlan());
		@SuppressWarnings("unchecked")
		List<Physician> list = query.list();
		if ((list != null) && (list.size() > 0)) {

			return list;
		} else {
			return null;
		}
	}

	
	public void updatePhysicianCustomId(Physician physician) {
		Query query = sessionFactory.openSession().createSQLQuery("update Physicians set physicianCustomId =:physicianCustomId where physicianId=:physicianId");
		query.setParameter("physicianCustomId",physician.getPhysicianCustomId());
		query.setParameter("physicianId",physician.getPhysicianId());
		query.executeUpdate();
		
	}

}
