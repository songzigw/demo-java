package com.song.demo.api;

import org.apache.log4j.Logger;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.Item;
import com.taobao.api.request.ItemGetRequest;
import com.taobao.api.response.ItemGetResponse;

public class TbuzApi {

	private static Logger logger = Logger.getLogger(TbuzApi.class);

	private static final String APP_KEY = "21736244";
	private static final String APP_SECRET = "fcdd44da18ecd4a4acba4b2ab97b8593";
	private static final String URL = "http://gw.api.taobao.com/router/rest";

	public static ItemBean getItem(Long numIid) {
		TaobaoClient client = new DefaultTaobaoClient(URL, APP_KEY, APP_SECRET);
		ItemGetRequest req = new ItemGetRequest();
		StringBuffer fields = new StringBuffer();
		fields.append("detail_url,num_iid,title,nick,");
		fields.append("type,cid,seller_cids,props,input_pids,");
		fields.append("input_str,desc,pic_url,num,valid_thru,");
		fields.append("list_time,delist_time,stuff_status,location,");
		fields.append("price,post_fee,express_fee,ems_fee,has_discount,");
		fields.append("freight_payer,has_invoice,has_warranty,has_showcase,");
		fields.append("modified,increment,approve_status,postage_id,");
		fields.append("product_id,auction_point,property_alias,item_img,");
		fields.append("prop_img,sku,video,outer_id,is_virtual");
		req.setFields(fields.toString());
		req.setNumIid(numIid);

		ItemBean itemBean = new ItemBean();
		ItemGetResponse response = null;
		try {
			response = client.execute(req);
		} catch (ApiException e) {
			logger.error("TbuzApi.getItem(Long numIid)", e);
			itemBean.setErrCode(Result.ErrCode.ERR_0);
			itemBean.setErrDesc("系统异常");
			return itemBean;
		}

		if (response.getErrorCode() == null) {
			Item item = response.getItem();
			itemBean.setTitle(item.getTitle());
			itemBean.setPicUrl(item.getPicUrl());
			itemBean.setPrice(item.getPrice());
			itemBean.setDetailUrl(item.getDetailUrl());
			itemBean.setNumIid(numIid.toString());
			return itemBean;
		} else {
			logger.info("错误码：" + response.getErrorCode() + ";描述："
					+ response.getMsg());
			itemBean.setErrCode(Result.ErrCode.ERR_3);
			itemBean.setErrDesc("没有改链接商品信息");
			return itemBean;
		}
	}
}
