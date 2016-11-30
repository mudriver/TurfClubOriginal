package ie.turfclub.pojos;


import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HunterCertsBasket {


	private List<HunterCertItem> hunterCerts = new ArrayList<>();
	private HunterCertItem currentItem;
	
	public List<HunterCertItem> getHunterCerts() {
		return hunterCerts;
	}

	public void clearUnfinishedItems(){
		List<HunterCertItem> clearItems = new ArrayList<>();
		for(HunterCertItem item : hunterCerts){
			
			if(item.hasHandler() && item.hasCert() && item.hasOwner() && item.hasHunt() && item.hasVaccinations() && item.isConditionsAccepted()){
				clearItems.add(item);
			}
		}
		hunterCerts = clearItems;
	}
	
	public boolean hasUnfinishedItems(){
	
		for(HunterCertItem item : hunterCerts){
			
			if(item.isUnFinished()){
				return true;
			}
		}
		return false;
	}
	
	public void clearBasket(){
		hunterCerts = new ArrayList<>();
	}
	
	public void addCurrentItemToBasket(){
		hunterCerts.add(currentItem);
	}
	
	public void removeHunterCertItem(HunterCertItem item){
		hunterCerts.remove(item);
	}
	
	
	public HunterCertItem getCurrentItem() {
		return currentItem;
	}
	public void setCurrentItem(HunterCertItem currentItem) {
		this.currentItem = currentItem;
	}

	
	
		
	
}
