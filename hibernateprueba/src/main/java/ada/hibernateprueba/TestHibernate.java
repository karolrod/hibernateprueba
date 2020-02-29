package ada.hibernateprueba;


import org.hibernate.Session;

import ada.hibernateprueba.dto.PersonaEntity;

public class TestHibernate {
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
       
		//Add new Employee object
		PersonaEntity per = new PersonaEntity();
		per.setnombre("cindy");
		per.setedad("42");
		per.setfecha_nacimiento("1978-09-12");
		
		session.save(per);
		
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}

}
