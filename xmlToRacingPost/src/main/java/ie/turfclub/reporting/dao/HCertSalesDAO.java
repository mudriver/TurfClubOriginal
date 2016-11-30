package ie.turfclub.reporting.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ie.turfclub.reporting.model.pointToPoint.HuntercertsSales;

@Repository
@Transactional
public interface HCertSalesDAO {

	public void addHunterCertSales(HuntercertsSales sale);

}
