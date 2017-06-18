/**
 * Copyright (c) 2014 by Mark Mokryn All Rights Reserved.
 * Licensed under the terms of the Apache Public License 2.0
 * Please see the LICENSE included with this distribution for details.
 *
 * Appcelerator Titanium Mobile
 * Copyright (c) 2015 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */

package facebook;

import org.appcelerator.titanium.view.TiUIView;

import java.util.HashMap;

import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.util.TiColorHelper;
import org.appcelerator.titanium.util.TiConvert;

import com.facebook.share.widget.LikeView;
import com.facebook.share.widget.LikeView.AuxiliaryViewPosition;
import com.facebook.share.widget.LikeView.HorizontalAlignment;
import com.facebook.share.widget.LikeView.Style;


public class LikeButtonView extends TiUIView 
{
	private static final String TAG = "LikeButtonView";
	private LikeView likeView;
		
	public LikeButtonView(TiViewProxy proxy) 
	{
		super(proxy);
				
		likeView = new LikeView(proxy.getActivity());
		// Set the view as the native view. You must set the native view
		// for your view to be rendered correctly.
		setNativeView(likeView);
	}
		
	// The view is automatically registered as a model listener when the view
	// is realized by the view proxy. That means that the processProperties
	// method will be called during creation and that propertiesChanged and 
	// propertyChanged will be called when properties are changed on the proxy.
	private void setLikeViewStyle(String name) {
		for(Style style : Style.values()) { 
			if (style.name().toString().equalsIgnoreCase(name)) {
				likeView.setLikeViewStyle(style);
				break;
			}
		}		
	}

	private void setAuxiliaryViewPosition(String name) {
		for(AuxiliaryViewPosition avp : AuxiliaryViewPosition.values()) { 
			if (avp.name().toString().equalsIgnoreCase(name)) {
				likeView.setAuxiliaryViewPosition(avp);
				break;
			}
		}		
	}
	
	private void setHorizontalAlignment(String name) {
		for(HorizontalAlignment ha : HorizontalAlignment.values()) { 
			if (ha.name().toString().equalsIgnoreCase(name)) {
				likeView.setHorizontalAlignment(ha);
				break;
			}
		}		
	}
	
	@Override
	public void processProperties(HashMap props) 
	{
		super.processProperties(props);
		if (props.containsKey("objectId")) {
			likeView.setObjectIdAndType(TiConvert.toString(props, "objectId"),LikeView.ObjectType.PAGE);
		}
		if (props.containsKey("likeViewStyle")) {
			//likeView.setLikeViewStyle(Style.values()[props.getInt("likeViewStyle")]);
			String styleName = TiConvert.toString(props, "likeViewStyle");
			setLikeViewStyle(styleName);

		}
		if (props.containsKey("auxiliaryViewPosition")) {
			String positionName = TiConvert.toString(props, "auxiliaryViewPosition");
			setAuxiliaryViewPosition(positionName);
		}
		if (props.containsKey("horizontalAlignment")) {
			String haName = TiConvert.toString(props, "horizontalAlignment");
			setHorizontalAlignment(haName);
		}
		if (props.containsKey("foregroundColor")) {
			likeView.setForegroundColor(TiColorHelper.parseColor(TiConvert.toString(props, "foregroundColor")));
		}		
	}
	
	@Override
	public void propertyChanged(String key, Object oldValue, Object newValue, KrollProxy proxy)
	{
		// This method is called whenever a proxy property value is updated. Note that this 
		// method is only called if the new value is different than the current value.
		if (key.equals("objectID")) {
			likeView.setObjectIdAndType(TiConvert.toString(newValue),LikeView.ObjectType.PAGE);
		} else if (key.equals("likeViewStyle")) {
			setLikeViewStyle(TiConvert.toString(newValue));
		} else if (key.equals("auxiliaryViewPosition")) {
			setAuxiliaryViewPosition(TiConvert.toString(newValue));
		} else if (key.equals("horizontalAlignment")) {
			setHorizontalAlignment(TiConvert.toString(newValue));
		} else if (key.equals("foregroundColor")) {
			likeView.setForegroundColor(TiColorHelper.parseColor(TiConvert.toString(newValue)));
		} else {
			super.propertyChanged(key, oldValue, newValue, proxy);
		}
	}
	
}
