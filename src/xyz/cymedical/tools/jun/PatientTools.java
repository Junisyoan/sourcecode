package xyz.cymedical.tools.jun;

import java.util.List;

import xyz.cymedical.entity.jun.Patient;
import xyz.cymedical.entity.xin.Combo;

/**
*	@author Junisyoan;
*	日期：2019年2月21日
*	时间：下午3:39:06
*	类说明：
*/
public class PatientTools {

	/**
	 * 填充套餐id
	 * @param patients
	 * @param combos
	 * @return
	 */
	public static List<Patient> fillInfo(List<Patient> patients,List<Combo>combos) {
		//查询套餐id
		for(int j=0;j<combos.size();j++) {
			for(int i =0;i<patients.size();i++) {
				if (combos.get(j).getName().equals(patients.get(i).getComboName())) {
					patients.get(i).setCombo_id(combos.get(j).getCombo_id());
					break;
				}
			}
		}
		
		for(Patient p:patients) {
			p.setCode(BarCodeTools.randomNumStr(13));
		}
		System.out.println(patients);
		return patients;
	}
}
