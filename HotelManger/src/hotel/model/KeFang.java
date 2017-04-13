package hotel.model;
/**
 * 客房实体类
 * @author Administrator
 *
 */
public class KeFang {
	private int id;//主键
	private int num;//客房号
	private int state;//客房状态 0 未入住  1已入住
	private String type;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}
