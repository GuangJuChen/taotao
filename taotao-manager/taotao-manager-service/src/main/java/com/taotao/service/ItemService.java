package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

/**   
 * @ClassName: ItemService   
 * @Description: 商品接口
 * @author: chenguangju 
 * @date: 2019年10月1日 上午11:42:48       
 */
public interface ItemService {
	
	TaotaoResult saveItem(TbItem item, String desc, String itemParams) throws Exception;
	TbItem getItemById(long itemId);
	EUDataGridResult getItemList(int page,int rows);
}
