package ie.turfclub.reporting.config;

import ie.turfclub.reporting.utilities.AccountReporting;
import ie.turfclub.reporting.utilities.FTPUtility;
import ie.turfclub.reporting.utilities.MailUtility;
import ie.turfclub.reporting.utilities.QueryIrishRacing;
import ie.turfclub.reporting.utilities.VetReporting;
import ie.turfclub.reporting.utilities.XmlUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource("classpath:resources/config.properties")

public class BeanConfig {

	@Autowired
	private Environment env;
	
	
	 @Bean
	 public static PropertySourcesPlaceholderConfigurer properties() {
	     PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
	     return propertySourcesPlaceholderConfigurer;
	 }
	
	@Bean 
	   public MailUtility sendMail(){
		return new MailUtility(env);
	   }
	 
	 @Bean
	 public XmlUtility xmlUtils(){
		 return new XmlUtility();
	 }
	 
	 @Bean
	 public AccountReporting accountsReports(){
		 return new AccountReporting();
	 }
	 
	 @Bean
	 public FTPUtility ftpUtil(){
		 return new FTPUtility();
	 }
	 
	 @Bean
	 public QueryIrishRacing queryIrishRacing(){
		 return new QueryIrishRacing();
	 }
	 @Bean
	 public VetReporting vetReporting(){
		 return new VetReporting();
	 }
	
}
