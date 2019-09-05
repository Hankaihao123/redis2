package cn.itcast.mybatis.po;

import java.util.Date;
import java.util.List;

public class Orders {
	private Integer id;
	private Integer userId;
	private String number;
	private Date createtime;
	private String note;
	// 用户信息
	private User user;

	// 订单明细
	List<Orderdetail> orederdetaillist;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number == null ? null : number.trim();
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Orderdetail> getOrederdetaillist() {
		return orederdetaillist;
	}

	public void setOrederdetaillist(List<Orderdetail> orederdetaillist) {
		this.orederdetaillist = orederdetaillist;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", userId=" + userId + ", number=" + number + ", createtime=" + createtime
				+ ", note=" + note + ", user=" + user + ", orederdetaillist=" +orederdetaillist + "]";
	}

}