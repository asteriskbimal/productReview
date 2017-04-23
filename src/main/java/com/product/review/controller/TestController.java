//package com.product.review.controller;
//
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.BeanFactoryAware;
//import org.springframework.beans.factory.BeanNameAware;
//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.stereotype.Component;
//
//@Component
//public class TestController implements BeanNameAware,BeanFactoryAware, InitializingBean,DisposableBean {
//
//	private void init() {
//		System.out.println("Init Method");
//
//	}
//	
//	@Override
//	public void destroy() throws Exception {
//		System.out.println("destory bean");
//		
//	}
//
//	@Override
//	public void afterPropertiesSet() throws Exception {
//		System.out.println("afterPropertiesSet");
//		
//	}
//
//	@Override
//	public void setBeanFactory(BeanFactory arg0) throws BeansException {
//		System.out.println(arg0);
//		
//	}
//
//	@Override
//	public void setBeanName(String arg0) {
//		System.out.println(arg0);
//		
//	}
//
//}
