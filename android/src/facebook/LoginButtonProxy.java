/**
  * Copyright (c) 2015 by Appcelerator, Inc. All Rights Reserved.
  * Licensed under the terms of the Apache Public License 2.0
  * Please see the LICENSE included with this distribution for details.
  *
  */
package facebook;

import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.view.TiUIView;

import android.app.Activity;

@Kroll.proxy(creatableInModule = TiFacebookModule.class, propertyAccessors={
	"audience",
	"publishPermissions",
	"readPermissions",
	"sessionLoginBehavior"
 })
public class LoginButtonProxy extends TiViewProxy {
	// Standard Debugging variables
	private static final String TAG = "LoginButtonProxy";

	public LoginButtonProxy() {
		super();
	}
			
	@Override
	public TiUIView createView(Activity activity) 
	{
		return new LoginButtonView(this);
	}

}
