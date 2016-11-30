package ie.turfclub.utilities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
public class Hashing {
	 
	  public static void main(String[] args) {
	 
		int i = 0;
		while (i < 10) {
			String password = "Vet2014";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);
	 
			System.out.println(hashedPassword);
			i++;
		}
	 
	  }
	}