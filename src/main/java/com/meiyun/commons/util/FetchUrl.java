package com.meiyun.commons.util;

import java.io.Serializable;

import org.jsoup.nodes.Document;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 抓取URL数据
 * 
 * @author Administrator
 *
 */
public class FetchUrl implements Serializable {

	private static final long serialVersionUID = 1L;

	private String url;

	private String host;

	private String title;

	private String labels;

	private String discription;

	private boolean success;

	@JSONField(serialize = false)
	private Document document;

	public FetchUrl() {
		super();
	}

	public FetchUrl(String url) {
		super();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

}
