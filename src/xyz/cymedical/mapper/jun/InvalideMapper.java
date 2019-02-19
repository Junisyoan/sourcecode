package xyz.cymedical.mapper.jun;

import java.util.List;

import org.springframework.stereotype.Repository;

import xyz.cymedical.entity.jun.CompanyFile;
import xyz.cymedical.entity.jun.Invalide;

/**
*	@author Junisyoan;
*	日期：2019年2月18日
*	时间：下午4:13:21
*	类说明：
*/

@Repository
public interface InvalideMapper {
	public boolean insert(Invalide invalide);
	public boolean delete(int id);
	public List<CompanyFile> queryInvalide();
	public List<Invalide> queryInvalideByFileId(int fid);
}
