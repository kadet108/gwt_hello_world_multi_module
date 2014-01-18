package com.blusoft.blucargo.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TestServiceAsync {

	void test(AsyncCallback<String> callback);

}
