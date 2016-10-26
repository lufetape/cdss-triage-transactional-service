import com.google.inject.AbstractModule;

import api.mapper.IDocumentTypeResourceMapper;
import api.mapper.IEHRRequestResourceMapper;
import api.mapper.IHECRequestResourceMapper;
import api.mapper.IInferenceRequestResourceMapper;
import api.mapper.IRequestStatusResourceMapper;
import api.mapper.ITriageRequestResourceMapper;
import api.mapper.impl.DocumentTypeResourceMapper;
import api.mapper.impl.EHRRequestResourceMapper;
import api.mapper.impl.HECRequestResourceMapper;
import api.mapper.impl.InferenceRequestResourceMapper;
import api.mapper.impl.RequestStatusResourceMapper;
import api.mapper.impl.TriageRequestResourceMapper;
import businesslogic.service.IHECRequestService;
import businesslogic.service.IInferenceRequestService;
import businesslogic.service.impl.HECRequestService;
import businesslogic.service.impl.InferenceRequestService;
import dao.service.IHECRequestDAO;
import dao.service.IInferenceRequestDAO;
import dao.service.impl.HECRequestDAO;
import dao.service.impl.InferenceRequestDAO;
import businesslogic.mapper.IDocumentTypeServiceMapper;
import businesslogic.mapper.IEHRRequestServiceMapper;
import businesslogic.mapper.IHECRequestServiceMapper;
import businesslogic.mapper.IInferenceRequestServiceMapper;
import businesslogic.mapper.IRequestStatusServiceMapper;
import businesslogic.mapper.ITriageRequestServiceMapper;
import businesslogic.mapper.impl.DocumentTypeServiceMapper;
import businesslogic.mapper.impl.EHRRequestServiceMapper;
import businesslogic.mapper.impl.HECRequestServiceMapper;
import businesslogic.mapper.impl.InferenceRequestServiceMapper;
import businesslogic.mapper.impl.RequestStatusServiceMapper;
import businesslogic.mapper.impl.TriageRequestServiceMapper;
import businesslogic.service.IDocumentTypeService;
import businesslogic.service.IEHRRequestService;
import businesslogic.service.impl.DocumentTypeService;
import businesslogic.service.impl.EHRRequestService;
import dao.service.IDocumentTypeDAO;
import dao.service.IEHRRequestDAO;
import dao.service.impl.DocumentTypeDAO;
import dao.service.impl.EHRRequestDAO;
import businesslogic.service.IRequestStatusService;
import businesslogic.service.ITriageRequestService;
import businesslogic.service.impl.RequestStatusService;
import businesslogic.service.impl.TriageRequestService;
import dao.service.IRequestStatusDAO;
import dao.service.ITriageRequestDAO;
import dao.service.impl.RequestStatusDAO;
import dao.service.impl.TriageRequestDAO;




/**
 * This class is a Guice module that tells Guice how to bind several
 * different types. This Guice module is created when the Play
 * application starts.
 *
 * Play will automatically use any class called `Module` that is in
 * the root package. You can create modules in other locations by
 * adding `play.modules.enabled` settings to the `application.conf`
 * configuration file.
 */
public class Module extends AbstractModule {

    @Override
    public void configure() {
    	
        // Use the system clock as the default implementation of Clock
    	bind(IRequestStatusService.class).to(RequestStatusService.class);
    	bind(IRequestStatusDAO.class).to(RequestStatusDAO.class);
    	bind(IRequestStatusResourceMapper.class).to(RequestStatusResourceMapper.class);
    	bind(IRequestStatusServiceMapper.class).to(RequestStatusServiceMapper.class);
    	
    	bind(IDocumentTypeService.class).to(DocumentTypeService.class);
    	bind(IDocumentTypeDAO.class).to(DocumentTypeDAO.class);
    	bind(IDocumentTypeResourceMapper.class).to(DocumentTypeResourceMapper.class);
    	bind(IDocumentTypeServiceMapper.class).to(DocumentTypeServiceMapper.class);
    	    	
    	bind(IHECRequestService.class).to(HECRequestService.class);
    	bind(IHECRequestDAO.class).to(HECRequestDAO.class);
    	bind(IHECRequestResourceMapper.class).to(HECRequestResourceMapper.class);
    	bind(IHECRequestServiceMapper.class).to(HECRequestServiceMapper.class);
    	    	    	
    	bind(IEHRRequestService.class).to(EHRRequestService.class);
    	bind(IEHRRequestDAO.class).to(EHRRequestDAO.class);
    	bind(IEHRRequestResourceMapper.class).to(EHRRequestResourceMapper.class);
    	bind(IEHRRequestServiceMapper.class).to(EHRRequestServiceMapper.class);
    	
    	bind(IInferenceRequestService.class).to(InferenceRequestService.class);
    	bind(IInferenceRequestDAO.class).to(InferenceRequestDAO.class);
    	bind(IInferenceRequestResourceMapper.class).to(InferenceRequestResourceMapper.class);
    	bind(IInferenceRequestServiceMapper.class).to(InferenceRequestServiceMapper.class);
    	
    	bind(ITriageRequestService.class).to(TriageRequestService.class);
    	bind(ITriageRequestDAO.class).to(TriageRequestDAO.class);
    	bind(ITriageRequestResourceMapper.class).to(TriageRequestResourceMapper.class);
    	bind(ITriageRequestServiceMapper.class).to(TriageRequestServiceMapper.class);
    	
        
    }

}
