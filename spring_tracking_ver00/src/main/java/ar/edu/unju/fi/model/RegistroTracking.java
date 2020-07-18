/**
 * 
 */
package ar.edu.unju.fi.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author daniel-gnu
 *
 */
@Entity
@Component
public class RegistroTracking implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		// Se asocia a la ID como clave primaria
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
		@GenericGenerator(name = "native", strategy = "native")
		private long id;
		@Column
		private LocalDateTime fechaHora; // fecha de registro tracking
		@Autowired
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn
		private Barrio localidad; // localidad de registro tracking
		// @Column(name = "VALIDADORES")
		@OneToMany(mappedBy = "registroTracking", cascade = CascadeType.ALL)
		private List<ValidadorCondicionSanitaria> validadoresCS = new ArrayList<ValidadorCondicionSanitaria>();																		// condicion
		@Column
		private String detalleLugarRegistro;// detalle de registro tracking

	//---------CONSTRUCTORES----------------------------
		/**
		 * 
		 */

		public RegistroTracking() {
			// TODO Auto-generated constructor stub
		}

		/**
		 * @param id
		 * @param fechaHora
		 * @param localidad
		 * @param validadoresCS
		 * @param detalleLugarRegistro
		 */
		public RegistroTracking(long id, LocalDateTime fechaHora, Barrio localidad,
				List<ValidadorCondicionSanitaria> validadoresCS, String detalleLugarRegistro) {
			super();
			this.id = id;
			this.fechaHora = fechaHora;
			this.localidad = localidad;
			this.validadoresCS = validadoresCS;
			this.detalleLugarRegistro = detalleLugarRegistro;
		}

		// -------------METODOS ACCESORES---------------------------
		/**
		 * @return the fechaHora
		 */
		public LocalDateTime getFechaHora() {
			return fechaHora;
		}

		/**
		 * @param fechaHora the fechaHora to set
		 */
		public void setFechaHora(LocalDateTime fechaHora) {
			this.fechaHora = fechaHora;
		}

		/**
		 * @return the localidad
		 */
		public Barrio getLocalidad() {
			return localidad;
		}

		/**
		 * @param localidad the localidad to set
		 */
		public void setLocalidad(Barrio localidad) {
			this.localidad = localidad;
		}

		/**
		 * @return the detalleLugarRegistro
		 */
		public String getDetalleLugarRegistro() {
			return detalleLugarRegistro;
		}

		/**
		 * @param detalleLugarRegistro the detalleLugarRegistro to set
		 */
		public void setDetalleLugarRegistro(String detalleLugarRegistro) {
			this.detalleLugarRegistro = detalleLugarRegistro;
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

		/**
		 * @return the validadoresCS
		 */
		public List<ValidadorCondicionSanitaria> getValidadoresCS() {
			return validadoresCS;
		}

		/**
		 * @param validadoresCS the validadoresCS to set
		 */
		public void setValidadoresCS(List<ValidadorCondicionSanitaria> validadoresCS) {
			this.validadoresCS = validadoresCS;
		}

		@Override
		public String toString() {
			return "RegistroTracking [id=" + id + ", fechaHora=" + fechaHora + ", localidad=" + localidad
					+ ", validadoresCS=" + validadoresCS + ", detalleLugarRegistro=" + detalleLugarRegistro + "]";
		}

}
