package ie.turfclub.reporting.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ie.turfclub.reporting.model.discips.DisEnquiriesTable;

@Repository
@Transactional
public interface DisciplinariesDAO {

	public void update(DisEnquiriesTable disciplinary);
	public List<DisEnquiriesTable> getUnProcessedAccounts(String maxDate);
}
