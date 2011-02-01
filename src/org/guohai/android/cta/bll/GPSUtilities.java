/**
 * �˳���Ϊ��Դ������ѭGPLv3�汾�����������䱣����
 * (GPLv3 http://www.gnu.org/licenses/gpl.html)
 * Copyright 2011 by H!Guo
 */
package org.guohai.android.cta.bll;

import android.content.*;
import android.location.*;

/**
 * Get GPS Corrdinate 
 * @author H!Guo
 */
public class GPSUtilities {
	
	private Context context;
	public double Latitude;
	public double Longitude;
	
	/** ���캯�� */
	public GPSUtilities(Context parm){
		context = parm;
	}
	
	/** ����豸�Ƿ��� */
	public boolean openGPSSettings(){
		LocationManager alm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		if(alm.isProviderEnabled(android.location.LocationManager.GPS_PROVIDER)){
			return true;
		}
		return false;
	}
	
	/** ȡ���� */
	public boolean getLocation(){
		//ȡλ�ù������
		LocationManager locationManager;
		locationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
		//���ҷ�����Ϣ
		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		criteria.setAltitudeRequired(false);
		criteria.setBearingRequired(false);
		criteria.setCostAllowed(true);
		criteria.setPowerRequirement(Criteria.POWER_LOW);
		//try{
			String provider = locationManager.getBestProvider(criteria, true);
			Location location = locationManager.getLastKnownLocation(provider);
			if(null != location){
				Latitude = location.getLatitude();
				Longitude= location.getLongitude();
			}
		//}
			//locationManager.requestLocationUpdates(provider, 100*1000, 500, listener)
			return true;
	}
}
