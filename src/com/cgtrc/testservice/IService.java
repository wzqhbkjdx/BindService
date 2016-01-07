package com.cgtrc.testservice;

public interface IService {
	//通过接口的方式暴露service中拿不到的IBender对象的方法
	public void callChangeSong(String name);
}
