package ie.turfclub.utilities;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ie.turfclub.pojos.HunterCertItem;
import ie.turfclub.pojos.HunterCertsBasket;
import ie.turfclub.pojos.PaymentObj;

public class BasketToPaymentObjConvertor {

	
	public static PaymentObj convertBasketToPaymentObj(HunterCertsBasket basket){
		PaymentObj payObj = new PaymentObj();
		String horsesPaid = "";
		String orderId = "";
		int amount = 0;
		String description = "Hunter Certs Online Payment";
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy:HH:mm:ss:SSS");
		SimpleDateFormat timef = new SimpleDateFormat("HHmmss");
		
		Date date = new Date();
		String time = timef.format(date);
		String dateTime = format.format(date);
		
	
		List<HunterCertItem> items = basket.getHunterCerts();
		
		int count = 0;
		for(HunterCertItem item : items){
			if(count == 0){
				horsesPaid += item.getCert().getHorse_name();
			}
			else{
				horsesPaid += "-" + item.getCert().getHorse_name() ;
			}
			count++;
			//Logic to add hunt amount from hunt objects can be added here 
			amount += 50;
			
		}
		
		//comment out time for live version
		orderId = basket.getHunterCerts().get(0).getHandler().getOwner_handler_account_no() + time;
		System.out.println(orderId);
		payObj.setHorsesPaid(horsesPaid);
		payObj.setOrderId(orderId);
		payObj.setDescription(description);
		payObj.setAmount(Integer.toString(amount));
		payObj.setDateTime(dateTime);
		payObj.makeHash();
		
		
		
		return payObj;
	}
	
}
