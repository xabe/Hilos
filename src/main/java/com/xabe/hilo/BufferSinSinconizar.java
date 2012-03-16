package com.xabe.hilo;


import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de un buffer sin sincronizado
 * @author Xabe
 *
 */
public class BufferSinSinconizar implements Buffer<Integer> {
	private List<Integer> lista;
	
	public BufferSinSinconizar() {
		lista = new ArrayList<Integer>();
	}
	
	public Integer getValue() {
		Integer value = -1;
		if(lista.size() > 0)
		{
			value = lista.get(0);
			lista.remove(0);
		}
		messageGet(value);
		return value;
	}

	public void putValue(Integer value) {
		messagePut(value);
		lista.add(value);
	}
	
	public void messageGet(Integer value) {
		System.out.println("El hilo : "+Thread.currentThread().getName()+" obtiene el valor "+value);
		
	}
	public void messagePut(Integer value) {
		System.out.println("El hilo : "+Thread.currentThread().getName()+" pone el valor "+value);
	}
}
