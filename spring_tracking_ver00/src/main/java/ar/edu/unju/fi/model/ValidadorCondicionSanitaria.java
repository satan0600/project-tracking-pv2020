/**
 * 
 */
package ar.edu.unju.fi.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author daniel-gnu
 *
 */
@Entity
@Component
public class ValidadorCondicionSanitaria {

	// Se asocia a la ID como clave primaria
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column
	private long id;
	@Column
	private boolean usaTapabocas;
	@Column
	private boolean cumpleTerminacionDNI;
	@Column
	private boolean poseePermisoCirculacion;
	@Column
	private boolean estaAcompañado;
	@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_persona")
	private Persona persona;
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_registro")
	private RegistroTracking registroTracking;

//-------------CONSTRUCTORES---------------------
	/**
	 * Constructor sin parametros
	 * 
	 */
	public ValidadorCondicionSanitaria() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor sobrecargado o con parametros
	 * 
	 * @param id
	 * @param usaTapabocas
	 * @param cumpleTerminacionDNI
	 * @param poseePermisoCirculacion
	 * @param estaAcompañado
	 * @param persona
	 * @param registroTracking
	 */
	public ValidadorCondicionSanitaria(long id, boolean usaTapabocas, boolean cumpleTerminacionDNI,
			boolean poseePermisoCirculacion, boolean estaAcompañado, Persona persona,
			RegistroTracking registroTracking) {
		super();
		this.id = id;
		this.usaTapabocas = usaTapabocas;
		this.cumpleTerminacionDNI = cumpleTerminacionDNI;
		this.poseePermisoCirculacion = poseePermisoCirculacion;
		this.estaAcompañado = estaAcompañado;
		this.persona = persona;
		this.registroTracking = registroTracking;

	}

	// -------------METODOS ACCESORES-----------------
	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * @return the usaTapabocas
	 */
	public boolean isUsaTapabocas() {
		return usaTapabocas;
	}

	/**
	 * @param usaTapabocas the usaTapabocas to set
	 */
	public void setUsaTapabocas(boolean usaTapabocas) {
		this.usaTapabocas = usaTapabocas;
	}

	/**
	 * @return the cumpleTerminacionDNI
	 */
	public boolean isCumpleTerminacionDNI() {
		return cumpleTerminacionDNI;
	}

	/**
	 * @param cumpleTerminacionDNI the cumpleTerminacionDNI to set
	 */
	public void setCumpleTerminacionDNI(boolean cumpleTerminacionDNI) {
		this.cumpleTerminacionDNI = cumpleTerminacionDNI;
	}

	/**
	 * @return the estaAcompañado
	 */
	public boolean isEstaAcompañado() {
		return estaAcompañado;
	}

	/**
	 * @param estaAcompañado the estaAcompañado to set
	 */
	public void setEstaAcompañado(boolean estaAcompañado) {
		this.estaAcompañado = estaAcompañado;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	public boolean isPoseePermisoCirculacion() {
		return poseePermisoCirculacion;
	}

	public void setPoseePermisoCirculacion(boolean poseePermisoCirculacion) {
		this.poseePermisoCirculacion = poseePermisoCirculacion;
	}

	public RegistroTracking getRegistroTracking() {
		return registroTracking;
	}

	public void setRegistroTracking(RegistroTracking registroTracking) {
		this.registroTracking = registroTracking;
	}

	@Override
	public String toString() {
		return "ValidadorCondicionSanitaria [id=" + id + ", usaTapabocas=" + usaTapabocas + ", cumpleTerminacionDNI="
				+ cumpleTerminacionDNI + ", poseePermisoCirculacion=" + poseePermisoCirculacion + ", estaAcompañado="
				+ estaAcompañado + ", persona=" + persona + ", registroTracking=" + registroTracking + "]";
	}



}
