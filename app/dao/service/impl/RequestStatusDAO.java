package dao.service.impl;

import java.util.List;

import com.avaje.ebean.Ebean;

import dao.entity.RequestStatus;
import dao.service.IRequestStatusDAO;

public class RequestStatusDAO implements IRequestStatusDAO {

	@Override
	public Long getNextId() {

		StringBuilder sql = new StringBuilder();
		sql.append("select nextval('requeststatus_seq') secuencia");

		return Ebean.createSqlQuery(sql.toString()).findUnique().getLong("secuencia");
	}

	@Override
	public RequestStatus get(Long id) {

		RequestStatus requestStatus = RequestStatus.find.byId(id);

		return requestStatus;
	}

	@Override
	public List<RequestStatus> list() {

		List<RequestStatus> requestStatusLst = RequestStatus.find.all();

		return requestStatusLst;
	}

	@Override
	public RequestStatus insert(RequestStatus requestStatus) {
		requestStatus.setId(getNextId());
		requestStatus.save();
		return requestStatus;

	}

	@Override
	public void update(RequestStatus requestStatus) {
		requestStatus.update();

	}

	@Override
	public void delete(Long id) {
		RequestStatus requestStatus = get(id);
		requestStatus.delete();

	}

}
