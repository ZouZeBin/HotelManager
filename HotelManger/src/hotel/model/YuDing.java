package hotel.model;
/**
 * 预订管理表
 * @author Administrator
 *
 */
public class YuDing {
	private int id;
	private String name;//预订人姓名
	private String phone;//预订人电话
	private String checkTime;//预订入住时间
	private String creditTime;//订单创建时间
	private String state;//状态
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(String checkTime) {
		this.checkTime = checkTime;
	}
	public String getCreditTime() {
		return creditTime;
	}
	public void setCreditTime(String creditTime) {
		this.creditTime = creditTime;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
}
