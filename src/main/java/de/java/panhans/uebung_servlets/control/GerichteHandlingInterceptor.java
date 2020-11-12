package de.java.panhans.uebung_servlets.control;

import java.io.Serializable;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import de.java.panhans.uebung_servlets.entity.Speise;



@GerichteHandling
@Interceptor
public class GerichteHandlingInterceptor implements Serializable { // für SessionScoped Beans

	private static final long serialVersionUID = 1L;

	@AroundInvoke
	public Object aroundInvoke(InvocationContext ic) throws Exception {

		// Suchen nach dem Parameter vom Typ Fahrzeug
		for (Object o : ic.getParameters()) {
			if (o instanceof Speise) {
				Speise f = (Speise) o;
				if (f.getSpeiseID() > 100) {
					throw new IllegalArgumentException("Geben Sie bitte eine passende SpeiseID ein!");
				} else {
					System.out.printf("Speisen mit SpeiseID %d an Methoden '%s' übergeben.%n", f.getSpeiseID(),
							ic.getMethod().getName());
				}
			}
		}

		// Aufruf der Original-Methode
		return ic.proceed();

	}

}