package br.com.barbershop.model;

import java.io.Serializable;

public abstract class AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public abstract Serializable getId();
}
