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
	private MyConn myConn = new MyConn();

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
		myBinder.callChangeSong("�������һ�ѻ�");
	}
	
	public void bind(View view)
	{
		Intent intent = new Intent(MainActivity.this,NewService.class);
		bindService(intent, myConn, BIND_AUTO_CREATE);
	}
	
	public void unbind(View view)
	{
		unbindService(myConn);
	}
	
	private class MyConn implements ServiceConnection{

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			System.out.println("�õ�����Ĵ�����IBinder");
			myBinder =  (IService) service;
		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			
		}
		
	}

	
}
