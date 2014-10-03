package es.keensoft.alfresco.behaviour;

import java.io.Serializable;
import java.util.Map;

import org.alfresco.model.ContentModel;
import org.alfresco.model.ImapModel;
import org.alfresco.repo.node.NodeServicePolicies;
import org.alfresco.repo.policy.Behaviour.NotificationFrequency;
import org.alfresco.repo.policy.JavaBehaviour;
import org.alfresco.repo.policy.PolicyComponent;
import org.alfresco.service.cmr.model.FileFolderService;
import org.alfresco.service.cmr.repository.NodeRef;
import org.alfresco.service.cmr.repository.NodeService;
import org.alfresco.service.namespace.QName;

import com.thoughtworks.xstream.core.util.Base64Encoder;

public class ImapContentBehaviour implements NodeServicePolicies.OnUpdatePropertiesPolicy {
	
	private NodeService nodeService;
	private FileFolderService fileFolderService;
	private PolicyComponent policyComponent;
	
	@Override
	public void onUpdateProperties(NodeRef nodeRef, Map<QName, Serializable> before, Map<QName, Serializable> after) {
		
		if (before.get(ContentModel.PROP_TITLE) == null ||
		   !before.get(ContentModel.PROP_TITLE).equals(after.get(ContentModel.PROP_TITLE))) {
			
			String intendedName = nodeService.getProperty(nodeRef, ContentModel.PROP_TITLE) + ".eml";
			
			try {
				fileFolderService.rename(nodeRef, intendedName);
			} catch (Exception e) {
				// ELM node not renamed...
	        }
			
		}
		
	}
	
	public void init() {
		policyComponent.bindClassBehaviour(
				NodeServicePolicies.OnUpdatePropertiesPolicy.QNAME, 
				ImapModel.ASPECT_IMAP_CONTENT, 
				new JavaBehaviour(this, "onUpdateProperties", NotificationFrequency.TRANSACTION_COMMIT));
	}
	
	public void setPolicyComponent(PolicyComponent policyComponent) {
		this.policyComponent = policyComponent;
	}

	public void setNodeService(NodeService nodeService) {
		this.nodeService = nodeService;
	}

	public void setFileFolderService(FileFolderService fileFolderService) {
		this.fileFolderService = fileFolderService;
	}
	
	public static void main(String... args) throws Exception {
		Base64Encoder b = new Base64Encoder();
		System.out.println(b.encode("http://localhost:8080/alfresco/sites/Mi sitio/en un lugar/de la mancha/de cuyo/nombre no quiero acordarme/documento.txt".getBytes()));
	}

}
