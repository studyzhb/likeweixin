package com.zhbandroid.weixin.bean;

import java.util.List;

public class ParentBean {
	private String titleContent;
	private List<ChildBean> list;
	

	public String getTitleContent() {
		return titleContent;
	}

	public void setTitleContent(String titleContent) {
		this.titleContent = titleContent;
	}

	public List<ChildBean> getList() {
		return list;
	}

	public void setList(List<ChildBean> list) {
		this.list = list;
	}

	public ParentBean(String titleContent, List<ChildBean> list) {
		super();
		this.titleContent = titleContent;
		this.list = list;
	}

	
}
