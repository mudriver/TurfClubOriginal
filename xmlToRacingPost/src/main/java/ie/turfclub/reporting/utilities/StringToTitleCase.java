package ie.turfclub.reporting.utilities;

public class StringToTitleCase {

	public static String convertString(String title){
		if(title.contains("  ")){
			title = title.replaceAll("  ", " ");
		}
		
		if(title.trim().length() > 1){
			System.out.println(title);
			String[] parts = title.split(" ");
			StringBuilder sb = new StringBuilder(64);
			for (String part : parts) {
			   System.out.println(part);
				if(!part.contains("(")){
			    	char[] chars = part.toLowerCase().toCharArray();
				    chars[0] = Character.toUpperCase(chars[0]);
				    sb.append(new String(chars)).append(" ");
			    }
			    else{
			    	char[] chars = part.toCharArray();
			    	sb.append(new String(chars)).append(" ");
			    }

			    
			}

			
			title = sb.toString().trim();
			if(title.contains("(*)")){
				
			}
		}
		
		return title;
	}
	
	
	
}
