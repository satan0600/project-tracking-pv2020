/**
 * 
 */
package ar.edu.unju.fi.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Persona implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column
	private long id;

	@Column
	private String documento;

	@Column
	private String apellido;

	@Column
	private String nombres;

	@Column
	private String nacionalidad;
	@Autowired
	@OneToOne(mappedBy = "persona")
	private ValidadorCondicionSanitaria validador;

//---------------CONSTRUCTORES----------------------

	/**
	 * 
	 */
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param documento
	 * @param apellido
	 * @param nombres
	 * @param nacionalidad
	 * @param validador
	 */
	public Persona(long id, String documento, String apellido, String nombres, String nacionalidad,
			ValidadorCondicionSanitaria validador) {
		super();
		this.id = id;
		this.documento = documento;
		this.apellido = apellido;
		this.nombres = nombres;
		this.nacionalidad = nacionalidad;
		this.validador = validador;
	}

	// -----------METODOS ACCESORES----------------------

	/**
	 * @return the documento
	 */
	public String getDocumento() {
		return documento;
	}

	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return the nacionalidad
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}

	/**
	 * @param nacionalidad the nacionalidad to set
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the validador
	 */
	public ValidadorCondicionSanitaria getValidador() {
		return validador;
	}

	/**
	 * @param validador the validador to set
	 */
	public void setValidador(ValidadorCondicionSanitaria validador) {
		this.validador = validador;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", documento=" + documento + ", apellido=" + apellido + ", nombres=" + nombres
				+ ", nacionalidad=" + nacionalidad + ", validador=" + validador + "]";
	}

}



