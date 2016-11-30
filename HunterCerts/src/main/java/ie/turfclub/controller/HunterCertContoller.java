package ie.turfclub.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Transient;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ie.turfclub.model.HorseWithID;
import ie.turfclub.model.Hunt;
import ie.turfclub.model.HunterCert;
import ie.turfclub.model.OwnerHandler;
import ie.turfclub.model.Vaccination;
import ie.turfclub.pojos.HunterCertItem;
import ie.turfclub.pojos.HunterCertsBasket;
import ie.turfclub.pojos.PaymentObj;
import ie.turfclub.pojos.VaccinationForm;
import ie.turfclub.service.HuntService;
import ie.turfclub.service.HunterCertService;
import ie.turfclub.service.OwnerHandlerService;
import ie.turfclub.service.VaccinationService;
import ie.turfclub.utilities.BasketToPaymentObjConvertor;
import ie.turfclub.utilities.StringToTitleCase;

@Controller
@ComponentScan("ie.turfclub.pojos" )
@RequestMapping(value = "/hunterCert")
public class HunterCertContoller {

	static Logger logger = LoggerFactory.getLogger(HunterCertContoller.class);

	// service to get huntercert objects from the database
	@Autowired
	private HunterCertService hunterCertService;
	// service to get huntercert objects from the database
	@Autowired
	private OwnerHandlerService ownerHandlerService;
	// service to get hunt objects from the database
	@Autowired
	private HuntService huntService;
	// store the huntercert objects as they are completed
	@Autowired
	@Transient
	private HunterCertsBasket hCertBasket;
	// store the huntercert objects as they are completed
	@Autowired
	private VaccinationService vaccinationService;
	// get messages from properties file
	@Autowired
	private MessageSource messageSource;
	private Authentication auth;
	

	// STEP 1a - Confirm the handler details
	@RequestMapping(value = "/handlerDetail", method = RequestMethod.GET)
	public String handlerDetails(Model model) {

		logger.info("HANDLER : Getting handler info & initialize cart");

		String url = "huntercert-handlerDetail";
		String redirectUrl = checkCompletion(url);
		if (!url.equals(redirectUrl)) {
			return redirectUrl;
		}
		else{
			HunterCertItem item = new HunterCertItem();
			hCertBasket.clearUnfinishedItems();
			hCertBasket.setCurrentItem(item);

			auth = SecurityContextHolder.getContext().getAuthentication();
			// model.addAttribute("username", auth.getName());
			OwnerHandler handler = ownerHandlerService.getOwnerHandler(auth
					.getName());

			hCertBasket.getCurrentItem().setHandler(handler);

			model.addAttribute("handler", handler);
			// System.out.println(checkCompletion("huntercert-handlerDetail"));
			return "huntercert-handlerDetail";
		}
		
		
		
	}

	// STEP 2A - Select A Horse
	@RequestMapping(value = "/horseDetail", method = RequestMethod.GET)
	public String selectHorse(Model model,
			@RequestParam(value = "add", required = false) String add) {

		

		logger.info("IN: Hunter Cert/horsedetail-GET");
		// if the user has requested to add another item to the basket
		// create a new item and set it as the current item
		//if the add parameter is set add a new huntercert to the basket
		if (add != null) {
			logger.info("IN: Hunter Cert/ SETUP new Handler & item in basket");
			auth = SecurityContextHolder.getContext().getAuthentication();
			// model.addAttribute("username", auth.getName());
			OwnerHandler handler = ownerHandlerService.getOwnerHandler(auth
					.getName());
			HunterCertItem item = new HunterCertItem();
			item.setHandler(handler);
			hCertBasket.setCurrentItem(item);
		}
		
		// check that correct path to url has been taken otherwise redirect to
		// proper step
		String url = "huntercert-horseDetail";
		String redirectUrl = checkCompletion("huntercert-horseDetail");
		if (!url.equals(redirectUrl)) {
			return redirectUrl;
		}

		else {

		

			// initialize the model if it doesn't exist
			// ****** It will exist when error checking occurs only!!
			if (!model.containsAttribute("horseWithID")) {
				// logger.info("Adding Horse object to model");
				HorseWithID horse = new HorseWithID();
				model.addAttribute("horseWithID", horse);
			}

			model.addAttribute("username", auth.getName());
			return "huntercert-horseDetail";
		}

	}

	// STEP 2B Validated Horse
	@RequestMapping(value = "/horseDetail", method = RequestMethod.POST)
	public String getHorseDetail(@ModelAttribute HunterCert hunterCert,
			@Valid @ModelAttribute HorseWithID horseWithID,
			BindingResult result, RedirectAttributes redirectAttrs) {

		if (result.hasErrors()) {
			logger.info("hunterCert-add error: ");
			redirectAttrs.addFlashAttribute(
					"org.springframework.validation.BindingResult.horseWithID",
					result);
			redirectAttrs.addFlashAttribute("horseWithID", horseWithID);
			return "redirect:/hunterCert/horseDetail";
		}
		else if(basketContainsHCert(horseWithID.getHorse_name())){
			redirectAttrs.addFlashAttribute("basketError", "Selected Horse Already in Basket!");
			redirectAttrs.addFlashAttribute("horseWithID", horseWithID);
			return "redirect:/hunterCert/horseDetail";
		}
		else {

			hunterCert = hunterCertService.getHunterCert(Integer
					.parseInt(horseWithID.getId()));
			redirectAttrs.addFlashAttribute("hunterCert", hunterCert);
			redirectAttrs.addFlashAttribute("horseWithID", horseWithID);
			return "redirect:/hunterCert/horseDetail";

		}
	}

	// STEP 2C Confirm & Save Horse Details
	@RequestMapping(value = "/horseDetailConfirm", method = RequestMethod.POST)
	public String saveHunterCert(@ModelAttribute HunterCert hunterCert) {
		logger.info("IN: horse details confirm");
		// Save the selected huntercert object to the basket
		hunterCert = hunterCertService.getHunterCert(hunterCert.getId());
		hCertBasket.getCurrentItem().setCert(hunterCert);

		return "redirect:/hunterCert/ownerDetail";
	}

	// STEP 3a Owner Details
	@RequestMapping(value = "/ownerDetail", method = RequestMethod.GET)
	public String ownerDetails(Model model) {
		logger.info("IN: Owner Get");

		if (!model.containsAttribute("owner")) {

			OwnerHandler owner = new OwnerHandler();
			model.addAttribute("owner", owner);
		}

		return checkCompletion("huntercert-ownerDetail");
	}

	// STEP 3B Validate OwnerAccount
	@RequestMapping(value = "/ownerDetail", method = RequestMethod.POST)
	public String getOwnerDetail(
			@Valid @ModelAttribute OwnerHandler ownerHandler,
			BindingResult result, RedirectAttributes redirectAttrs) {

		// logger.info("Basket" +
		// hCertBasket.getCurrentItem().getHandler().getOwner_handler_account_no());

		if (result.hasErrors()) {
			logger.info("hunter owner-add error: ");
			redirectAttrs.addFlashAttribute(
					"org.springframework.validation.BindingResult.owner",
					result);
			redirectAttrs.addFlashAttribute("owner", ownerHandler);
			return "redirect:/hunterCert/ownerDetail";
		} else {

			ownerHandler = ownerHandlerService.getOwner(ownerHandler
					.getOwner_handler_account_no());
			System.out.println(ownerHandler.getOwner_handler_name());
			redirectAttrs.addFlashAttribute("owner", ownerHandler);
			redirectAttrs.addFlashAttribute("ownerDetail", ownerHandler);
			return "redirect:/hunterCert/ownerDetail";

		}
	}

	// STEP 3C Confirm & Save Owner Details
	@RequestMapping(value = "/ownerDetailConfirm", method = RequestMethod.POST)
	public String saveOwner(@ModelAttribute OwnerHandler owner) {
		logger.info("IN:owner details confirm");
		// Save the selected owner to the basket

		owner = ownerHandlerService.getOwner(owner
				.getOwner_handler_account_no());
		hCertBasket.getCurrentItem().setOwner(owner);

		return "redirect:/hunterCert/huntDetail";
	}

	// STEP 4a Hunt Detail
	@RequestMapping(value = "/huntDetail", method = RequestMethod.GET)
	public String huntDetails(Model model) {
		logger.info("IN: Hunter Cert/huntDetail GET");

		if (!model.containsAttribute("hunt")) {
			Hunt hunt = new Hunt();
			model.addAttribute("hunt", hunt);
		}
		return checkCompletion("huntercert-huntDetail");
	}

	// STEP 4b Validated and Save Hunt Detail
	@RequestMapping(value = "/huntDetail", method = RequestMethod.POST)
	public String saveHuntDetails(@Valid @ModelAttribute Hunt hunt,
			BindingResult result, RedirectAttributes redirectAttrs) {
		logger.info("IN: Hunter Cert/huntDetail POST");
		// validate the hunt object
		if (result.hasErrors()) {
			logger.info("hunterCert-add error: ");
			redirectAttrs
					.addFlashAttribute(
							"org.springframework.validation.BindingResult.hunt",
							result);
			redirectAttrs.addFlashAttribute("hunt", hunt);
			return "redirect:/hunterCert/huntDetail";
		} else {
			hunt = huntService.getHunt(hunt.getId());
			// Save the selected hunt object to the basket
			hCertBasket.getCurrentItem().setHunt(hunt);

			return "redirect:/hunterCert/vaccinations";
		}
	}

	// Step 5A - Show Vaccinations And Enter New
	@RequestMapping(value = "/vaccinations", method = RequestMethod.GET)
	public String vaccinationDetails(Model model) {
		logger.info("IN: Hunter Cert/ Vaccinations GET");

		String url = "huntercert-vaccinations";
		String redirectUrl = checkCompletion(url);
		if (!url.equals(redirectUrl)) {
			return redirectUrl;
		} else {
			List<Vaccination> vaccinations = vaccinationService
					.getVaccinations(hCertBasket.getCurrentItem().getCert()
							.getId());
			// add existing horsename to the model
			model.addAttribute("horsename", hCertBasket.getCurrentItem()
					.getCert().getHorse_name());
			// add existing vaccinations to the model
			model.addAttribute("vaccinations", vaccinations);
			// add three blank vaccinations to the model with hcert id

			if (!model.containsAttribute("inputForm")) {
				VaccinationForm form = new VaccinationForm();
				String hcertId = hCertBasket.getCurrentItem().getCert().getId()
						.toString();
				for (Vaccination vac : form.getVaccinations()) {
					vac.setVac_hcert_id(hcertId);
				}
				model.addAttribute("inputForm", form);
			}

			return "huntercert-vaccinations";
		}

	}

	// Step 5B - Save Vaccinations

	@RequestMapping(value = "/addVaccinations", method = RequestMethod.POST)
	public String saveVaccinationDetails(
			@Valid @ModelAttribute VaccinationForm inputForm,
			BindingResult result, RedirectAttributes redirectAttrs) {

		// update the basket item to reflect that the condition were accepted on
		// this item

		if (result.hasErrors()) {

			logger.info("Vaccination Errors" + result.getObjectName());
			List<ObjectError> errors = result.getAllErrors();
			for (int i = 0; i < result.getErrorCount(); i++) {

				// if there are too many attempts log the person out
				if (errors.get(i).toString()
						.contains("Too many vaccination attempts!!")) {
					return "redirect:/hunterCert/review?ERROR="
							+ "Too many vaccination attempts!! The horse "
							+ StringToTitleCase
									.convertString(hCertBasket.getCurrentItem()
											.getCert().getHorse_name())
							+ " is now locked - Please contact the Turf Club to unblock";
				}
			}
			redirectAttrs.addFlashAttribute(
					"org.springframework.validation.BindingResult.inputForm",
					result);
			redirectAttrs.addFlashAttribute("inputForm", inputForm);
			return "redirect:/hunterCert/vaccinations";
		}

		// save the vaccinations to the basket
		else {
			hCertBasket.getCurrentItem().setVaccinations(
					inputForm.getVaccinations());
			return "redirect:/hunterCert/confirm";
		}

	}

	// Step 6 Confirm Conditions for Current Hunter Cert
	@RequestMapping(value = "/confirm", method = RequestMethod.GET)
	public String listOfCondtions(Model model) {
		logger.info("IN: Hunter Cert/conditions GET");

		// add logic here to get hunt price if needed from huntService
		model.addAttribute("huntPrice", "60");
		if (!model.containsAttribute("hunterCert")) {
			logger.info("Adding HunterCert object to model");
			HunterCert hunterCert = new HunterCert();
			model.addAttribute("hunterCert", hunterCert);
		}
		return checkCompletion("huntercert-conditions");
	}

	// Step 6B - Save conditions

	@RequestMapping(value = "/conditionsAccept", method = RequestMethod.POST)
	public String saveConditions(@RequestParam(value = "no", required = false) String no,
			@RequestParam(value = "yes", required = false) String yes,
			@RequestParam(value = "agree", required = false) String accept) {

		// update the basket item to reflect that the condition were accepted on
		// this item

		// System.out.println(accept);
		if (accept!=null && accept.equals("agree")) {
			hCertBasket.getCurrentItem().setConditionsAccepted(true);
		
			if(no!=null && no.equals("no")){
				hCertBasket.getCurrentItem().setHasRanOutsideIreland(false);
			}
			if(yes!=null && yes.equals("yes")){
				hCertBasket.getCurrentItem().setHasRanOutsideIreland(true);
			}
			
			return "redirect:/hunterCert/review";
		} else {
			return "redirect:/hunterCert/conditions";
		}
		// Save the selected hunt object to the basket

	}

	// Step 7 Review Hunter Certs in Basket
	@RequestMapping(value = "/review", method = RequestMethod.GET)
	public String listOfHunterCerts(Model model, @RequestParam(value = "ERROR", required = false) String error) {
		logger.info("Adding Current Item to Basket and Display Basket");
		String url = "huntercert-review-payment";
		String redirectUrl = checkCompletion(url);
		if (!url.equals(redirectUrl)) {
			return redirectUrl;
		}

		else {
			// if the current item is not empty add to basket and empty current item
			if (hCertBasket.getCurrentItem() != null
					&& !hCertBasket.getCurrentItem().isUnFinished()) {
				hCertBasket.addCurrentItemToBasket();
				hCertBasket.setCurrentItem(null);
			} 

			List<HunterCertItem> items = hCertBasket.getHunterCerts();
			System.out.println(error);
			if(error != null){
				model.addAttribute("error", error);
			}
			if (!items.isEmpty() && !hCertBasket.hasUnfinishedItems()) {

				PaymentObj obj = BasketToPaymentObjConvertor
						.convertBasketToPaymentObj(hCertBasket);
				model.addAttribute("payObj", obj);
				model.addAttribute("huntercerts", items);
				model.addAttribute("totalPrice", (50 * items.size()));
			} else {
				model.addAttribute("payObj", null);
				model.addAttribute("huntercerts", null);
				model.addAttribute("totalPrice", null);
			}

			return "huntercert-review-payment";
		}
		
		
	
	}

	// Step 8 Payment
	@RequestMapping(value = "/receipt", method = RequestMethod.GET)
	public String payment(@RequestParam(value = "TERMINALID", required = true) String terminalId
			,@RequestParam(value = "ORDERID", required = true) String orderId
			,@RequestParam(value = "AMOUNT", required = true) String amount
			,@RequestParam(value = "DATETIME", required = true) String dateTime
			,@RequestParam(value = "RESPONSECODE", required = true) String responseCode
			,@RequestParam(value = "RESPONSETEXT", required = true) String responseText
	,@RequestParam(value = "HASH", required = true) String hash, Model model){
		logger.info("Processing Paid Items Basket");
		

	
		
		
			 String returnHash;
			 String original = terminalId + orderId + amount + dateTime + responseCode + responseText + "1790testestablished" ; 
			 MessageDigest md = null;
			try {
				md = MessageDigest.getInstance("MD5");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				md.update(original.getBytes());
				byte[] digest = md.digest();
				StringBuffer sb = new StringBuffer();
				for (byte b : digest) {
					sb.append(String.format("%02x", b & 0xff));
				}

				//System.out.println("original:" + original);
				//.out.println("digested(hex):" + sb.toString());
				returnHash = sb.toString();
		
			 
		
		//if the payment is successful by verifying the hash then
		//set each item in the cart to payed and update the details
				SimpleDateFormat sql = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat normal = new SimpleDateFormat("dd/MM/yyyy");
				if(responseCode.equals("A") && returnHash.equals(hash)){
			//process cart items
			List<HunterCert> updatedHunterCerts = new ArrayList<>();
			for(HunterCertItem item : hCertBasket.getHunterCerts()){
				HunterCert cert = item.getUpdatedHunterCert();
				HunterCert updatecert = hunterCertService.getHunterCert(cert.getId());
				updatecert.setHunt_id(huntService.getHunt(cert.getHunt_id().getId()));
				updatecert.setOwner_id(ownerHandlerService.getOwner(cert.getOwner_id().getOwner_handler_account_no()));
				updatecert.setHandler_id(ownerHandlerService.getOwnerHandler(cert.getHandler_id().getOwner_handler_account_no()));
				updatecert.setRan_out_of_ireland(cert.isRan_out_of_ireland());
				updatecert.setStatus("PAID");
				updatecert.setHcert_order_id(orderId);
				hunterCertService.updateHunterCert(updatecert);
				updatedHunterCerts.add(item.getCert());
				List<Vaccination> vacs = item.getVaccinations();
				for(Vaccination vac : vacs){
					System.out.println(vac.getVac_date());
					System.out.println(vac.getVac_type());
					
					if(vac.getVac_type() != null){
						try {
							vac.setVac_date(sql.format(normal.parse(vac.getVac_date())));
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						vac.setVac_hcert_id(cert.getId().toString());
						vaccinationService.saveVaccination(vac);
					}
					
				}
			}
			
			//return huntercerts from cart items to the receipt
			//and the unique transaction orderId
			model.addAttribute("huntercerts", updatedHunterCerts);
			model.addAttribute("receiptNo", orderId);
			
			
		}
		
	
			
			
		
		
		

		return "huntercert-payment-receipt";
	}

	// show unfinshed item if one exists

	@RequestMapping(value = "/unFinishedItem", method = RequestMethod.GET)
	public String unFinishedHunterCert(
			@RequestParam(value = "continue", required = false) String cont) {

		if (cont == null) {
			return "huntercert-unFinished";
		} else if (cont.equals("continue")) {
			return hCertBasket.getCurrentItem().getCurrentStep();
		} else if (cont.equals("start")) {
			hCertBasket.setCurrentItem(null); 
			return "redirect:/hunterCert/handlerDetail";
		} else {
			return "redirect:/hunterCert/handlerDetail";
		}

	}

	// DELETE Function for HunterCert Basket
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteHunterCert(
			@RequestParam(value = "horseName", required = true) String name,
			@RequestParam(value = "yob", required = true) String yob,
			@RequestParam(value = "phase", required = true) String phase) {

		ModelAndView modelAndView = null;

		if (phase.equals("stage")) {
			modelAndView = new ModelAndView("huntercert-delete");

			modelAndView.addObject("horse_name", name);
			modelAndView.addObject("yob", yob);

		}

		if (phase.equals("confirm")) {
			modelAndView = new ModelAndView("redirect:/hunterCert/review");


			List<HunterCertItem> items = hCertBasket.getHunterCerts();
			hCertBasket.clearBasket();
			for (HunterCertItem item : items) {
				System.out.println(name + item.getCert().getHorse_name());
				if (!item.getCert().getHorse_name().toLowerCase()
						.equals(name.toLowerCase())) {
					System.out.println("Adding" + item.getCert().getHorse_name());
					hCertBasket.setCurrentItem(item);
					hCertBasket.addCurrentItemToBasket();
					hCertBasket.setCurrentItem(null);

				}
			
			}
			

		}

		if (phase.equals("cancel")) {
			modelAndView = new ModelAndView("redirect:/hunterCert/review");

		}

		return modelAndView;

	}

	
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String checkCompletion(String url) {

		// if there is no huntercert basket initialized return to step 1
		if ((url == null)
				|| url.contains("huntercert-handlerDetail") || url.contains("huntercert-review-payment")) {

			System.out.println(hCertBasket.hasUnfinishedItems());
			if (hCertBasket.hasUnfinishedItems()) {
				hCertBasket.clearBasket();
				if(url == null){
					return "redirect:/hunterCert/handlerDetail";
				}
				else{
					return url;
				}
				
				
			} else {
				if(url == null){
					return "redirect:/hunterCert/handlerDetail";
				}
				else{
					return url;
				}
			}

		} else if (hCertBasket.getCurrentItem() != null
				&& (url.contains("huntercert-handlerDetail") || url.contains("huntercert-review-payment"))) {
			if (hCertBasket.getCurrentItem().isUnFinished()) {
				return "redirect:/hunterCert/unFinishedItem";
			} else {
				return url;
			}

		}
	
		// if the handler has not been confirmed redirect to step 1
		else if (!hCertBasket.getCurrentItem().hasHandler()
				&& !url.contains("huntercert-handlerDetail")) {
			return "redirect:/hunterCert/handlerDetail";
		}
		// if the huntercert for the currentItem has not been initialized return
		// to horse select
		else if (!hCertBasket.getCurrentItem().hasCert()
				&& !url.contains("huntercert-horseDetail")
				&& !url.contains("huntercert-handlerDetail")) {
			return "redirect:/hunterCert/horseDetail";
		}
		// if the current item has no owner return to the owner page
		else if (!hCertBasket.getCurrentItem().hasOwner()
				&& !url.contains("huntercert-horseDetail")
				&& !url.contains("huntercert-handlerDetail")
				&& !url.contains("huntercert-ownerDetail")) {
			// System.out.println(!hCertBasket.getCurrentItem().hasOwner() +
			// url);
			return "redirect:/hunterCert/ownerDetail";
		} else if (!hCertBasket.getCurrentItem().hasHunt()
				&& !url.contains("huntercert-horseDetail")
				&& !url.contains("huntercert-handlerDetail")
				&& !url.contains("huntercert-ownerDetail")
				&& !url.contains("huntercert-huntDetail")) {
			// System.out.println(!hCertBasket.getCurrentItem().hasOwner() +
			// url);
			return "redirect:/hunterCert/huntDetail";
		} else if (!hCertBasket.getCurrentItem().hasVaccinations()
				&& !url.contains("huntercert-horseDetail")
				&& !url.contains("huntercert-handlerDetail")
				&& !url.contains("huntercert-ownerDetail")
				&& !url.contains("huntercert-huntDetail")
				&& !url.contains("huntercert-vaccinations")) {
			// System.out.println(!hCertBasket.getCurrentItem().hasOwner() +
			// url);
			return "redirect:/hunterCert/vaccinations";
		} else if (!hCertBasket.getCurrentItem().isConditionsAccepted()
				&& !url.contains("huntercert-horseDetail")
				&& !url.contains("huntercert-handlerDetail")
				&& !url.contains("huntercert-ownerDetail")
				&& !url.contains("huntercert-huntDetail")
				&& !url.contains("huntercert-vaccinations")
				&& !url.contains("huntercert-conditions")) {
			// System.out.println(!hCertBasket.getCurrentItem().hasOwner() +
			// url);
			return "redirect:/hunterCert/confirm";
		}

		else {
			return url;
		}

	}

	
	public boolean basketContainsHCert(String horseName){
		for(HunterCertItem item :hCertBasket.getHunterCerts()){
			if(item.getCert().getHorse_name().toLowerCase().equals(horseName.toLowerCase())){
				return true;
			}
			
		}
		return false;
		
	}
	
	

	// Example code for other controller types below needs to be commented out

	/*
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listOfHunterCertsB(Model model) {
		logger.info("IN: Hunter Cert/list-GET");

		List<HunterCert> hunterCerts = hunterCertService.getHunterCerts();
		model.addAttribute("huntercerts", hunterCerts);
		if (!model.containsAttribute("hunterCert")) {
			logger.info("Adding HunterCert object to model");
			HunterCert hunterCert = new HunterCert();
			model.addAttribute("hunterCert", hunterCert);
		}
		return "huntercert-list";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addingStrategy(@Valid @ModelAttribute HunterCert hunterCert,
			BindingResult result, RedirectAttributes redirectAttrs) {

		logger.info("IN: HunterCert/add-POST");

		if (result.hasErrors()) {
			logger.info("hunterCert-add error: " + result.toString());
			redirectAttrs.addFlashAttribute(
					"org.springframework.validation.BindingResult.hunterCert",
					result);
			redirectAttrs.addFlashAttribute("hunterCert", hunterCert);
			return "redirect:/hunterCert/list";
		} else {
			hunterCertService.addHunterCert(hunterCert);
			String message = "Hunter Cert was successfully added.";
			redirectAttrs.addFlashAttribute("message", message);
			return "redirect:/hunterCert/list";
		}
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String editHunterCertPage(Model model,
			@RequestParam(value = "id", required = true) Integer id) {
		logger.info("IN: Huntercert/edit-GET:  ID to query = " + id);

		if (!model.containsAttribute("hunterCert")) {
			logger.info("Adding huntercert object to model");
			HunterCert hunterCert = hunterCertService.getHunterCert(id);
			logger.info("HunterCert/edit-GET:  " + hunterCert.toString());
			model.addAttribute("hunterCert", hunterCert);
		}

		return "huntercert-edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String editingHunterCert(
			@Valid @ModelAttribute HunterCert hunterCert, BindingResult result,
			Model model, RedirectAttributes redirectAttrs,
			@RequestParam(value = "action", required = true) String action) {

		logger.info("IN: Strategy/edit-POST: " + action);

		System.out.println(action);
		if (action.equals(messageSource.getMessage("button.action.cancel",
				null, Locale.US))) {
			String message = "Hunter Cert " + hunterCert.getId()
					+ " edit cancelled";
			redirectAttrs.addFlashAttribute("message", message);
		} else if (result.hasErrors()) {
			logger.info("Strategy-edit error: " + result.toString());
			redirectAttrs.addFlashAttribute(
					"org.springframework.validation.BindingResult.hunterCert",
					result);
			redirectAttrs.addFlashAttribute("hunterCert", hunterCert);
			return "redirect:/hunterCert/edit?id=" + hunterCert.getId();
		} else if (action.equals(messageSource.getMessage("button.action.save",
				null, Locale.US))) {
			logger.info("hunterCert/edit-POST:  " + hunterCert.toString());
			hunterCertService.updateHunterCert(hunterCert);
			String message = "Hunter Cert " + hunterCert.getId()
					+ " was successfully edited";
			redirectAttrs.addFlashAttribute("message", message);
		}

		return "redirect:/hunterCert/list";
	}

	*/
	
	/*
	 * @RequestMapping(value = "/add", method = RequestMethod.POST) public
	 * ModelAndView addingHunterCert(
	 * 
	 * @ModelAttribute HunterCertDTO hunterCertDTO) { ModelAndView modelAndView
	 * = new ModelAndView( "redirect:/hunterCert/list"); HunterCert hunterCert =
	 * HunterCertMapper.getHunterCert(hunterCertDTO);
	 * hunterCertService.addHunterCert(hunterCert); String message =
	 * "Hunter Cert was successfully added."; modelAndView.addObject("message",
	 * message); return modelAndView; }
	 * 
	 * 
	 * @RequestMapping(value="/edit", method=RequestMethod.GET) public
	 * ModelAndView editHunterCertPage(
	 * 
	 * @RequestParam(value = "id", required = true) Integer id) { ModelAndView
	 * modelAndView = new ModelAndView("huntercert-edit"); HunterCert hunterCert
	 * = hunterCertService.getHunterCert(id); HunterCertDTO hunterCertDTO =
	 * HunterCertMapper.getDTO(hunterCert);
	 * modelAndView.addObject("hunterCertDTO", hunterCertDTO); return
	 * modelAndView; }
	 * 
	 * @RequestMapping(value="/edit", method=RequestMethod.POST) public
	 * ModelAndView editingHunterCert(
	 * 
	 * @ModelAttribute HunterCertDTO hunterCertDTO,
	 * 
	 * @RequestParam(value = "action", required = true) String action) {
	 * System.out.println("Using POST"); ModelAndView modelAndView = new
	 * ModelAndView( "redirect:/hunterCert/list"); String message = null; if
	 * (action.equals("save")) { HunterCert hunterCert =
	 * HunterCertMapper.getHunterCert(hunterCertDTO);
	 * hunterCertService.updateHunterCert(hunterCert); message = "Hunter Cert "
	 * + hunterCert.getId() +" was successfully edited.";
	 * modelAndView.addObject("message", message); }
	 * 
	 * if (action.equals("cancel")) { message = "Hunter Cert " +
	 * hunterCertDTO.getId() +" edit cancelled."; } return modelAndView; }
	 * 
	 * @RequestMapping(value="/delete", method=RequestMethod.GET) public
	 * ModelAndView deleteHunterCert(@RequestParam(value="id", required=true)
	 * Integer id,
	 * 
	 * @RequestParam(value="phase", required=true) String phase) {
	 * 
	 * 
	 * HunterCert hunterCert = hunterCertService.getHunterCert(id); ModelAndView
	 * modelAndView = null;
	 * 
	 * if (phase.equals("stage")) { modelAndView = new
	 * ModelAndView("huntercert-delete"); HunterCertDTO hunterCertDTO =
	 * HunterCertMapper.getDTO(hunterCert); String message = "Hunter Cert " +
	 * hunterCert.getId() + " queued for display.";
	 * modelAndView.addObject("hunterCertDTO",hunterCertDTO);
	 * modelAndView.addObject("message", message); }
	 * 
	 * if (phase.equals("confirm")) { modelAndView = new
	 * ModelAndView("redirect:/hunterCert/list");
	 * hunterCertService.deleteHunterCert(id); String message = "Hunter Cert " +
	 * hunterCert.getId() + " was successfully deleted";
	 * modelAndView.addObject("message", message); }
	 * 
	 * if (phase.equals("cancel")) { modelAndView = new
	 * ModelAndView("redirect:/hunterCert/list"); String message =
	 * "HunterCert delete was cancelled."; modelAndView.addObject("message",
	 * message); }
	 * 
	 * return modelAndView;
	 * 
	 * 
	 * }
	 */
}