package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemParamExample.Criteria;
import com.taotao.service.ItemParamService;

/**
 * 
 * @ClassName: ItemParamServiceImpl
 * @Description: 商品规格参数模板管理
 * @author chenguangju
 * @date 2019年10月18日
 *
 */
@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private TbItemParamMapper itemParamMapper;
	
	/**
	 * (非 Javadoc)
	 * <p>Title: getItemParamByCid</p>
	 * <p>Description:查询商品规格参数模板管理 </p>
	 * @param cid
	 * @return TaotaoResult
	 * @see com.taotao.service.ItemParamService#getItemParamByCid(long)
	 */
	@Override
	public TaotaoResult getItemParamByCid(long cid) {
		TbItemParamExample example = new TbItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
		//判断是否查询到结果
		if (list != null && list.size() > 0) {
			return TaotaoResult.ok(list.get(0));
		}
		
		return TaotaoResult.ok();
	}
	
	/**
	 * (非 Javadoc)
	 * <p>Title: insertItemParam</p>
	 * <p>Description:保存商品规格参数模板管理 </p>
	 * @param itemParam
	 * @return TaotaoResult
	 * @see com.taotao.service.ItemParamService#insertItemParam(com.taotao.pojo.TbItemParam)
	 */
	@Override
	public TaotaoResult insertItemParam(TbItemParam itemParam) {
		//补全pojo
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		//插入到规格参数模板表
		itemParamMapper.insert(itemParam);
		return TaotaoResult.ok();
	}

}
