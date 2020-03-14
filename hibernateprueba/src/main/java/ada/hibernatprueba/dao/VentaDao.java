package ada.hibernatprueba.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import ada.hibernateprueba.HibernateUtil;
import ada.hibernateprueba.dto.PersonaEntity;
import ada.hibernateprueba.dto.VentaEntity;

public class VentaDao {

	public void insertVentaDao(VentaEntity ven) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(ven);
		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}
	
	@SuppressWarnings("unchecked")
	public List<VentaEntity> getAllVenta() {
		Session sesn = HibernateUtil.getSessionFactory().openSession();
		List<VentaEntity> vent = new ArrayList<VentaEntity>();
		try {
			vent = sesn.createQuery("From VentaEntity").list();
			System.out.println("ID_Venta|         Fecha|        Importe |  ID_Persona");
			
			for (VentaEntity ven : vent) {
				PersonaEntity idventa = ven.getPersonaEntity();
				int id = idventa.getpersonaId();
		
				System.out.println("   " + ven.getVentaId()  + "       " + ven.getFechaventa() + "    " + ven.getImporte() + "       " +  id );
			}
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			sesn.close();
		}

		HibernateUtil.shutdown();
		return vent;
	}

	
	
}
