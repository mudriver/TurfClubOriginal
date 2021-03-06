package ie.turfclub.config;



import java.io.IOException;
import java.util.Collection;




import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import  org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

@Order(2)
@Configuration
@EnableWebMvcSecurity
@ComponentScan({"ie.turfclub.service"})
public class SecurityConfig extends WebSecurityConfigurerAdapter {
     
     
	
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/vetReports/**").access("hasRole('VET')")
                .antMatchers("/huntApproval/**").access("hasRole('ROLE_HCERT_HUNT')")
                .anyRequest().authenticated()
                
                .and()
            .formLogin()
                .loginPage("/login")
          
                .successHandler(new MyAuthSuccessHandler())
         
                //.defaultSuccessUrl("/hunterCert/handlerDetail", true)
                .permitAll()
            
                .and()
            .logout().logoutSuccessUrl("/logout").logoutSuccessHandler(new LogHandler())
           
            .permitAll()
            .and()
		.exceptionHandling().accessDeniedPage("/notAuthorised");
        //.and().httpBasic();
       
    }
 
    @Autowired
    public void configureGlobal(UserDetailsService userService, AuthenticationManagerBuilder auth) throws Exception {
    	
    	
    	//userService.loadUserByUsername("02810P");
    
    	
    	auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    
    	//System.out.println(hand.getOwner_handler_password());
    	/*auth.inMemoryAuthentication().
        withUser("user").password("password").roles("USER").and().
        withUser("trader").password("password").roles("USER","TRADER").and().
        withUser("admin").password("password").roles("USER", "TRADER", "ADMIN");*/
    }
    
    
    @Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
    
  
    
 
	public class LogHandler extends SimpleUrlLogoutSuccessHandler {
		
		 @Override
		    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
		            Authentication authentication) throws IOException, ServletException {

			
		        setDefaultTargetUrl("/logout?logout=" + request.getParameter("logout"));
		       
		        super.onLogoutSuccess(request, response, authentication);       
		    }
		
	}
	

		
	public class MyAuthSuccessHandler implements AuthenticationSuccessHandler {


@Override
public void onAuthenticationSuccess(HttpServletRequest request,
		HttpServletResponse response, Authentication authentication)
		throws IOException, ServletException {
	boolean hasAdmin = false;
	System.out.println("DETERMINE");
	Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
    for (GrantedAuthority grantedAuthority : authorities) {
        if (grantedAuthority.getAuthority().equals("VET")) {
        	System.out.println("USER ACCOUNT");
        	
        	
        } else if (grantedAuthority.getAuthority().equals("VETADMIN")) {
        	System.out.println("VETADMIN");
        	hasAdmin = true;
        	
        }
        
            
        
    }


	if (hasAdmin) {
		response.sendRedirect( "/vetReports/vetReportsAdmin/");
	} else {
		response.sendRedirect( "/vetReports/vetReports/");
	} 
	
}




}
	
	

	
	
    
}