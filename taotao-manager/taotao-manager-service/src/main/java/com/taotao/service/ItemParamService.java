package com.taotao.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

/**
 * 
 * @ClassName: ItemParamService
 * @Description: 商品规格
 * @author chenguangju
 * @date 2019年10月18日
 *
 */
public interface ItemParamService {
	/**
	 * 商品规格参数模板管理	查询
	 * @param cid
	 * @return
	 */
	TaotaoResult getItemParamByCid(long cid);
	
	/**
	 * 商品规格参数模板管理	保存
	 * @param itemParam
	 * @return
	 */
	TaotaoResult insertItemParam(TbItemParam itemParam);

}
