package dao.service.impl;

import java.util.List;

import com.avaje.ebean.Ebean;

import dao.entity.HECRequest;
import dao.service.IHECRequestDAO;

public class HECRequestDAO implements IHECRequestDAO {

	@Override
	public Long getNextId() {

		StringBuilder sql = new StringBuilder();
		sql.append("select nextval('hec_request_seq') secuencia");

		return Ebean.createSqlQuery(sql.toString()).findUnique().getLong("secuencia");
	}

	@Override
	public List<HECRequest> list() {

		List<HECRequest> hecRequestLst = HECRequest.find.all();

		return hecRequestLst;
	}

	@Override
	public HECRequest get(Long id) {

		HECRequest hecRequest = HECRequest.find.byId(id);

		return hecRequest;

	}

	@Override
	public HECRequest insert(HECRequest hecRequest) {
		hecRequest.setId(getNextId());
		hecRequest.save();
		return hecRequest;
	}

	@Override
	public void delete(Long id) {
		HECRequest hecRequest = get(id);
		hecRequest.delete();

	}

}
