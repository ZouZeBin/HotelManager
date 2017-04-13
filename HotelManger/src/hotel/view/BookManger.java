/*
 * BookManger.java
 *
 * Created on __DATE__, __TIME__
 */

package hotel.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import hotel.dao.YuDingDao;
import hotel.model.YuDing;
import hotel.util.DbUtil;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;
/**
 *添加预订信息
 * @author Administrator
 *
 */
public class BookManger extends javax.swing.JInternalFrame {
	//实例化对象
	DbUtil dbUtil = new DbUtil();
	YuDingDao bookDao = new YuDingDao();

	/** 创建窗口 */
	public BookManger() {
		initComponents();
		this.setLocation(200, 50);//设置窗口位置
	}

	//初始化控件
	private void initComponents() {

		jLabel1 = new JLabel();
		name = new JTextField();
		jLabel2 = new JLabel();
		phone = new JTextField();
		jLabel3 = new JLabel();
		checkTime = new JTextField();
		save = new JButton();
		jButton2 = new JButton();

		setClosable(true);
		setIconifiable(true);
		setTitle("预订管理");

		jLabel1.setText("姓名");

		jLabel2.setText("联系电话");

		jLabel3.setText("入住时间");

		save.setText("保存");
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				saveActionPerformed(evt);
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
		.add(layout.createParallelGroup(GroupLayout.LEADING)
		.add(layout.createSequentialGroup()
		.add(32,32,32)
		.add(layout.createParallelGroup(GroupLayout.LEADING)
		.add(jLabel3)
		.add(jLabel2)
		.add(jLabel1))
		.addPreferredGap(LayoutStyle.RELATED)
		.add(layout.createParallelGroup(GroupLayout.LEADING,false)
		.add(GroupLayout.TRAILING,phone,GroupLayout.DEFAULT_SIZE,153,Short.MAX_VALUE)
		.add(save)
		.add(checkTime)
		.add(GroupLayout.TRAILING,name)))
		.add(layout.createSequentialGroup()
		.add(186,186,186)
		.add(jButton2))).addContainerGap(89, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.LEADING)
		.add(layout.createSequentialGroup()
		.add(30, 30, 30)
		.add(layout.createParallelGroup(GroupLayout.BASELINE)
		.add(jLabel1)
		.add(name,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
		.addPreferredGap(LayoutStyle.RELATED)
		.add(layout.createParallelGroup(GroupLayout.BASELINE)
		.add(jLabel2)
		.add(phone,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
		.addPreferredGap(LayoutStyle.RELATED)
		.add(layout.createParallelGroup(GroupLayout.BASELINE)
		.add(jLabel3)
		.add(checkTime,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
		.addPreferredGap(LayoutStyle.RELATED,28, Short.MAX_VALUE)
		.add(layout.createParallelGroup(GroupLayout.BASELINE)
		.add(jButton2)
		.add(save))
		.addContainerGap()));

		pack();
	}
	/**
	 * 保存按钮事件
	 * @param evt
	 */
	private void saveActionPerformed(java.awt.event.ActionEvent evt) {
		String name = this.name.getText();//姓名
		String phone = this.phone.getText();//联系电话
		String checkTime = this.checkTime.getText();//预订入住时间
		
		//验证数据是否为空
		if (name == null || "".equals(name)) {
			JOptionPane.showMessageDialog(null, "请输入入住人姓名");
		}
		if (phone == null || "".equals(phone)) {
			JOptionPane.showMessageDialog(null, "请输入联系电话");
		}
		if (checkTime == null || "".equals(checkTime)) {
			JOptionPane.showMessageDialog(null, "请输入入住时间");
		}
		//封装数据对象
		YuDing book = new YuDing();
		book.setName(name);
		book.setPhone(phone);
		book.setCheckTime(checkTime);
		book.setState("已预订");
		Connection con = null;
		//保存数据
		try {
			con = dbUtil.getCon();
			int result = bookDao.addBook(con, book);
			if (result != 0) {
				JOptionPane.showMessageDialog(null, "保存成功");
				reset();
			} else {
				JOptionPane.showMessageDialog(null, "保存失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "保存失败");
		}finally{
			try {
				dbUtil.closeCon(con);//关闭数据库连接
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//清空输入框的值
	private void reset() {
		this.name.setText("");
		this.phone.setText("");
		this.checkTime.setText("");
	}

	/** 控件 */
	private JTextField checkTime;
	private JButton jButton2;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JTextField name;
	private JTextField phone;
	private JButton save;
	

}