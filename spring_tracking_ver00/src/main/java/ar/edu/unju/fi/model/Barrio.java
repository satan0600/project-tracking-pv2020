/**
 * 
 */
package ar.edu.unju.fi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

/**
 * @author daniel-gnu
 *
 */
@Entity
@Component
public class Barrio implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	@Column
	private String Nombre;
	@OneToMany(fetch = FetchType.EAGER)
	private List<RegistroTracking> registros;

	/**
	 * @param id
	 * @param nombre
	 */

	public Barrio(Long id, String nombre) {
		super();
		this.id = id;
		Nombre = nombre;
	}

	/**
	 * 
	 */
	public Barrio() {
		super();
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return Nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	@Override
	public String toString() {
		return "Barrio [id=" + id + ", Nombre=" + Nombre + "]";
	}

}
