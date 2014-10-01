package es.keensoft.repo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class CustomSpringBeanPostProcessor implements BeanFactoryPostProcessor, ApplicationContextAware {
	
    private static ApplicationContext ctx = null;

    public static ApplicationContext getApplicationContext() {
        return ctx;
    }
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
         ctx = applicationContext;
    }
    
	private static final Log logger = LogFactory.getLog(CustomSpringBeanPostProcessor.class);
	
	private String beanName;
	private String propertyName;
	private Boolean propertyValue;
		
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
		BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
		if (bd == null) {
			logger.warn("Bean " + beanName + " not found!");
		} else {
			PropertyValue pv = bd.getPropertyValues().getPropertyValue(propertyName);
			if (pv == null) {
				logger.warn("Property " + propertyName + " from bean " + beanName + " has no value!");
			} else {
				bd.getPropertyValues().add(propertyName, propertyValue);
			}
		}
		
	}
	
	public String getBeanName() {
		return beanName;
	}
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public Boolean getPropertyValue() {
		return propertyValue;
	}
	public void setPropertyValue(Boolean propertyValue) {
		this.propertyValue = propertyValue;
	}


}
