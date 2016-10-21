package dao.service;

import java.util.List;

import dao.entity.InferenceRequest;

public interface IInferenceRequestDAO {

	public InferenceRequest insert(InferenceRequest inferenceRequest);

	public void delete(Long id);

	public InferenceRequest get(Long id);

	public List<InferenceRequest> list();

	public Long getNextId();

}
