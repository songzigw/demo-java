package com.song.demo.api;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class ApiCenter {

	private static final String[] WEB_SITES = { "taobao.com", "tmall.com" };
	private static ApiCenter instance = new ApiCenter();

	private ApiCenter() {
	}

	public static ApiCenter getInstance() {
		return instance;
	}

	public ItemBean getItemBean(String url) {
		ItemBean itemBean = new ItemBean();
		URL urlOther = null;
		try {
			urlOther = new URL(url);
		} catch (MalformedURLException e) {
			itemBean.setErrCode(Result.ErrCode.ERR_1);
			itemBean.setErrDesc("URL格式错误");
			return itemBean;
		}
		URLInfo urlInfo = new URLInfo(urlOther);
		String hostName = urlInfo.getHostName();
		String webSiteFlag = null;
		boolean flag = false;
		for (String webSite : WEB_SITES) {
			if (hostName.endsWith(webSite)) {
				webSiteFlag = webSite;
				flag = true;
				break;
			}
		}
		if (!flag) {
			itemBean.setErrCode(Result.ErrCode.ERR_2);
			itemBean.setErrDesc("不支持的链接");
			return itemBean;
		}
		Map<String, String> map = urlInfo.getParamMap();
		if (webSiteFlag.equals("taobao.com") || webSiteFlag.equals("tmall.com")) {
			try {
				String id = map.get("id");
				if ((id == null || "".equals(id))
						&& url.startsWith("http://miao.item.taobao.com/")) {
					id = url.substring(28, url.indexOf(".htm"));
				}
				Long numIid = Long.parseLong(id);
				itemBean = TbuzApi.getItem(numIid);
			} catch (NumberFormatException e) {
				itemBean.setErrCode(Result.ErrCode.ERR_2);
				itemBean.setErrDesc("不支持的链接");
				return itemBean;
			}
		}

		return itemBean;
	}

	public static void main(String[] args) {
		ItemBean ib = ApiCenter
				.getInstance()
				.getItemBean(
						"http://miao.item.taobao.com/36829114255.htm");
		if (ib.getErrCode() == null) {
			System.out.println(ib.getTitle());
		}
	}
}
