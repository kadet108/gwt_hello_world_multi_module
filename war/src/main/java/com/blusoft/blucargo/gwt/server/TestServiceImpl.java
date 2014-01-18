package com.blusoft.blucargo.gwt.server;

import com.blusoft.blucargo.gwt.client.TestService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class TestServiceImpl extends RemoteServiceServlet implements TestService {

	public String test() {
		return "test";
	}

}
