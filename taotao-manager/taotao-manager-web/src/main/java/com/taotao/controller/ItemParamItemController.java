package com.taotao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParamItemService;

/**
 * 
 * @ClassName: ItemParamItemController
 * @Description: 商品规格参数
 * @author chenguangju
 * @date 2019年10月18日
 *
 */
@Controller
public class ItemParamItemController {

	@Autowired
	private ItemParamItemService itemParamItemService;
	
	/**
	 * 商品规格参数列表查询
	 * @param itemId
	 * @param model
	 * @return EUDataGridResult
	 */
	@RequestMapping("/item/param/list")
	@ResponseBody
	public EUDataGridResult getItemParamItemList(Integer page, Integer rows) {
		EUDataGridResult result = itemParamItemService.getItemParamItemList(page, rows);	
		List<TbItemParam> list = (List<TbItemParam>) result.getRows();
		System.out.println(list.get(0).getItemCatName());
		return result;
	}
	
	/**
	 * 根据商品id查询规格参数
	 * @param itemId
	 * @param model
	 * @return String
	 */
	@RequestMapping("/showitem/{itemId}")
	public String showItemParam(@PathVariable Long itemId, Model model) {
		String string = itemParamItemService.getItemParamByItemId(itemId);
		model.addAttribute("itemParam", string);
		return "item";
	}
}
