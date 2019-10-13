package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EUTreeNode;

/**   
 * @ClassName: ItemCatService   
 * @Description: 节点  
 * @author: chenguangju 
 * @date: 2019年10月1日 下午8:05:16       
 */
public interface ItemCatService {
	
	List<EUTreeNode> getItemCatList(long parentId);

}
