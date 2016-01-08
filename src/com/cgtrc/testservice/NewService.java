package com.cgtrc.testservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class NewService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("onBind ���񱻳ɹ�����");
		return new MyBinder();
	}
	
	private class MyBinder extends Binder implements IService{
		@Override
		public void callChangeSong(String name) {
			singASong(name);
		}
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		System.out.println("onCreate()����ʼ");
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		System.out.println("onDestroy()����ֹͣ");
	}
	
	@Override
	public boolean onUnbind(Intent intent) {
		System.out.println("unbind service ��������");
		return super.onUnbind(intent);
	}
	
	public void singASong(String songName){
		Toast.makeText(getApplicationContext(), "��ʼ����" + songName, Toast.LENGTH_LONG).show();
	}
	
	

}
