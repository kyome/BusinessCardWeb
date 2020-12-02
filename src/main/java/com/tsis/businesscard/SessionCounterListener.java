package com.tsis.businesscard;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounterListener implements HttpSessionListener {
	static private int activeSessions;

	public static int getActiveSessions() {
		return activeSessions;
	}

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		activeSessions++;
		System.out.println("Created!! activeSessions : " + activeSessions);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		activeSessions--;
		System.out.println("Destoryed!! activeSessions : " + activeSessions);

	}

}
