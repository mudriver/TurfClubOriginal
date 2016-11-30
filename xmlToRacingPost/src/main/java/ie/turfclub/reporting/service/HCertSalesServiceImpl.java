package ie.turfclub.reporting.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ie.turfclub.reporting.dao.HCertSalesDAO;
import ie.turfclub.reporting.model.pointToPoint.HuntercertsSales;



@Service
@Transactional
public class HCertSalesServiceImpl implements HCertSalesService {

	@Autowired
	HCertSalesDAO salesDao;
	
	@Override
	public void addP2PHunterCertsSales(HuntercertsSales sale) {
		salesDao.addHunterCertSales(sale);

	}

	

}
