package dao.service;

import java.util.List;

import dao.entity.EHRRequest;


public interface IEHRRequestDAO {
	
	public EHRRequest insert (EHRRequest ehrRequest);
	
	public void delete (Long id);
	
	public EHRRequest get (Long id);
	
	public List<EHRRequest> list ();
	
	public Long getNextId();

}
