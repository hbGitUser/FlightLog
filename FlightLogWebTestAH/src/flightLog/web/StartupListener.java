package flightLog.web;

import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import flightLog.Config;


/**
 * Application Lifecycle Listener initialising the Config Singelton instance.
 */
public class StartupListener implements ServletContextListener {

	private ServletContext sc;

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		sc = sce.getServletContext();
		try {
			Config config = Config.get();
			
			//copy context inir parameters to app config 
			Enumeration<String> e = sc.getInitParameterNames();
			while(e.hasMoreElements()){ 
				String para = e.nextElement();
				String value = sc.getInitParameter(para);
				config.setProperty(para, value);
			}
		} catch (Exception e) {
			sc.log("### ===> Error initializing Config", e);
			if (e instanceof RuntimeException)
				throw (RuntimeException) e;
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		sc = sce.getServletContext();
	}
}
