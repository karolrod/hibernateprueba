package ada.hibernateprueba.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "Persona", uniqueConstraints = {
		@UniqueConstraint(columnNames = "ID"),
		@UniqueConstraint(columnNames = "NOMBRE"),
		@UniqueConstraint(columnNames = "EDAD"),
		@UniqueConstraint(columnNames = "FECHA_NACIMIENTO")})
public class PersonaEntity implements Serializable {
	
	private static final long serialVersionUID = -1798070786993154676L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer personaId;
	
	@Column(name = "nombre", unique = true, nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "EDAD", unique = false, nullable = false, length = 100)
	private String edad;
	
	@Column(name = "FECHA_NACIMIENTO", unique = false, nullable = false, length = 100)
	private String fecha_nacimiento;

	public Integer getpersonaId() {
		return personaId;
	}

	public void setPersonaId(Integer personaId) {
		this.personaId = personaId;
	}

	public String getnombre() {
		return nombre;
	}

	public void setnombre(String nombre) {
		this.nombre = nombre;
	}

	public String getedad() {
		return edad;
	}

	public void setedad(String edad) {
		this.edad = edad;
	}

	public String getfecha_nacimineto() {
		return fecha_nacimiento;
	}

	public void setfecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
}
