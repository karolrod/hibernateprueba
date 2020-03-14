package ada.hibernatprueba.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
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
	
	
	public void updatePersonaDao(PersonaEntity per) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(per);
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}
	
	
	public void deletePersonaDao(PersonaEntity per) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.delete(per);
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}
	
	@SuppressWarnings("unchecked")
	
	
	public List<PersonaEntity> getAllPersona() {
		Session sesn = HibernateUtil.getSessionFactory().openSession();
		List<PersonaEntity> person = new ArrayList<PersonaEntity>();
		try {
			person = sesn.createQuery("From PersonaEntity").list();
			
			System.out.println("Id Persona|      Nombre|     Edad|     Fecha de Nacimiento| ");
			for (PersonaEntity per : person) {
				System.out.println("   " + per.getpersonaId() +   "             " + per.getNombre() + "        "  + per.getEdad() + "        " + per.getFecha_nacimiento());
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sesn.close();
		}

		HibernateUtil.shutdown();
		return person;
	}

	public PersonaEntity getPersona(int Id) {
		Session sesn = HibernateUtil.getSessionFactory().openSession();
		Query query = sesn.createQuery("From PersonaEntity where personaId = " + Id  );
		PersonaEntity person = (PersonaEntity) query.uniqueResult();
		HibernateUtil.shutdown();
		return person;
	}


}
