package cn.itcast.mybatis.po;

//原来orders的pojo无法映射用户的信息,所以创建了此扩展的类
public class OrderUserCu extends Orders {
	private String username;
	private String sex;
	private String adderss;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAdderss() {
		return adderss;
	}

	public void setAdderss(String adderss) {
		this.adderss = adderss;
	}

}
