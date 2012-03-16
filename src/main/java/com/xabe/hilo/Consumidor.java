package com.xabe.hilo;

/**
 * Clase que implementa un Consumidor
 * @author Xabe
 *
 */
public class Consumidor implements Runnable {
	private Thread thread;
	private Buffer<Integer> buffer;

	public Consumidor(String name, Buffer<Integer> buffer) {
		this.thread = new Thread(this, name);
		this.buffer = buffer;
	}

	public void run() {
		int suma = 0;
		try {
			for (int cuenta = 1; cuenta <= 4; cuenta++) {
				Thread.sleep((int) (Math.random() * 3001));
				suma += buffer.getValue();
			}
		} catch (InterruptedException excepcion) {
			excepcion.printStackTrace();
		}
		System.out
				.println(thread.getName()
						+ " leyo valores, dando un total de: " + suma
						+ ".\nTerminando");
	}

	public void start() {
		this.thread.start();
	}

}
