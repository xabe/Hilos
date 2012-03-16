package com.xabe.hilo;


/**
 * Clase que implementa un Consumidor
 * @author Xabe
 *
 */
public class Productor implements Runnable {
	private Thread thread;
	private Buffer<Integer> buffer;

	public Productor(String name, Buffer<Integer> buffer) {
		this.thread = new Thread(this, name);
		this.buffer = buffer;
	}

	public void run() {
		try {
			for (int cuenta = 1; cuenta <= 4; cuenta++) {
				Thread.sleep((int) (Math.random() * 3001));
				buffer.putValue(cuenta);
			}
		} catch (InterruptedException excepcion) {
			excepcion.printStackTrace();
		}
		System.out
		.println(thread.getName()
				+ " puso valores"
				+ ".\nTerminando");
	}

	public void start() {
		this.thread.start();
	}
}
