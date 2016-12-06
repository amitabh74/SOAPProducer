package com.concretepage;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.concretepage.soap.GetStudentRequest;
import com.concretepage.soap.GetStudentResponse;

@Endpoint
public class StudentEndpoint {
	
	private static final String NAMESPACE_URI = "http://concretepage.com/soap";
	@Autowired
	private StudentUtility studentUtility;
	
	
	//@Resource
	//WebServiceContext wsctx;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStudentRequest")
	@ResponsePayload
	public GetStudentResponse getCountry(@RequestPayload GetStudentRequest request) {
		
		GetStudentResponse response = null;
		
		response = new GetStudentResponse();
		response.setStudent(studentUtility.getStudent(request.getStudentId()));
	
		return response;
	}

}
