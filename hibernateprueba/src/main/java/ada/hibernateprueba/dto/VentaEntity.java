package ada.hibernateprueba.dto;




import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "venta", uniqueConstraints = {
		//solo para colocar los que son unicos
		@UniqueConstraint(columnNames = "ID"),})
public class VentaEntity implements Serializable {
	
	private static final long serialVersionUID = -1798070786993154676L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer ventaId;
	
	@Column(name = "FECHA", unique = true, nullable = false, length = 100)
	private String fechaventa;
	
	@Column(name = "IMPORTE", unique = false, nullable = false, length = 100)
	private Float  importe;
	
	@ManyToOne
	@JoinColumn(name = "ID_PERSONA", unique = false, nullable = false)
	private PersonaEntity personaEntity;

	
	public Integer getVentaId() {
		return ventaId;
	}

	public void setVentaId(Integer ventaId) {
		this.ventaId = ventaId;
	}

	public String getFechaventa() {
		return fechaventa;
	}

	public void setFechaventa(String fecha) {
		this.fechaventa = fecha;
	}

	public Float getImporte() {
		return importe;
	}

	public void setImporte(Float importe) {
		this.importe = importe;
	}

	public PersonaEntity getPersonaEntity() {
		return personaEntity;
	}

	public void setPersonaEntity(PersonaEntity personaEntity) {
		this.personaEntity = personaEntity;
	}



}
