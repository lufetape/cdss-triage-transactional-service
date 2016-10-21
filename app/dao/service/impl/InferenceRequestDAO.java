package dao.service.impl;

import java.util.List;

import dao.entity.InferenceRequest;
import dao.service.IInferenceRequestDAO;

import com.avaje.ebean.Ebean;

public class InferenceRequestDAO implements IInferenceRequestDAO {
	
	@Override
	public Long getNextId() {

		StringBuilder sql = new StringBuilder();
		sql.append("select nextval('inference_request_seq') secuencia");

		return Ebean.createSqlQuery(sql.toString()).findUnique().getLong("secuencia");
	}
	
	@Override
	public InferenceRequest get(Long id) {

		InferenceRequest inferenceRequest = InferenceRequest.find.byId(id);

		return inferenceRequest;
	}
	
	@Override
	public List<InferenceRequest> list() {

		List<InferenceRequest> inferenceRequestLst = InferenceRequest.find.all();

		return inferenceRequestLst;
	}

	@Override
	public InferenceRequest insert(InferenceRequest inferenceRequest) {
		inferenceRequest.setId(getNextId());
		inferenceRequest.save();
		return inferenceRequest;

	}

	

	@Override
	public void delete(Long id) {
		
		InferenceRequest inferenceRequest = get(id);
		inferenceRequest.delete();

	}

	

	

	
}
