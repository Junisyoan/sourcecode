package xyz.cymedical.biz.jiang;

import java.util.List;
import java.util.Map;

import xyz.cymedical.entity.jiang.Tb_user;
import xyz.cymedical.entity.jun.Company;

public interface TbUserBiz {
	public Tb_user queryUser(String id, String pwd);

	public List<Tb_user> findUser(Tb_user user);

	public List<Tb_user> findUserRole(Tb_user user);

	public List<Tb_user> findAll();

	public List<Map<String, Object>> findAll2();

	public int addUser(Tb_user user);

	public int deleteUser(int user_id);

	public int upState(int user_id, String state);

	public int upUser(Tb_user user);// 修改人員信息

	public List<Map<String, Object>> selUser(String depts, String users, String phones);

	public List<Map<String, Object>> selectCompany(Map<String, Object> map);

	public String checkPwd(Map<String, Object> map);

	public String changePwd(Map<String, Object> map);

	public Tb_user findthree(Tb_user user);/* 查链表id */

	public String findMail(String mail);

	public String changePwdBymail(Map<String, Object> map);
}
