package com.song.demo.taobao;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.Item;
import com.taobao.api.request.ItemGetRequest;
import com.taobao.api.response.ItemGetResponse;

public class Test {
	public static void main(String[] args) {
		/*String url = "http://gw.api.taobao.com/router/rest";
		String appkey = "21736244";
		String secret = "fcdd44da18ecd4a4acba4b2ab97b8593";
		
		TaobaoClient client=new DefaultTaobaoClient(url, appkey, secret);
		ItemGetRequest req=new ItemGetRequest();
		req.setFields("detail_url,num_iid,title,nick,type,cid,seller_cids,props,input_pids,input_str,desc,pic_url,num,valid_thru,list_time,delist_time,stuff_status,location,price,post_fee,express_fee,ems_fee,has_discount,freight_payer,has_invoice,has_warranty,has_showcase,modified,increment,approve_status,postage_id,product_id,auction_point,property_alias,item_img,prop_img,sku,video,outer_id,is_virtual");
		req.setNumIid(18175562378L);*/
		
		/*try {
			ItemGetResponse response = client.execute(req);
			System.out.println(response.getErrorCode());
			System.out.println(response.getMsg());
			System.out.println(response.getSubCode());
			System.out.println(response.getSubMsg());
			Item item = response.getItem();
			System.out.println(item.getPicUrl());
			System.out.println(item.getDetailUrl());
		} catch (ApiException e) {
			e.printStackTrace();
		}*/
		
		long start = System.currentTimeMillis();
		String a = null;
		while (a == null) {
			a = "";
			long end = System.currentTimeMillis();
			System.out.println(end - start);
			if ((end - start)>1000) {
				System.out.println("挑出");
				break;
			}
		}
	}
}
