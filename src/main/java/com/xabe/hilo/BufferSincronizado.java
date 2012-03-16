package com.xabe.hilo;

/**
 * Implementación de un buffer sincronizado
 * @author Xabe
 *
 */
public class BufferSincronizado implements Buffer<Integer> {
	private Integer lista[];

	public BufferSincronizado() {
		lista = new Integer[] { -1, -1 };
	}

	public synchronized Integer getValue() {
		while (IsBufferVacio()) {
			try {
				System.out.println(Thread.currentThread().getName() + " trata de leer.");
				System.out.println("Bufer vacio.");
				wait();
			}
			// si se interrumpió el subproceso en espera, imprimir el rastreo de
			// la pila
			catch (InterruptedException excepcion) {
				excepcion.printStackTrace();
			}
		}
		int value = -1;
		for (int i = 0; i < lista.length; i++) {
			if (lista[i] != -1) {
				value = lista[i];
				lista[i] = -1;
				break;
			}
		}
		notify();
		messageGet(value);
		return value;
	}

	public synchronized void putValue(Integer value) {
		while (IsBufferLleno()) {
			try {
				System.out.println(Thread.currentThread().getName()
						+ " trata de escribir.");
				System.out.println("El Bufer esta lleno.");
				wait();
			} catch (InterruptedException excepcion) {
				excepcion.printStackTrace();
			}
		}
		for (int i = 0; i < lista.length; i++) {
			if (lista[i] == -1) {
				lista[i] = value;
				break;
			}
		}
		messagePut(value);
		notify();
	}

	public boolean IsBufferLleno() {
		boolean lleno = true;
		for (Integer valor : lista) {
			if (valor == -1) {
				lleno = false;
				break;
			}
		}
		return lleno;
	}
	
	public boolean IsBufferVacio() {
		boolean vacio = true;
		for (Integer valor : lista) {
			if (valor > -1) {
				vacio = false;
				break;
			}
		}
		return vacio;
	}

	public void messageGet(Integer value) {
		System.out.println("El hilo : " + Thread.currentThread().getName()
				+ " obtiene el valor " + value);

	}

	public void messagePut(Integer value) {
		System.out.println("El hilo : " + Thread.currentThread().getName()
				+ " pone el valor " + value);
	}
}
