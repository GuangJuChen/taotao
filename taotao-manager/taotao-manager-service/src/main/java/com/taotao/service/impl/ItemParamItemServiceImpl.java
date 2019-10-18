package com.taotao.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.pojo.TbItemParamItemExample.Criteria;
import com.taotao.service.ItemParamItemService;

/**
 * 
 * @ClassName: ItemParamItemServiceImpl
 * @Description: 商品规格参数
 * @author chenguangju
 * @date 2019年10月18日
 *
 */
@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {

	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;
	@Autowired
	private TbItemParamMapper itemParamMapper;
	
	/**
	 * (非 Javadoc)
	 * <p>Title: getItemParamItemList</p>
	 * <p>Description:查询所有的商品规格参数列表 </p>
	 * @param page
	 * @param rows
	 * @return EUDataGridResult
	 * @see com.taotao.service.ItemParamItemService#getItemParamItemList(int, int)
	 */
	@Override
	public EUDataGridResult getItemParamItemList(int page, int rows) {
		
		//查询商品列表
		TbItemParamExample example = new TbItemParamExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<TbItemParam> list = itemParamMapper.selectByExampleWithBLOBs(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<TbItemParam> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}
	
	/**
	 * (非 Javadoc)
	 * <p>Title: getItemParamByItemId</p>
	 * <p>Description:根据商品id查询规格参数 </p>
	 * @param itemId
	 * @return String
	 * @see com.taotao.service.ItemParamItemService#getItemParamByItemId(java.lang.Long)
	 */
	@Override
	public String getItemParamByItemId(Long itemId) {
		//根据商品id查询规格参数
		TbItemParamItemExample example = new TbItemParamItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemIdEqualTo(itemId);
		//执行查询
		List<TbItemParamItem> list = itemParamItemMapper.selectByExampleWithBLOBs(example);
		if (list == null || list.size() == 0) {
			return "";
		}
		//取规格参数信息
		TbItemParamItem itemParamItem = list.get(0);
		String paramData = itemParamItem.getParamData();
		//生成html
		// 把规格参数json数据转换成java对象
		List<Map> jsonList = JsonUtils.jsonToList(paramData, Map.class);
		StringBuffer sb = new StringBuffer();
		sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"0\" class=\"Ptable\">\n");
		sb.append("    <tbody>\n");
		for(Map m1:jsonList) {
			sb.append("        <tr>\n");
			sb.append("            <th class=\"tdTitle\" colspan=\"2\">"+m1.get("group")+"</th>\n");
			sb.append("        </tr>\n");
			List<Map> list2 = (List<Map>) m1.get("params");
			for(Map m2:list2) {
				sb.append("        <tr>\n");
				sb.append("            <td class=\"tdTitle\">"+m2.get("k")+"</td>\n");
				sb.append("            <td>"+m2.get("v")+"</td>\n");
				sb.append("        </tr>\n");
			}
		}
		sb.append("    </tbody>\n");
		sb.append("</table>");
		return sb.toString();
	}

}
