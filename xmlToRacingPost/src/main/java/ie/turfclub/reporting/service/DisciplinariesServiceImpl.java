package ie.turfclub.reporting.service;

import ie.turfclub.reporting.dao.DisciplinariesDAO;
import ie.turfclub.reporting.model.discips.DisEnquiriesTable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DisciplinariesServiceImpl implements DisciplinariesService {

	@Autowired
	private DisciplinariesDAO discipDAO;
	
	@Override
	public void updateAccountsProcessedOnDisciplinaries(String maxDateToUpdate) {
		
		for(DisEnquiriesTable enqs : discipDAO.getUnProcessedAccounts(maxDateToUpdate)){
			enqs.setRecAccountsProcessed(true);
			//discipDAO.update(enqs);
		}
	}

}
