package xyz.cymedical.entity.xin;

import org.springframework.stereotype.Component;

@Component
public class Detail {
	
	int 	detail_id;   //细项表id
	String  name;		 //细项名字
	String  unit;		 //计量单位
	String  max;		 //上限值
	String  min;		 //下限值
	String  type;		 //检验类型
	int 	dept_id;	 //对应部门id
	
	public Detail() {
		super();
	}

	public Detail(int detail_id, String name, String unit, String max, String min, String type, int dept_id) {
		super();
		this.detail_id = detail_id;
		this.name = name;
		this.unit = unit;
		this.max = max;
		this.min = min;
		this.type = type;
		this.dept_id = dept_id;
	}

	public int getDetail_id() {
		return detail_id;
	}

	public void setDetail_id(int detail_id) {
		this.detail_id = detail_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getMin() {
		return min;
	}

	public void setMin(String min) {
		this.min = min;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDept_id() {
		return dept_id;
	}

	public void setDept_id(int dept_id) {
		this.dept_id = dept_id;
	}

	@Override
	public String toString() {
		return "Detail [detail_id=" + detail_id + ", name=" + name + ", unit=" + unit + ", max=" + max + ", min=" + min
				+ ", type=" + type + ", dept_id=" + dept_id + "]";
	}

	
	
}
