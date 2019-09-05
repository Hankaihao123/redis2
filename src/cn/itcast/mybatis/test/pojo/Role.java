package cn.itcast.mybatis.test.pojo;

import java.util.Date;
import java.util.List;

public class Role {
	private Integer roleId;

	private String roleName;

	private String remark;

	private Date createTime;

	private List<Resource> resourcelist;

	public List<Resource> getResourcelist() {
		return resourcelist;
	}

	public void setResourcelist(List<Resource> resourcelist) {
		this.resourcelist = resourcelist;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName == null ? null : roleName.trim();
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}