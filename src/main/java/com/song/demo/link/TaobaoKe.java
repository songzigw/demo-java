package com.song.demo.link;

/*import java.util.List;*/

/*import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.TaobaokeItemDetail;
import com.taobao.api.request.TaobaokeItemsDetailGetRequest;
import com.taobao.api.response.TaobaokeItemsDetailGetResponse;*/

public class TaobaoKe {
	
	/*private String url = "http://gw.api.taobao.com/router/rest";
	
	private String appKey = "21506169";
	
	private String appSecret = "251556ca53a0442c99df7855e9921159";
	
	private Long pid = 41392176L;
	
	public TaobaokeItemDetail getTaobaoItemDetail(String numIid,
			String outerCode, Boolean isMobile) throws ApiException {
		TaobaoClient client = new DefaultTaobaoClient(url, appKey, appSecret);
		TaobaokeItemsDetailGetRequest req = new TaobaokeItemsDetailGetRequest();
		req.setFields("click_url,shop_click_url,seller_credit_score,num_iid,title,nick");
		req.setPid(pid);
		req.setNumIids(numIid);
		req.setIsMobile(isMobile);
		req.setOuterCode(outerCode);
		
		TaobaokeItemsDetailGetResponse response = client.execute(req);
		TaobaokeItemDetail tbid = null;
		if (response != null) {
			Long num = response.getTotalResults();
			if (num != null && num != 0) {
				int i = 0;
				List<TaobaokeItemDetail> tidList = response
						.getTaobaokeItemDetails();
				for (TaobaokeItemDetail tid : tidList) {
					if (i == 0) {
						tbid = tid;
						break;
					}
				}
			}
		}
		return tbid;
	}
	
	public static void main(String[] args) {
		TaobaoKe tk = new TaobaoKe();
		//while (true) {
			try {
				TaobaokeItemDetail tbid = tk.getTaobaoItemDetail("16944388280", "vlook", false);
				if (tbid != null) {
					System.out.println(tbid.getClickUrl());
				}
				Thread.sleep(1000 * 60);
			} catch (Exception e) {
				e.printStackTrace();
			}
		//}
	}*/
}
