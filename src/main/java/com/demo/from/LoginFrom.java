
package com.demo.from;

public class LoginFrom {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.user_name
	 * @mbggenerated
	 */
	private String userName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.user_id
	 * @mbggenerated
	 */
	private Integer userId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.password
	 * @mbggenerated
	 */
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}