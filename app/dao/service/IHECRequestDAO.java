package dao.service;

import java.util.List;

import dao.entity.HECRequest;

public interface IHECRequestDAO {
	
	public HECRequest insert (HECRequest hecRequest);
	
	public void delete (Long id);
	
	public HECRequest get (Long id);
	
	public List<HECRequest> list ();
	
	public Long getNextId();

}
