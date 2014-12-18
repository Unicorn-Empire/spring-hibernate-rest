package com.emc.dpc.initializer;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.emc.dpc.config.ApplicationContext;
import com.emc.dpc.config.DispatcherContext;

public class ApplicationInitializer extends	AbstractAnnotationConfigDispatcherServletInitializer {


	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { ApplicationContext.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { DispatcherContext.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
//when implementing WebApplicationInitializer use following code
/*
	private static final String CONFIG_LOCATION = "com.emc.dpc.config";
	private static final String MAPPING_URL = "/*";
	@Override
	public void onStartup(ServletContext servletContext)throws ServletException {
		WebApplicationContext context = getContext();
		servletContext.addListener(new ContextLoaderListener(context));
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping(MAPPING_URL);
	}

	private AnnotationConfigWebApplicationContext getContext() {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setConfigLocation(CONFIG_LOCATION);
		return context;
	}*/

}
