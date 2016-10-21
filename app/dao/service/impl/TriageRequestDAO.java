package dao.service.impl;

import java.util.List;

import com.avaje.ebean.Ebean;

import dao.entity.TriageRequest;
import dao.service.ITriageRequestDAO;

public class TriageRequestDAO implements ITriageRequestDAO {

	@Override
	public Long getNextId() {

		StringBuilder sql = new StringBuilder();
		sql.append("select nextval('triage_request_seq') secuencia");

		return Ebean.createSqlQuery(sql.toString()).findUnique().getLong("secuencia");
	}

	@Override
	public TriageRequest get(Long id) {

		TriageRequest triageRequest = TriageRequest.find.byId(id);

		return triageRequest;

	}

	@Override
	public List<TriageRequest> list() {

		List<TriageRequest> triageRequests = TriageRequest.find.all();

		return triageRequests;
	}

	@Override
	public TriageRequest insert(TriageRequest triageRequest) {
		triageRequest.setId(getNextId());
		triageRequest.save();
		return triageRequest;
	}

	@Override
	public void delete(Long id) {
		TriageRequest triageRequest = get(id);
		triageRequest.delete();
	}

}
