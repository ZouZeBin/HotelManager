/*
 * editData.java
 *
 * Created on __DATE__, __TIME__
 */

package hotel.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.jdesktop.layout.GroupLayout;
import org.jdesktop.layout.LayoutStyle;

import hotel.dao.BianJiDao;
import hotel.util.DbUtil;

/**
 * 修改管理员资料
 * @author Administrator
 *
 */
public class editData extends javax.swing.JInternalFrame {

	DbUtil dbUtil = new DbUtil();
	BianJiDao editModulDao = new BianJiDao();

	/** Creates new form editData */
	public editData() {
		initComponents();
		this.setLocation(300, 100);//设置窗口位置
	}
	/** 控件 */
	private void initComponents() {

		jLabel1 = new JLabel();
		jTextField1 = new JTextField();
		jLabel2 = new JLabel();
		password = new JPasswordField();
		password2 = new JPasswordField();
		jButton1 = new JButton();
		reset = new JButton();

		setClosable(true);
		setTitle("修改资料");

		jLabel1.setText("账号");

		jTextField1.setEditable(false);
		jTextField1.setText("admin");

		jLabel2.setText("密码");

		jButton1.setText("修改");
		jButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		reset.setText("重置");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				resetActionPerformed(evt);
			}
		});
		/**
		 * layout布局
		 */
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.LEADING)
		.add(layout.createSequentialGroup()
		.add(29, 29, 29)
		.add(layout.createParallelGroup(GroupLayout.LEADING,false)
		.add(layout.createSequentialGroup()
		.add(jLabel1)
		.add(18,18,18)
		.add(jTextField1,GroupLayout.PREFERRED_SIZE,172,GroupLayout.PREFERRED_SIZE))
		.add(layout.createSequentialGroup()
		.add(jLabel2)
		.add(18,18,18)
		.add(layout.createParallelGroup(GroupLayout.LEADING)
		.add(password,0,0,Short.MAX_VALUE)
		.add(layout.createSequentialGroup()
		.add(jButton1).addPreferredGap(LayoutStyle.RELATED,35,Short.MAX_VALUE)
		.add(reset)
		.add(23,23,23)))))
		.addContainerGap(52, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(GroupLayout.LEADING)
		.add(layout.createSequentialGroup()
		.add(31, 31, 31)
		.add(layout.createParallelGroup(GroupLayout.BASELINE)
		.add(jLabel1)
		.add(jTextField1,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
		.add(18, 18, 18)
		.add(layout.createParallelGroup(GroupLayout.BASELINE)
		.add(jLabel2)
		.add(password,GroupLayout.PREFERRED_SIZE,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE))
		.add(18, 18, 18)
		.add(layout.createParallelGroup(GroupLayout.BASELINE)
		.add(jButton1).add(reset))
		.addContainerGap(35, Short.MAX_VALUE)));

		pack();
	}

	/**
	 * 修改管理员资料
	 */
	//修改按钮事件
	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		String password = new String(this.password.getPassword());
		String repassword = new String(this.password2.getPassword());
		if (password == null || "".equals(password)) {
			JOptionPane.showMessageDialog(null, "请输入密码");
			return;
		}
		if(!password.equals(repassword)){
			JOptionPane.showMessageDialog(null, "两次输入密码不一致");
			return;
		}
		Connection con = null;
		//修改数据库操作
		try {
			con = dbUtil.getCon();
			int result = editModulDao.updateAdmin(con, password);
			if (result != 0) {
				JOptionPane.showMessageDialog(null, "修改成功");
				this.password.setText("");
			} else {
				JOptionPane.showMessageDialog(null, "修改失败");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);//关闭数据库连接
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	//重置输入框的值
	private void resetActionPerformed(ActionEvent evt) {
		this.password.setText("");
	}

	//页面控件
	private JButton jButton1;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JTextField jTextField1;
	private JPasswordField password;
	private JPasswordField password2;
	private JButton reset;
	

}