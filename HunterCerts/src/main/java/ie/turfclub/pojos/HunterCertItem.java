package ie.turfclub.pojos;

import java.util.ArrayList;
import java.util.List;

import ie.turfclub.model.Hunt;
import ie.turfclub.model.HunterCert;
import ie.turfclub.model.OwnerHandler;
import ie.turfclub.model.Vaccination;

public class HunterCertItem {

	private HunterCert cert = null;
	private OwnerHandler handler = null;
	private Hunt hunt = null;
	private OwnerHandler owner = null;
	private List<Vaccination> vaccinations = new ArrayList<Vaccination>();
	private boolean conditionsAccepted = false;
	private boolean hasRanOutsideIreland;
	

	
	
	public boolean isHasRanOutsideIreland() {
		return hasRanOutsideIreland;
	}
	public void setHasRanOutsideIreland(boolean hasRanOutsideIreland) {
		this.hasRanOutsideIreland = hasRanOutsideIreland;
	}
	public boolean isUnFinished(){
		if(!this.hasHandler() || !this.hasCert() || !this.hasOwner() || !this.hasHunt() || !this.hasVaccinations() || !this.isConditionsAccepted()){
			return true;
		}
		return false;
	}
	public boolean isEmpty(){
		if(!this.hasHandler() && !this.hasCert() && !this.hasOwner() && !this.hasHunt() && !this.hasVaccinations() && !this.isConditionsAccepted()){
			return true;
		}
		return false;
	}
	public String getCurrentStep(){
	
		// if the handler has not been confirmed redirect to step 1
		if (!this.hasHandler()) {
			return "redirect:/hunterCert/handlerDetail";
		}
		// if the huntercert for the currentItem has not been initialized return
		// to horse select
		else if (!this.hasCert()) {
			return "redirect:/hunterCert/horseDetail";
		}
		// if the current item has no owner return to the owner page
		else if (!this.hasOwner()) {
			//System.out.println(!hCertBasket.getCurrentItem().hasOwner() + url);
			return "redirect:/hunterCert/ownerDetail";
		} else if (!this.hasHunt()) {
			//System.out.println(!hCertBasket.getCurrentItem().hasOwner() + url);
			return "redirect:/hunterCert/huntDetail";
		}
		else if (!this.hasVaccinations()){
			return "redirect:/hunterCert/vaccinations";
		}
		else if(!this.isConditionsAccepted()){
			return "redirect:/hunterCert/confirm";
		}
		return "redirect:/hunterCert/handlerDetail";
		
	}
	
	
	public boolean hasCert(){
		return this.cert != null;
	}
	
	public HunterCert getCert() {
		return cert;
	}
	public void setCert(HunterCert cert) {
		this.cert = cert;
	}
	
	public boolean hasHandler(){
		return this.handler != null;
	}
	
	public OwnerHandler getHandler() {
		return handler;
	}
	public void setHandler(OwnerHandler handler) {
		this.handler = handler;
	}
	
	public boolean hasOwner(){
		return this.owner != null;
	}
	
	public OwnerHandler getOwner() {
		return owner;
	}
	
	public void setOwner(OwnerHandler owner) {
		this.owner = owner;
	}
	
	public boolean hasHunt(){
		return this.hunt != null;
	}
	
	

	public List<Vaccination> getVaccinations() {
		return vaccinations;
	}

	public void setVaccinations(List<Vaccination> vaccinations) {
		this.vaccinations = vaccinations;
	}

	public boolean hasVaccinations(){
		return !this.vaccinations.isEmpty();
	}
	
	public boolean isConditionsAccepted() {
		return conditionsAccepted;
	}

	public void setConditionsAccepted(boolean conditionsAccepted) {
		this.conditionsAccepted = conditionsAccepted;
	}

	public Hunt getHunt() {
		return hunt;
	}

	public void setHunt(Hunt hunt) {
		this.hunt = hunt;
	}

	public HunterCert getUpdatedHunterCert(){
		this.getCert().setHandler_id(this.getHandler());
		this.getCert().setHunt_id(this.getHunt());
		this.getCert().setOwner_id(this.getOwner());
		this.getCert().setStatus("PAYED");
		this.getCert().setRan_out_of_ireland(this.hasRanOutsideIreland);
		return this.getCert();
	}
	
	
	
	
	
	
}
