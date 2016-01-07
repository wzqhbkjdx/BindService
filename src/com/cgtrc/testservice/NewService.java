package com.cgtrc.testservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

public class NewService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		System.out.println("服务被成功绑定了");
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
		System.out.println("服务开始");
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		System.out.println("服务停止");
	}
	
	public void singASong(String songName){
		Toast.makeText(getApplicationContext(), "开始唱歌" + songName, Toast.LENGTH_LONG).show();
	}
	
	

}
