package dao.service;

import java.util.List;

import dao.entity.RequestStatus;



public interface IRequestStatusDAO {
	
	public RequestStatus insert (RequestStatus requestStatus);
	
	public void update (RequestStatus requestStatus);
	
	public void delete (Long id);
	
	public RequestStatus get (Long id);
	
	public List<RequestStatus> list ();
	
	public Long getNextId();

}
