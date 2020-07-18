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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

/**
 * @author daniel-gnu
 *
 */
@Entity
@Component
public class Usuario implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	@Column
	@NotBlank
	private String nombreU;
	@Column
	@NotBlank
	private String password;
	@Column
	@NotBlank
	private String nombreR;
	@Column
	@NotBlank
	private String apellidoR;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable( name = "usuario_roles", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private List<Rol> roles;

	/**
	 * @param id
	 * @param nombreU
	 * @param password
	 * @param nombreR
	 * @param apellidoR
	 * @param roles
	 */
	public Usuario(Long id, String nombreU, String password, String nombreR, String apellidoR, List<Rol> roles) {
		super();
		this.id = id;
		this.nombreU = nombreU;
		this.password = password;
		this.nombreR = nombreR;
		this.apellidoR = apellidoR;
		this.roles = roles;
	}

	/**
	 * 
	 */
	public Usuario() {
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
	 * @return the nombreU
	 */
	public String getNombreU() {
		return nombreU;
	}

	/**
	 * @param nombreU the nombreU to set
	 */
	public void setNombreU(String nombreU) {
		this.nombreU = nombreU;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the nombreR
	 */
	public String getNombreR() {
		return nombreR;
	}

	/**
	 * @param nombreR the nombreR to set
	 */
	public void setNombreR(String nombreR) {
		this.nombreR = nombreR;
	}

	/**
	 * @return the apellidoR
	 */
	public String getApellidoR() {
		return apellidoR;
	}

	/**
	 * @param apellidoR the apellidoR to set
	 */
	public void setApellidoR(String apellidoR) {
		this.apellidoR = apellidoR;
	}

	/**
	 * @return the roles
	 */
	public List<Rol> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombreU=" + nombreU + ", password=" + password + ", nombreR=" + nombreR
				+ ", apellidoR=" + apellidoR + ", roles=" + roles + "]";
	}

}
