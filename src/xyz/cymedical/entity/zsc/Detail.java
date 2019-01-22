package xyz.cymedical.entity.zsc;

import xyz.cymedical.entity.jiang.Tb_dept;

public class Detail {

	private int detail_id;
	private String name;
	private String unit;
	private String max;
	private String min;
	private String type;
	private Tb_dept tb_dept;

	public Detail() {
		super();
	}

	public Detail(int detail_id, String name, String unit, String max, String min, String type, Tb_dept tb_dept) {
		super();
		this.detail_id = detail_id;
		this.name = name;
		this.unit = unit;
		this.max = max;
		this.min = min;
		this.type = type;
		this.tb_dept = tb_dept;
	}

	@Override
	public String toString() {
		return "Detail [detail_id=" + detail_id + ", name=" + name + ", unit=" + unit + ", max=" + max + ", min=" + min
				+ ", type=" + type + ", tb_dept=" + tb_dept + "]";
	}

	public Tb_dept getTb_dept() {
		return tb_dept;
	}

	public void setTb_dept(Tb_dept tb_dept) {
		this.tb_dept = tb_dept;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

}
