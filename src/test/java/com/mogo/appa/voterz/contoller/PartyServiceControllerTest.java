/**
 * Copyright 2012 <http://mogomantra.com>.
 * Author: mogo <https://github.com/mogomantra>.
 * Date : Jun 16, 2012
 *
 * Copyright to MoGo Mantra Inc.

 */
package com.mogo.appa.voterz.contoller;

import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.springframework.web.servlet.mvc.annotation.DefaultAnnotationHandlerMapping;

/**
 * @author mogo
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration({"classpath:src/webapp/WEB-INF/rest-dispatcher-servlet.xml"})
@ContextConfiguration(locations = { "classpath:test-application-context.xml" })
public class PartyServiceControllerTest {

	@Inject
	private ApplicationContext applicationContext;

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private HandlerMapping handlerMapping;
	private HandlerAdapter handlerAdapter;

	@Before
	public void setUp() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		// handlerAdapter = new AnnotationMethodHandlerAdapter();
		// applicationContext.getBean(HandlerAdapter.class);

		handlerMapping = applicationContext.getAutowireCapableBeanFactory()
				.createBean(DefaultAnnotationHandlerMapping.class);

		// I could get the controller from the context here
		handlerAdapter = applicationContext.getAutowireCapableBeanFactory()
				.createBean(AnnotationMethodHandlerAdapter.class);
	}

	ModelAndView handle(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		final HandlerExecutionChain handler = handlerMapping
				.getHandler(request);
		Assert.assertNotNull(
				"No handler found for request, check you request mapping",
				handler);

		final Object controller = handler.getHandler();
		// if you want to override any injected attributes do it here

//		final HandlerInterceptor[] interceptors = handlerMapping.getHandler(
//				request).getInterceptors();
//		for (HandlerInterceptor interceptor : interceptors) {
//			final boolean carryOn = interceptor.preHandle(request, response,
//					controller);
//			if (!carryOn) {
//				return null;
//			}
//		}

		final ModelAndView mav = handlerAdapter.handle(request, response,
				controller);
		return mav;
	}

	@Test
	public void testDoSomething() throws Exception {
		request.setRequestURI("/partyService/BSP");
		request.setMethod("GET");
		request.addHeader("Accept", "application/json");
		//final ModelAndView mav = handle(request, response);
		//ModelAndViewAssert.assertViewName(mav, "view");
		// assert something
	}
}
