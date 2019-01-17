package xyz.cymedical.bean.jiang;


//菜单表
public class Tb_menu {

	private int menu_id;//菜单表id
	private String name;//菜单名字
	private String link;//路径
	
	public Tb_menu() {
		super();
	}

	public Tb_menu(int menu_id, String name, String link) {
		super();
		this.menu_id = menu_id;
		this.name = name;
		this.link = link;
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	  
	
}
