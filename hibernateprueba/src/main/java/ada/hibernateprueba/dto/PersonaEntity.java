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
		//solo para colocar los que son unicos
		@UniqueConstraint(columnNames = "ID"),})
public class PersonaEntity implements Serializable {
	
	private static final long serialVersionUID = -1798070786993154676L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer personaId;
	
	@Column(name = "NOMBRE", unique = true, nullable = false, length = 100)
	private String nombre;
	
	@Column(name = "EDAD", unique = false, nullable = false, length = 100)
	private Integer edad;
	
	@Column(name = "FECHA_NACIMIENTO", unique = false, nullable = false, length = 100)
	private String fecha_nacimiento;

	public Integer getpersonaId() {
		return personaId;
	}

	public void setPersonaId(Integer personaId) {
		this.personaId = personaId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
}
