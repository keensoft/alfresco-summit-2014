package es.keensoft.repo.security.authentication.ldap;

import java.util.Map;

import org.alfresco.repo.security.authentication.AuthenticationException;
import org.alfresco.repo.security.authentication.ldap.LDAPAuthenticationComponentImpl;
import org.alfresco.repo.security.sync.ldap.LDAPNameResolver;

public class CustomDNLDAPAuthenticationComponentImpl extends LDAPAuthenticationComponentImpl {
	
    protected void authenticateImpl(String userName, char[] password) throws AuthenticationException {
    	
        if (userName.indexOf("@") != -1) {
        	String mailDomain = userName.substring(userName.indexOf("@") + 1);
        	String patchedUserName = userName.substring(0, userName.indexOf("@"));
            String dnPattern = (mailDomain == null ? null : mailDomainLdapMapping.get(mailDomain));
            if (mailDomain != null && dnPattern != null && userNameFormat.indexOf(dnPattern) != -1) {
            	userName = patchedUserName;
            }
        }
        
        super.authenticateImpl(userName, password);
    }
    
    private boolean active = true;

    private String userNameFormat;
    
    private Map<String, String> mailDomainLdapMapping;
    
	private LDAPNameResolver ldapNameResolver;

	public CustomDNLDAPAuthenticationComponentImpl()
    {
        super();
    }

    public void setUserNameFormat(String userNameFormat)
    {
        this.userNameFormat = userNameFormat == null || userNameFormat.length() == 0 ? null : userNameFormat;
    }
        
    public void setLdapNameResolver(LDAPNameResolver ldapNameResolver)
    {
        this.ldapNameResolver = ldapNameResolver;
    }

    public void setActive(boolean active)
    {
        this.active = active;
    }
    
    public void setMailDomainLdapMapping(Map<String, String> mailDomainLdapMapping) {
		this.mailDomainLdapMapping = mailDomainLdapMapping;
	}

    /*
     * (non-Javadoc)
     * @see org.alfresco.repo.management.subsystems.ActivateableBean#isActive()
     */
    public boolean isActive()
    {
        return this.active;
    }        

    /*
     * (non-Javadoc)
     * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
     */
    public void afterPropertiesSet() throws Exception
    {
        if (this.ldapNameResolver == null && this.userNameFormat == null) {
            throw new IllegalStateException("At least one of ldapNameResolver and userNameFormat must be set");
        }
    }
    
}
