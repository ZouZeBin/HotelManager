/*
 * addGuestRoom.java
 *
 * Created on __DATE__, __TIME__
 */

package hotel.view;

import java.awt.event.ActionEvent;
import java.sql.Connection;

import hotel.dao.KeFangDao;
import hotel.model.KeFang;
import hotel.util.DbUtil;

import javax.swing.JOptionPane;

/**
 *
 * @author  __USER__
 */
public class addGuestRoom extends javax.swing.JInternalFrame {
	
	DbUtil dbUtil = new DbUtil();
	KeFangDao guestRoomDao = new KeFangDao();

	/** Creates new form addGuestRoom */
	public addGuestRoom() {
		initComponents();
	}

//GEN-BEGIN:initComponents
// <editor-fold defaultstate="collapsed" desc="Generated Code">
private void initComponents() {

jLabel1 = new javax.swing.JLabel();
num = new javax.swing.JTextField();
jLabel2 = new javax.swing.JLabel();
type = new javax.swing.JTextField();
save = new javax.swing.JButton();
reset = new javax.swing.JButton();

setClosable(true);
setTitle("添加房间信息");

jLabel1.setText("房间号");

num.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
numActionPerformed(evt);
}
});

jLabel2.setText("类型");

save.setText("保存");
save.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
saveActionPerformed(evt);
}
});

reset.setText("重置");
reset.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
resetActionPerformed(evt);
}
});

org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
.add(layout.createSequentialGroup()
.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
.add(layout.createSequentialGroup()
.add(45, 45, 45)
.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
.add(jLabel1)
.add(jLabel2))
.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
.add(type)
.add(num, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))
.add(layout.createSequentialGroup()
.add(84, 84, 84)
.add(save)
.add(18, 18, 18)
.add(reset)))
.addContainerGap(88, Short.MAX_VALUE))
);
layout.setVerticalGroup(
layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
.add(layout.createSequentialGroup()
.add(38, 38, 38)
.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
.add(jLabel1)
.add(num, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
.add(jLabel2)
.add(type, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
.addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 17, Short.MAX_VALUE)
.add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
.add(reset)
.add(save))
.addContainerGap())
);

pack();
}	
	/**
	 * 重置按钮时间
	 * @param evt
	 */
	private void resetActionPerformed(ActionEvent evt) {
		reset();
	}


	private void saveActionPerformed(java.awt.event.ActionEvent evt) {
		String num = this.num.getText();
		String type = this.type.getText();
		if(num == null || "".equals(num)){
			JOptionPane.showMessageDialog(null, "请输入房间号");
			return;
		}
		if(type == null && "".equals(type)){
			JOptionPane.showMessageDialog(null, "请输入类型");
			return;
		}
		Connection con = null;
		try {
			con = dbUtil.getCon();
			KeFang g = guestRoomDao.findByRoomNum(con, Integer.parseInt(num));
			//判断房间号是否存在
			if(g != null){
				JOptionPane.showMessageDialog(null, "该房间已存在");
				return;
			}
			
			//封装对象
			KeFang guestRoom = new KeFang();
			guestRoom.setNum(Integer.parseInt(num));
			guestRoom.setState(0);
			guestRoom.setType(type);
			
			//保存数据
			int result = guestRoomDao.addGusteRoom(con, guestRoom);
			if(result != 0){
				JOptionPane.showMessageDialog(null, "添加成功");
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	/**
	 * 清空输入框的值
	 */
	private void reset(){
		this.num.setText("");
		this.type.setText("");
	}

	void numActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

//GEN-BEGIN:variables
// Variables declaration - do not modify
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jLabel2;
private javax.swing.JTextField num;
private javax.swing.JButton reset;
private javax.swing.JButton save;
private javax.swing.JTextField type;
// End of variables declaration//GEN-END:variables

}