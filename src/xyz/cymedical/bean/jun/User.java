package xyz.cymedical.bean.jun;

import org.springframework.stereotype.Component;

@Component
public class User
{
	private int userid;
	private String name;
	private String pwd;
	private String sex;
	private String education;
	private String job;
	private String tel;
	private String email;
	private int roleid;
	private String state;
	

	public User()
	{
		super();
	}

	
	public User(String name, String pwd)
	{
		super();
		this.name = name;
		this.pwd = pwd;
	}

	public User(String name, String pwd, String sex, String education, String job, String tel, String email, int roleid,
			String state)
	{
		super();
		this.name = name;
		this.pwd = pwd;
		this.sex = sex;
		this.education = education;
		this.job = job;
		this.tel = tel;
		this.email = email;
		this.roleid = roleid;
		this.state = state;
	}

	
	
	public User(String name, String pwd, String sex, String education, String job, String tel, String email)
	{
		super();
		this.name = name;
		this.pwd = pwd;
		this.sex = sex;
		this.education = education;
		this.job = job;
		this.tel = tel;
		this.email = email;
	}

	public User(int userid, String name, String pwd, String sex, String education, String job, String tel, String email,
			int roleid, String state)
	{
		super();
		this.userid = userid;
		this.name = name;
		this.pwd = pwd;
		this.sex = sex;
		this.education = education;
		this.job = job;
		this.tel = tel;
		this.email = email;
		this.roleid = roleid;
		this.state = state;
	}

	public int getUserid()
	{
		return userid;
	}

	public void setUserid(int userid)
	{
		this.userid = userid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPwd()
	{
		return pwd;
	}

	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public String getEducation()
	{
		return education;
	}

	public void setEducation(String education)
	{
		this.education = education;
	}

	public String getJob()
	{
		return job;
	}

	public void setJob(String job)
	{
		this.job = job;
	}

	public String getTel()
	{
		return tel;
	}

	public void setTel(String tel)
	{
		this.tel = tel;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public int getRoleid()
	{
		return roleid;
	}

	public void setRoleid(int roleid)
	{
		this.roleid = roleid;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}



	@Override
	public String toString()
	{
		return "User [userid=" + userid + ", name=" + name + ", pwd=" + pwd + ", sex=" + sex + ", education="
				+ education + ", job=" + job + ", tel=" + tel + ", email=" + email + ", roleid=" + roleid + ", state="
				+ state + "]";
	}
	

}
