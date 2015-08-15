package com.meiyun.commons.util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

/**
 * @描述：基于HtmlUnit和JSoup实现的自动抓取网页元数据的控制器
 * @author Administrator
 * @date 2015-04-08
 */
public class FetchUtil {
	
	private final static String USER_AGENT = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36";
	private final static int TIMEOUT = 5000;
	
	/**
	 * @描述 抓取网页的接口：提供两种方式抓取，提高抓取成功率
	 * @param url 网站链接
	 * @return
	 * @throws Exception
	 */
	public static FetchUrl get(String url) throws Exception {
		FetchUrl fr = fetch(buildJsoup(url));
		
		if (!fr.isSuccess()) { //抓取失败
			fr = fetch(buildHtmlUnit(url));
		}
		
		return fr;
	}
	
	/**
	 * @描述 根据MAP解析网页数据
	 * @param map 存储固定的三个对象：MAP_DOCUMENT, MAP_URL, MAP_SUCCESS
	 * @return
	 * @throws Exception
	 */
	private static FetchUrl fetch(FetchUrl fetchUrl) throws Exception {
		if (null == fetchUrl) {
			throw new Exception("对象不能为空");
		}
		
		if (fetchUrl.isSuccess()) {
			Document document = fetchUrl.getDocument();
			fetchUrl.setHost(new URL(fetchUrl.getUrl()).getHost());
			// 设置网站标题，关键词，描述信息
			try {
				fetchUrl.setTitle(document.title());
			} catch (Exception e) {
				fetchUrl.setTitle(null);
			}
			
			try {
				fetchUrl.setLabels(document.select("meta[name=keywords]").first().attr("content"));
			} catch (Exception e) {
				fetchUrl.setLabels(null);
			}
			
			try {
				fetchUrl.setDiscription(document.select("meta[name=description]").first().attr("content"));
			} catch (Exception e) {
				fetchUrl.setDiscription(null);
			}
		}
		
		return fetchUrl;
	}
	
	/**
	 * @描述 基于HtmlUnit的方式获取网页内容
	 * @param url
	 * @return
	 */
	private static FetchUrl buildHtmlUnit(String url) {
		FetchUrl fetchUrl = new FetchUrl(url);
		WebClient web = new WebClient(BrowserVersion.CHROME);

		/*
		 * @描述：目前在爬虫框架领域，还没有发现哪个爬虫对JavaScript和CSS完美解释并执行。<br>
		 * 我们只需要获取网页元数据信息，可以对JS和CSS禁用
		 */
		web.getOptions().setJavaScriptEnabled(false);
		web.getOptions().setCssEnabled(false);
		// JS运行错误时，是否抛出异常
		web.getOptions().setThrowExceptionOnScriptError(false); 
		web.getOptions().setTimeout(TIMEOUT);
		
		try {
			HtmlPage page = web.getPage(url);
			web.closeAllWindows();
			String pageContent = page.asXml();
			Document document = Jsoup.parse(pageContent);
			fetchUrl.setDocument(document);
			fetchUrl.setSuccess(true);
		} catch (FailingHttpStatusCodeException e) {
			fetchUrl.setSuccess(false);
		} catch (MalformedURLException e) {
			fetchUrl.setSuccess(false);
		} catch (IOException e) {
			fetchUrl.setSuccess(false);
		}
		
		return fetchUrl;
	}
	
	/**
	 * @描述 基于JSOUP的方式获取网页内容
	 * @param url
	 * @return
	 */
	private static FetchUrl buildJsoup(String url) {
		FetchUrl fetchUrl = new FetchUrl(url);
		
		try {
			Document document = Jsoup.connect(url).userAgent(USER_AGENT).timeout(TIMEOUT)
					.followRedirects(true).ignoreContentType(true).get();
			fetchUrl.setDocument(document);
			fetchUrl.setSuccess(true);
		} catch (IOException e) {
			fetchUrl.setSuccess(false);
		}
		
		return fetchUrl;
	}

}
