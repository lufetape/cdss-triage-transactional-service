package dao.service;

import java.util.List;

import dao.entity.TriageRequest;

public interface ITriageRequestDAO {
	
	public Long getNextId();
	
	public List<TriageRequest> list();
	
	public TriageRequest get(Long id);

	public TriageRequest insert(TriageRequest hecRequest);

	public void delete(Long id);

}
