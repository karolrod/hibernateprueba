package ada.hibernateprueba;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import org.hibernate.Session;

import ada.hibernateprueba.dto.PersonaEntity;
import ada.hibernateprueba.dto.VentaEntity;
import ada.hibernatprueba.dao.PersonaDao;
import ada.hibernatprueba.dao.VentaDao;

@SuppressWarnings("unused")
public class TestHibernate {

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Scanner sc = new Scanner(System.in);
		int opcion = mostrarMenu(sc);
		while (opcion != 0) {

			switch (opcion) {
			case 1:
				alta(sc);
				break;
			case 2:
				modificacion(sc);
				break;
			case 3:
				baja(sc);
				break;
			case 4:
				listado();
				break;
			case 5:
				venta(sc);
				break;
			case 6:
				listadoventa();
				break;

			case 0:

				break;

			default:
				break;
			}
			opcion = mostrarMenu(sc);
		}

	}

	private static void alta(Scanner sc) {

		PersonaEntity per = new PersonaEntity();

		System.out.println("Ingrese nombre:");
		String nombre = sc.next();
		per.setNombre(nombre);
		System.out.println("Ingrese Fecha de Nacimiento en Formato YYYY-MM-DD");
		String fNac = sc.next();
		per.setFecha_nacimiento(fNac);

		SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
		int edad = 0;
		try {
			Date fechaNac = sfd.parse(fNac);
			edad = calcularEdad(fechaNac);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		per.setEdad(edad);

		PersonaDao per1 = new PersonaDao();
		per1.insertPersonaDao(per);
		System.out.println(" Persona Registrada con exito ");
	}

	private static void modificacion(Scanner sc) {
		PersonaDao per1 = new PersonaDao();
		System.out.println("Ingrese id a modificar ");
		int PersonaId = sc.nextInt();
		PersonaEntity per = per1.getPersona(PersonaId);
		if (per == null) {
			System.out.println("El ID no existe ingrese un nuevo ID");
			modificacion(sc);
		} else {

			System.out.println("Seleccione columnas a modificar 1. Nombre, 2. Fecha_Nacimiento ");
			int opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Ingrese nuevo nombre:");
				String nombremod = sc.next();
				per.setNombre(nombremod);
				per1.updatePersonaDao(per);
				System.out.println("El nombre se ha modificado ");
				break;
			case 2:
				System.out.println("Ingrese Fecha de Nacimiento en Formato YYYY-MM-DD");
				String fNac = sc.next();
				per.setFecha_nacimiento(fNac);

				SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
				int edad = 0;
				try {
					Date fechaNac = sfd.parse(fNac);
					edad = calcularEdad(fechaNac);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

				per.setEdad(edad);

				PersonaDao per2 = new PersonaDao();
				per2.updatePersonaDao(per);
				System.out.println(" Fecha de nacimiento modificada ");
				break;
			default:
				break;
			}

		}
	}

	private static void baja(Scanner sc) {
		PersonaDao per1 = new PersonaDao();
		System.out.println("Ingrese id a eliminar ");
		int PersonaId = sc.nextInt();
		PersonaEntity per = per1.getPersona(PersonaId);
		if (per == null) {
			System.out.println("El ID no existe ingrese un nuevo ID");
			baja(sc);
		} else {
			per1.deletePersonaDao(per);
			System.out.println("Registro Eliminado");
		}
	}

	private static void listado() {

		PersonaDao per1 = new PersonaDao();
		per1.getAllPersona();
	}

	private static int calcularEdad(Date fechaNac) {
		GregorianCalendar gc = new GregorianCalendar();
		GregorianCalendar hoy = new GregorianCalendar();
		gc.setTime(fechaNac);
		int anioActual = hoy.get(Calendar.YEAR);
		int anioNacim = gc.get(Calendar.YEAR);

		int mesActual = hoy.get(Calendar.MONTH);
		int mesNacim = gc.get(Calendar.MONTH);

		int diaActual = hoy.get(Calendar.DATE);
		int diaNacim = gc.get(Calendar.DATE);

		int dif = anioActual - anioNacim;

		if (mesActual < mesNacim) {
			dif = dif - 1;
		} else {
			if (mesActual == mesNacim && diaActual < diaNacim) {
				dif = dif - 1;
			}
		}

		return dif;
	}

	private static void venta(Scanner sc) {

		VentaEntity ven = new VentaEntity();
		PersonaDao per1 = new PersonaDao();
		System.out.println("Ingrese id para registrar la venta ");
		int PersonaId = sc.nextInt();
		PersonaEntity per = per1.getPersona(PersonaId);
		ven.setPersonaEntity(per);
		if (per == null) {
			System.out.println("El ID no existe ingrese un nuevo ID");
			venta(sc);
		} else {
			
			System.out.println("Ingrese importe de la venta ");
			Float importe = sc.nextFloat();
			ven.setImporte(importe);

			SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date fecha = new Date();
			String fechaN = ft.format(fecha);
			ven.setFechaventa(fechaN);

		}

		VentaDao ven1 = new VentaDao();
		ven1.insertVentaDao(ven);
		System.out.println(" Venta Registrada ");

	}

	private static void listadoventa() {

		VentaDao ven1 = new VentaDao();
		ven1.getAllVenta();
	}

	
	
	private static int mostrarMenu(Scanner sc) {

		System.out.println("SISTEMA DE PERSONAS (ABM)");
		System.out.println("=========================");

		System.out.println("");
		System.out.println("MENU OPCIONES: ");
		System.out.println("");
		System.out.println("1: ALTA ");
		System.out.println("2: MODIFICACION ");
		System.out.println("3: BAJA");
		System.out.println("4: LISTADO");
		System.out.println("5: VENTAS");
		System.out.println("6. LISTADO DE VENTAS ");
		System.out.println("0: SALIR");
		int opcion = 0;
		opcion = sc.nextInt();
		return opcion;
	}

}
