package com.xabe.hilo;

/**
 * Clase principal donde se ejecuta el programa
 * @author Xabe
 *
 */
public class Main {

	public static void main(String[] args) {
		Buffer<Integer> buffer = new BufferSincronizado();
		Consumidor consumidor = new Consumidor("Consumidor", buffer);
		Productor productor = new Productor("Productor", buffer);
		productor.start();
		consumidor.start();
	}
}
