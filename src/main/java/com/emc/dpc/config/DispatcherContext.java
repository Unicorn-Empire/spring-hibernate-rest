package com.emc.dpc.config;

import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.emc.dpc.controller","com.emc.dpc.resources.*.controller"})
public class DispatcherContext extends WebMvcConfigurerAdapter {
	
	@Value("${database.driver}")
	private String driverClassName;
	@Value("${database.url}")
	private String url;
	@Value("${database.user}")
	private String username;
	@Value("${database.password}")
	private String password;
	@Value("${hibernate.dialect}")
	private String hibernateDialect;
	@Value("${hibernate.show_sql}")
	private String hibernateShowSql;
	@Value("${hibernate.hbm2ddl.auto}")
	private String hibernateHbm2ddlAuto;

	@Bean()
	public ComboPooledDataSource getDataSource() throws PropertyVetoException 
	{
		ComboPooledDataSource datasource = new ComboPooledDataSource();
		datasource.setDriverClass(driverClassName);
		datasource.setJdbcUrl(url);
		datasource.setUser(username);
		datasource.setPassword(password);
		return datasource;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
	{
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}

	@Bean
	public LocalSessionFactoryBean getSessionFactory()throws PropertyVetoException
	{
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setHibernateProperties(getHibernateProperties());
		sessionFactory.setPackagesToScan(new String[] { "com.emc.dpc" });
		return sessionFactory;
	}
	
	@Bean
	public static PropertyPlaceholderConfigurer properties()	{
		PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		Resource[] resources = new ClassPathResource[ ]{ new ClassPathResource( "database.properties" ) };
		ppc.setLocations( resources );
		ppc.setIgnoreUnresolvablePlaceholders( true );
		return ppc;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) 
	{
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		registry.addInterceptor(localeChangeInterceptor);
	}

	@Bean
	public LocaleResolver localeResolver() 
	{
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setDefaultLocale(StringUtils.parseLocaleString("en"));
		return cookieLocaleResolver;
	}

	@Bean
	public Properties getHibernateProperties() 
	{
		Properties properties = new Properties();
		properties.put("hibernate.dialect", hibernateDialect);
		properties.put("hibernate.show_sql", hibernateShowSql);
//		properties.put("hibernate.connection.provider_class","org.hibernate.connection.C3P0ConnectionProvider");  
	    properties.put("hibernate.c3p0.acquire_increment",5);
	    properties.put("hibernate.c3p0.idle_test_period",1800);
	    properties.put("hibernate.c3p0.max_size",600);
	    properties.put("hibernate.c3p0.max_statements",50);
	    properties.put("hibernate.c3p0.min_size",5);
	    properties.put("hibernate.c3p0.timeout",1800);
		properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
		return properties;
	}
	
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    	
    	MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter(new CustomObjectMapper());
    	List<MediaType> mediaTypes = new ArrayList<MediaType>();
    	mediaTypes.add(MediaType.APPLICATION_JSON);
    	converter.setSupportedMediaTypes(mediaTypes);
      	converters.add(converter);
    }

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(false).favorParameter(true);
	}
	
	@Bean public ViewResolver resolver()
	{
		InternalResourceViewResolver url = new InternalResourceViewResolver();
		url.setPrefix("/WEB-INF/views/"); url.setSuffix(".jsp"); return url; 
	}
	
	
	// - See more at:
	// http://www.sivalabs.in/2011/02/springhibernate-application-with-zero.html#sthash.JeprjXpj.dpuf
	// http://geowarin.github.io/2013/01/23/complete-example-of-a-spring-mvc-3-2-project/
	// http://docs.spring.io/spring-framework/docs/3.2.0.RELEASE/spring-framework-reference/html/mvc.html#mvc-container-config
	//http://www.luckyryan.com/2013/02/07/migrate-spring-mvc-servlet-xml-to-java-config/
	//https://spreadsheets.google.com/pub?hl=en_US&hl=en_US&key=0Am_zV4_vRvfVdF9abzkwTTFCRkQwY3hrLVh6SE05ZHc&output=html
}
