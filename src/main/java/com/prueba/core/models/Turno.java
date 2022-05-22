package com.prueba.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Turno {
	private static final long serialVersionUID = 1L;
	    @Id
	    @Column(name="TURNO_ID")
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    private int turnoid;

	    @Column(name="TURNO_TIPO")
	    private String turnotipo;

		public int getTurnoid() {
			return turnoid;
		}

		public void setTurnoid(int turnoid) {
			this.turnoid = turnoid;
		}

		public String getTurnotipo() {
			return turnotipo;
		}

		public void setTurnotipo(String turnotipo) {
			this.turnotipo = turnotipo;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	    
	    
}