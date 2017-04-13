/*
 * addHousehold.java
 *
 * Created on __DATE__, __TIME__
 */

package hotel.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import hotel.dao.ShouYinDao;
import hotel.dao.KeFangDao;
import hotel.dao.RuZhuDao;
import hotel.model.ShouYin;
import hotel.model.KeFang;
import hotel.model.ZhuHu;
import hotel.util.DbUtil;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;


/**
 *
 * 添加住户窗口
 */
public class addHousehold extends JInternalFrame {
	
	//实例化对象
	DbUtil dbUtil = new DbUtil();
	RuZhuDao householdDao = new RuZhuDao();
	KeFangDao guestRoomDao = new KeFangDao();
	ShouYinDao cashierDao = new ShouYinDao();

	//创建窗口
	public addHousehold() {
		initComponents();
		this.setLocation(200, 50);
	}

	//控件
	private void initComponents() {

		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		name = new JTextField();
		idNum = new JTextField();
		money = new JTextField();
		roomNum = new JTextField();
		jButton1 = new JButton();
		jButton2 = new JButton();

		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("添加住户");

		jLabel1.setText("姓名");

		jLabel2.setText("身份证");

		jLabel3.setText("房间号");

		jLabel4.setText("收费");

		jButton1.setText("添加");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jButton2.setText("重置");
		/**
		 * layout布局
		 */
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.LEADING)
						.add(layout.createSequentialGroup()
						.addContainerGap(56, Short.MAX_VALUE)
						.add(layout.createParallelGroup(GroupLayout.LEADING)
						.add(GroupLayout.TRAILING,layout.createSequentialGroup()
						.add(jButton1)
						.add(51,51,51)
						.add(jButton2)
						.add(119,119,119))
						.add(GroupLayout.TRAILING,layout.createSequentialGroup()
						.add(layout.createParallelGroup(GroupLayout.TRAILING)
						.add(jLabel3)
						.add(jLabel4)
						.add(jLabel2)
						.add(jLabel1))
						.add(50,50,50)
						.add(layout.createParallelGroup(GroupLayout.LEADING)
						.add(layout.createParallelGroup(GroupLayout.TRAILING,false)
						.add(GroupLayout.LEADING,idNum)
						.add(GroupLayout.LEADING,name,GroupLayout.DEFAULT_SIZE,195,Short.MAX_VALUE))
						.add(layout.createParallelGroup(GroupLayout.TRAILING,false)
						.add(GroupLayout.LEADING,money)
						.add(GroupLayout.LEADING,roomNum,GroupLayout.DEFAULT_SIZE,193,Short.MAX_VALUE)))
						.add(89,89,89)))));
						layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.LEADING)
						.add(layout.createSequentialGroup()
						.add(39, 39, 39)
						.add(layout.createParallelGroup(GroupLayout.BASELINE)
						.add(jLabel1)
						.add(name,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.RELATED)
						.add(layout.createParallelGroup(GroupLayout.BASELINE)
						.add(jLabel2)
						.add(idNum,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(LayoutStyle.RELATED)
						.add(layout.createParallelGroup(GroupLayout.BASELINE)
						.add(jLabel3)
						.add(roomNum,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
						.add(4, 4, 4)
						.add(layout.createParallelGroup(GroupLayout.BASELINE)
						.add(jLabel4)
						.add(money,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
						.add(18, 18, 18)
						.add(layout.createParallelGroup(GroupLayout.BASELINE)
						.add(jButton1)
						.add(jButton2))
						.addContainerGap()));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton1ActionPerformed(ActionEvent evt) {
		//获取输入框的值
		String name = this.name.getText();//姓名
		String idNum = this.idNum.getText();//身份证号
		
		String roomNum = this.roomNum.getText();//房间号
		String money = this.money.getText();//费用
		
		//验证值是否为空
		if("".equals(name) || name == null){
			JOptionPane.showMessageDialog(null, "请输入姓名");
			return;
		}
		if("".equals(idNum) || idNum == null){
			JOptionPane.showMessageDialog(null, "请输入身份证号码");
			return;
		}
		if("".equals(roomNum) || roomNum == null){
			JOptionPane.showMessageDialog(null, "请输入房间号");
			return;
		}
		if("".equals(money) || money == null){
			JOptionPane.showMessageDialog(null, "请输入入住费用");
		}
		//封装对象
		ZhuHu household = new ZhuHu();
		household.setName(name);
		household.setIdNum(idNum);
		household.setRoomNum(Integer.parseInt(roomNum));
		household.setMoney(Integer.parseInt(money));
		household.setState("入住中");
		Connection con = null;
		try {
			con = dbUtil.getCon();
			KeFang gr = new KeFang();
			
			//判断房间是否存在或者是否已有人入住
			gr = guestRoomDao.findByRoomNum(con, Integer.parseInt(roomNum));
			if(gr == null){
				JOptionPane.showMessageDialog(null, "未查询到客房信息");
				return;
			}
			if(gr.getState() == 1){
				JOptionPane.showMessageDialog(null, "房间占用，请重新选择房间");
				return;
			}
			int result = householdDao.addHousehold(con, household);
			if(result != 0){
				JOptionPane.showMessageDialog(null, "添加成功");
				reset();
				//更新房间状态未已入住
				KeFang guestRoom = new KeFang();
				guestRoom.setNum(Integer.parseInt(roomNum));
				guestRoom.setState(1);
				guestRoomDao.updateState(con, guestRoom);
				//添加收银信息
				ShouYin cashier = new ShouYin();
				cashier.setType("收入");
				cashier.setMoney(money);
				cashier.setRemarks("用户"+name+"入住收入金额"+money);
				cashierDao.addCashier(con, cashier);
				
			}else{
				JOptionPane.showMessageDialog(null, "添加失败");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "添加失败");
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);//关闭数据库连接
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	//清空输入框的值
	public void reset(){
		this.name.setText("");
		this.idNum.setText("");
		this.roomNum.setText("");
		this.money.setText("");
	}

	//窗口控件
	private JTextField idNum;
	private	JButton jButton1;
	private JButton jButton2;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JTextField money;
	private JTextField name;
	private JTextField roomNum;
	

}