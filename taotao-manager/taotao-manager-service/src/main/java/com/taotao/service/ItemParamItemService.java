package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;

/**
 * 
 * @ClassName: ItemParamItemService
 * @Description: 商品规格参数
 * @author chenguangju
 * @date 2019年10月18日
 *
 */
public interface ItemParamItemService {
	
	/**
	 * 查询所有商品规格参数列表
	 * @param page
	 * @param rows
	 * @return EUDataGridResult
	 */
	EUDataGridResult getItemParamItemList(int page,int rows);
	
	/**
	 * 根据商品id规格参数	查询
	 * @param itemId
	 * @return
	 */
	String getItemParamByItemId(Long itemId);
}
