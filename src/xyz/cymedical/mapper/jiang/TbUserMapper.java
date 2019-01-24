package xyz.cymedical.mapper.jiang;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jiang.Tb_user;

@Repository
public interface TbUserMapper {

	public List<Tb_user>  findUser(Tb_user user);

	public List<Tb_user>  findAll();
	
	public List<Map<String,Object>> findAll2() ;
	
	public int  addUser(Tb_user user);
	
	public  int deleteUser(int user_id);
	
//	public  int upState(String state);
	
	public  int upState(int user_id,String state);
	
	public int upUser(Tb_user user);//修改人員信息
	
	public List<Map<String,Object>> selUser(String depts, String users,  String phones ) ;
}
