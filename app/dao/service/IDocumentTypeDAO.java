package dao.service;

import java.util.List;

import dao.entity.DocumentType;

public interface IDocumentTypeDAO {

	public DocumentType insert(DocumentType documentType);

	public void update(DocumentType documentType);

	public void delete(Long id);

	public DocumentType get(Long id);

	public List<DocumentType> list();

	public Long getNextId();

}
