package com.cgtrc.testservice;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

public class MainActivity extends Activity {
	
	private IService myBinder;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void start(View view)
	{
		Intent intent = new Intent(MainActivity.this,NewService.class);
		startService(intent);
	}
	
	public void stop(View view)
	{
		Intent intent = new Intent(MainActivity.this,NewService.class);
		stopService(intent);
	}
	
	public void change(View view)
	{
		myBinder.callChangeSong("冬天里的一把火");
	}
	
	public void bind(View view)
	{
		Intent intent = new Intent(MainActivity.this,NewService.class);
		bindService(intent, new MyConn(), BIND_AUTO_CREATE);
	}
	
	public void unbind(View view)
	{
		
	}
	
	private class MyConn implements ServiceConnection{

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			System.out.println("得到服务的代理人IBinder");
			myBinder =  (IService) service;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
		
	}

	
}
