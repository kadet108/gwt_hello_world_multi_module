package org.codehaus.mojo.gwt.test.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class Hello
    implements EntryPoint
{

    public void onModuleLoad()
    {
        final Label l = new Label( "GWT says : hello");
        RootPanel.get().add( l );

        Button b = new Button( "click me !" );
        RootPanel.get().add( b );

    }
}
