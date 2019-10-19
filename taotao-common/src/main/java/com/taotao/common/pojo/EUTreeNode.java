package com.taotao.common.pojo;

/**   
 * @ClassName: TreeNode   
 * @Description:easyUI树形控件 列表
 * @author: chenguangju 
 * @date: 2019年10月1日 下午7:58:43       
 */
public class EUTreeNode {
	
	private long id;
	private String text;
	private String state;
	
	
	public EUTreeNode() {
		super();
	}

	public EUTreeNode(long id, String text, String state) {
		this.id = id;
		this.text = text;
		this.state = state;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
