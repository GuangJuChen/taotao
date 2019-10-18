package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

/**
 * @ClassName: ItemController   
 * @Description:商品controller   
 * @author: chenguangju 
 * @date: 2019年10月1日 上午11:41:25
 */
@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	/**
	 * @Title: getItemById
	 * @author: chenguangju
	 * @Description: 查询商品   
	 * @param:  itemId   
	 * @return: TbItem
	 */
	@RequestMapping(value = "/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
	
	/**
	 * @Title: getItemList
	 * @author: chenguangju
	 * @Description: 分页查询列表
	 * @param:  page
	 * @param:  rows      
	 * @return: EUDataGridResult
	 */
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows) {
		EUDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
	
	/**
	 * 
	 * @Title: saveItem
	 * @Description: 添加商品
	 * @param  item
	 * @param  desc
	 * @throws Exception
	 * @return TaotaoResult
	 */
	@RequestMapping("/item/save")
	@ResponseBody
	public TaotaoResult saveItem(TbItem item, String desc,String itemParams) throws Exception {
		//添加商品信息
		TaotaoResult result = itemService.saveItem(item, desc, itemParams);
		return result;
	}
}
