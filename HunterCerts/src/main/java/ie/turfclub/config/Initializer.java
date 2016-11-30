package ie.turfclub.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;






import ie.turfclub.config.DatabaseConfig;
import ie.turfclub.config.ThymeleafConfig;
import ie.turfclub.config.WebAppConfig;
 

@Configuration
@ComponentScan({"ie.turfclub.service" ,"ie.turfclub.validation"})
public class Initializer extends
  AbstractAnnotationConfigDispatcherServletInitializer{
 
 @Override
 protected Class<?>[] getRootConfigClasses() {
  return new Class[] { DatabaseConfig.class, SecurityConfig.class };
 }
 
 @Override
 protected Class<?>[] getServletConfigClasses() {
  return new Class<?>[] { WebAppConfig.class , ThymeleafConfig.class};
 }
 
 @Override
 protected String[] getServletMappings() {
  return new String[] { "/" };
 }
 
}	
 
