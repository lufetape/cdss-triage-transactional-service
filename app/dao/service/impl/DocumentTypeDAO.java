package dao.service.impl;

import java.util.List;

import com.avaje.ebean.Ebean;

import dao.entity.DocumentType;
import dao.service.IDocumentTypeDAO;

public class DocumentTypeDAO implements IDocumentTypeDAO {

	@Override
	public Long getNextId() {

		StringBuilder sql = new StringBuilder();
		sql.append("select nextval('document_type_seq') secuencia");

		return Ebean.createSqlQuery(sql.toString()).findUnique().getLong("secuencia");
	}

	@Override
	public DocumentType get(Long id) {

		DocumentType documentType = DocumentType.find.byId(id);

		return documentType;
	}

	@Override
	public List<DocumentType> list() {

		List<DocumentType> documentTypeLst = DocumentType.find.all();

		return documentTypeLst;
	}

	@Override
	public DocumentType insert(DocumentType documentType) {
		documentType.setId(getNextId());
		documentType.save();
		return documentType;

	}

	@Override
	public void update(DocumentType documentType) {
		documentType.update();
	}

	@Override
	public void delete(Long id) {
		DocumentType documentType = get(id);
		documentType.delete();

	}

}
