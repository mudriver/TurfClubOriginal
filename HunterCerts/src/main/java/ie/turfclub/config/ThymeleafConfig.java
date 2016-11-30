package ie.turfclub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@Order(1)
@Configuration
public class ThymeleafConfig {
 
    @Bean
    public TemplateResolver templateResolver(){
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/views/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }
 
    @Bean
    public TemplateResolver huntViewResolver(){
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/views/huntApprovals/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }
    
    
    @Bean
    public TemplateResolver hunterCertRenewalResolver(){
        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
        templateResolver.setPrefix("/WEB-INF/views/renewals/");
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML5");
        return templateResolver;
    }
    
    @Bean
    public SpringTemplateEngine templateEngine(){
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
      
        templateEngine.addTemplateResolver(huntViewResolver());
        templateEngine.addTemplateResolver(hunterCertRenewalResolver());
        templateEngine.addTemplateResolver(templateResolver());
        return templateEngine;
    }
 
 @Bean
 public ThymeleafViewResolver thymeleafViewResolver() {
  ThymeleafViewResolver resolver = new ThymeleafViewResolver();
  resolver.setTemplateEngine(templateEngine());
  return resolver;
 }
}
