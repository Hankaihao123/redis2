package cn.itcast.mybatis.test.pojo;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

public class Resource {
	@JSONField(name = "id")
	private Integer menuId;

	private Integer parentId;
	@JSONField(name = "title")
	private String name;

	private String url;

	private String perms;

	private Integer type;

	private String icon;

	private String orderNum;

	//此Children不要在xml中映射关系不映射关系,但是角色中的资源链表要在xml中映射关系
	@JSONField(name = "children")
	List<Resource> Children;

	public List<Resource> getChildren() {
		return Children;
	}

	public void setChildren(List<Resource> children) {
		Children = children;
	}

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public String getPerms() {
		return perms;
	}

	public void setPerms(String perms) {
		this.perms = perms == null ? null : perms.trim();
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum == null ? null : orderNum.trim();
	}

	@Override
	public String toString() {
		return "Resource [menuId=" + menuId + ", parentId=" + parentId + ", name=" + name + ", url=" + url + ", perms="
				+ perms + ", type=" + type + ", icon=" + icon + ", orderNum=" + orderNum + ", Children=" + Children
				+ "]";
	}

}