package ada.hibernatprueba.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import ada.hibernateprueba.HibernateUtil;
import ada.hibernateprueba.dto.PersonaEntity;


public class PersonaDao {
	
	public void insertPersonaDao(PersonaEntity per) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(per);
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}
	
	@SuppressWarnings("unchecked")
	public List<PersonaEntity> getAllPersona() {
		Session sesn = HibernateUtil.getSessionFactory().openSession();
		List<PersonaEntity> person = new ArrayList<PersonaEntity>();
		try {
			person = sesn.createQuery("From PersonaEntity").list();
			for (PersonaEntity per : person) {
				System.out.println(per.getnombre() + " " + per.getedad() + "" + per.getfecha_nacimineto());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sesn.close();
		}

		HibernateUtil.shutdown();
		return person;
	}


}
