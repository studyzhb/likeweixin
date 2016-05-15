package com.zhbandroid.weixin.bean;

public class ChildBean {
	private String content;
	private String contentTag;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getContentTag() {
		return contentTag;
	}
	public void setContentTag(String contentTag) {
		this.contentTag = contentTag;
	}
	public ChildBean(String content, String contentTag) {
		this.content = content;
		this.contentTag = contentTag;
	}
	
	
}
