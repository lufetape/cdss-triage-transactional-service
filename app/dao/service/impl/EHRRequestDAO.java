package dao.service.impl;

import java.util.List;

import dao.entity.EHRRequest;
import dao.service.IEHRRequestDAO;
import com.avaje.ebean.Ebean;

public class EHRRequestDAO implements IEHRRequestDAO {

	@Override
	public Long getNextId() {

		StringBuilder sql = new StringBuilder();
		sql.append("select nextval('ehr_request_seq') secuencia");

		return Ebean.createSqlQuery(sql.toString()).findUnique().getLong("secuencia");
	}

	@Override
	public EHRRequest get(Long id) {

		EHRRequest ehrRequest = EHRRequest.find.byId(Long.valueOf(id));

		return ehrRequest;
	}

	@Override
	public List<EHRRequest> list() {

		List<EHRRequest> ehrRequestLst = EHRRequest.find.all();

		return ehrRequestLst;
	}

	@Override
	public EHRRequest insert(EHRRequest ehrRequest) {
		ehrRequest.setId(getNextId());
		ehrRequest.save();
		return ehrRequest;
	}

	@Override
	public void delete(Long id) {

		EHRRequest ehrRequest = get(id);
		ehrRequest.delete();

	}

}
