package es.keensoft.alfresco.behaviour;

import org.alfresco.model.ContentModel;
import org.alfresco.repo.content.ContentServicePolicies;
import org.alfresco.repo.policy.Behaviour.NotificationFrequency;
import org.alfresco.repo.policy.JavaBehaviour;
import org.alfresco.repo.policy.PolicyComponent;
import org.alfresco.service.cmr.repository.ContentData;
import org.alfresco.service.cmr.repository.MimetypeService;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.cmr.repository.NodeService;
import org.alfresco.service.namespace.QName;
import org.apache.commons.io.FilenameUtils;

public class ContentBehaviour implements ContentServicePolicies.OnContentPropertyUpdatePolicy {
	
	private NodeService nodeService;
	private MimetypeService mimetypeService;
	private PolicyComponent policyComponent;
	
	
	@Override
	public void onContentPropertyUpdate(NodeRef nodeRef, QName propertyQName, 
			ContentData beforeValue, ContentData afterValue) {
		
	    if (beforeValue != null &&
	    	!beforeValue.getMimetype().equals(afterValue.getMimetype())) {
	    	
		    String name = nodeService.getProperty(nodeRef, ContentModel.PROP_NAME).toString();
	    	String nameNoExt = FilenameUtils.getBaseName(name);
	    	String newExt = mimetypeService.getExtension(afterValue.getMimetype());
			nodeService.setProperty(nodeRef, ContentModel.PROP_NAME, nameNoExt + "." + newExt);
			
	    }
	    
	}

	public void init() {
		policyComponent.bindClassBehaviour(
				ContentServicePolicies.OnContentPropertyUpdatePolicy.QNAME, 
				ContentModel.TYPE_CONTENT, 
				new JavaBehaviour(this, "onContentPropertyUpdate", NotificationFrequency.EVERY_EVENT));
	}
	
	public void setNodeService(NodeService nodeService) {
		this.nodeService = nodeService;
	}


	public void setPolicyComponent(PolicyComponent policyComponent) {
		this.policyComponent = policyComponent;
	}

	public void setMimetypeService(MimetypeService mimetypeService) {
		this.mimetypeService = mimetypeService;
	}

}
