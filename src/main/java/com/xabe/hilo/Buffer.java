package com.xabe.hilo;

/**
 * Interfaz que permite crear un buffer entre el consumidor y productor
 * @author Xabe
 *
 * @param <T>
 */
public interface Buffer <T>{
	/**
	 * Ponemos un valor en el Buffer
	 * @param value
	 */
	public void putValue(T value);
	
	/**
	 * Obtenemos el valor generico
	 * @return 
	 */
	public T getValue();
	
	public void messagePut(Integer value);
	
	public void messageGet(Integer value);
}
