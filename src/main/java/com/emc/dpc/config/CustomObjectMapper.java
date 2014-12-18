package com.emc.dpc.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;

public class CustomObjectMapper extends ObjectMapper {
/**
	 * 
	 */
	private static final long serialVersionUID = -3131980955975958812L;

//ref http://blog.pastelstudios.com/2012/03/12/spring-3-1-hibernate-4-jackson-module-hibernate/	
	
	public CustomObjectMapper() {
        Hibernate4Module hm = new Hibernate4Module();
        registerModule(hm);
        
        configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        configure(SerializationFeature.INDENT_OUTPUT , false);
    }
	
	

}
