package edu.tecnilogica.entity;
// Generated 27-jun-2017 12:19:30 by Hibernate Tools 5.2.3.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * RegistroTabla generated by hbm2java
 */
@Entity
@Table(name = "REGISTRO_TABLA", schema = "HR")
@TableGenerator (
		name= "course",
		table= "ID_TABLA",
		pkColumnName="SEQUENCE_NAME",
		valueColumnName = "NEXTVAL",
		allocationSize = 1)
public class RegistroTabla implements java.io.Serializable {

	private BigDecimal id;

	public RegistroTabla() {
	}

	public RegistroTabla(BigDecimal id) {
		this.id = id;
	}

	@Id
	@GeneratedValue(strategy= GenerationType.TABLE, generator = "course")
	@Column(name = "ID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

}
