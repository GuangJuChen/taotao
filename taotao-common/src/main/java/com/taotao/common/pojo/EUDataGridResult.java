package com.taotao.common.pojo;

import java.util.List;

/**   
 * @ClassName: EUDataGridResult   
 * @Description: 返回easyui-datagrid格式的json数据   
 * @author: chenguangju 
 * @date: 2019年10月1日 上午11:45:13       
 */
public class EUDataGridResult {
	
	private long total;
	private List<?> rows;
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
