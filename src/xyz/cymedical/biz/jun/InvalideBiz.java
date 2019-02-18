package xyz.cymedical.biz.jun;

import java.util.List;

import xyz.cymedical.entity.jun.CompanyFile;
import xyz.cymedical.entity.jun.Invalide;

/**
*	@author Junisyoan;
*	日期：2019年2月18日
*	时间：下午4:11:13
*	类说明：
*/
public interface InvalideBiz {

	public boolean insert(Invalide invalide);
	public boolean delete(int id);
	public List<CompanyFile> queryInvalide();
	public List<Invalide> queryInvalideByFileId(int id);
}
