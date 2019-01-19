package xyz.cymedical.entity.jiang;

//权限表
public class Tb_power {

	private int power_id;//权限id
	private int   menu_id;//菜单表id
	private String name; //权限名字
	public Tb_power() {
		super();
	}
	public Tb_power(int power_id, int menu_id, String name) {
		super();
		this.power_id = power_id;
		this.menu_id = menu_id;
		this.name = name;
	}
	public int getPower_id() {
		return power_id;
	}
	public void setPower_id(int power_id) {
		this.power_id = power_id;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
