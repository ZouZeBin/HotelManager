/*
 * outGuestManger.java
 *
 * Created on __DATE__, __TIME__
 */

package hotel.view;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import hotel.dao.KeFangDao;
import hotel.dao.RuZhuDao;
import hotel.model.KeFang;
import hotel.util.DbUtil;

/**
 *
 * @author  __USER__
 */
public class outGuestManger extends javax.swing.JInternalFrame {

	DbUtil dbUtil = new DbUtil();
	RuZhuDao householdDao = new RuZhuDao();
	KeFangDao guestRoomDao = new KeFangDao();

	/** Creates new form outGuestManger */
	public outGuestManger() {
		String name = null;
		initComponents();
		this.setLocation(200, 50);//设置窗口位置
		this.fillTable(name);//初始化调用填充表格数据方法
	}

	/**
	 * 填充表格数据
	 * @param name
	 */
	public void fillTable(String name) {
		DefaultTableModel dtm = (DefaultTableModel) houseHoleTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = dbUtil.getCon();
			ResultSet re = householdDao.getGuestRoom(con, name);
			while (re.next()) {
				Vector v = new Vector();
				//添加每一行的数据
				v.add(re.getString("id"));
				v.add(re.getString("name"));
				v.add(re.getString("idNum"));
				v.add(re.getString("roomNum"));
				v.add(re.getString("money"));
				v.add(re.getString("checkTime"));
				v.add(re.getString("state"));
				dtm.addRow(v);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jLabel1 = new javax.swing.JLabel();
		name = new javax.swing.JTextField();
		serch = new javax.swing.JButton();
		jScrollPane1 = new javax.swing.JScrollPane();
		houseHoleTable = new javax.swing.JTable();
		jPanel1 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		roomNum = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jLabel3 = new javax.swing.JLabel();
		id = new javax.swing.JTextField();

		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setTitle("\u9000\u623f\u7ba1\u7406");

		jLabel1.setText("\u59d3\u540d");

		name.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				nameActionPerformed(evt);
			}
		});

		serch.setText("\u67e5\u8be2");
		serch.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				serchActionPerformed(evt);
			}
		});

		houseHoleTable.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] {

				}, new String[] { "编号", "姓名", "身份证", "房间号", "费用", "入住时间",
						"入住状态" }) {
			boolean[] canEdit = new boolean[] { false, false, false, false,
					false, false, false };

			public boolean isCellEditable(int rowIndex, int columnIndex) {
				return canEdit[columnIndex];
			}
		});
		houseHoleTable.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mousePressed(java.awt.event.MouseEvent evt) {
				houseHoleTableMousePressed(evt);
			}
		});
		jScrollPane1.setViewportView(houseHoleTable);

		jPanel1.setBorder(javax.swing.BorderFactory
				.createTitledBorder("\u7f16\u8f91"));

		jLabel2.setText("\u623f\u95f4\u53f7");

		roomNum.setEditable(false);

		jButton1.setText("\u786e\u5b9a\u9000\u623f");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt);
			}
		});

		jLabel3.setText("\u7f16\u53f7");

		id.setEditable(false);
		id.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				
			}
		});

		org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								jPanel1Layout
										.createSequentialGroup()
										.add(20, 20, 20)
										.add(
												jPanel1Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.TRAILING)
														.add(jButton1)
														.add(
																jPanel1Layout
																		.createSequentialGroup()
																		.add(
																				jLabel2)
																		.addPreferredGap(
																				org.jdesktop.layout.LayoutStyle.UNRELATED)
																		.add(
																				roomNum,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				180,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
										.add(18, 18, 18)
										.add(jLabel3)
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.UNRELATED)
										.add(
												id,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
												142,
												org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(518, Short.MAX_VALUE)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.add(
												jPanel1Layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.BASELINE)
														.add(jLabel2)
														.add(
																roomNum,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
														.add(jLabel3)
														.add(
																id,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												org.jdesktop.layout.LayoutStyle.RELATED,
												30, Short.MAX_VALUE).add(
												jButton1).addContainerGap()));

		org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout
				.setHorizontalGroup(layout
						.createParallelGroup(
								org.jdesktop.layout.GroupLayout.LEADING)
						.add(
								layout
										.createSequentialGroup()
										.add(
												layout
														.createParallelGroup(
																org.jdesktop.layout.GroupLayout.LEADING)
														.add(
																layout
																		.createSequentialGroup()
																		.add(
																				28,
																				28,
																				28)
																		.add(
																				jLabel1)
																		.add(
																				32,
																				32,
																				32)
																		.add(
																				name,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
																				146,
																				org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
																		.add(
																				26,
																				26,
																				26)
																		.add(
																				serch))
														.add(
																layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.add(
																				layout
																						.createParallelGroup(
																								org.jdesktop.layout.GroupLayout.LEADING)
																						.add(
																								org.jdesktop.layout.GroupLayout.TRAILING,
																								jPanel1,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								Short.MAX_VALUE)
																						.add(
																								jScrollPane1,
																								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
																								974,
																								Short.MAX_VALUE))))
										.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(
				org.jdesktop.layout.GroupLayout.LEADING).add(
				layout.createSequentialGroup().add(41, 41, 41).add(
						layout.createParallelGroup(
								org.jdesktop.layout.GroupLayout.BASELINE).add(
								jLabel1).add(name,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
								.add(serch)).addPreferredGap(
						org.jdesktop.layout.LayoutStyle.RELATED).add(
						jScrollPane1,
						org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 130,
						org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(
								org.jdesktop.layout.LayoutStyle.UNRELATED).add(
								jPanel1,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE,
								org.jdesktop.layout.GroupLayout.DEFAULT_SIZE,
								org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(74, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void houseHoleTableMousePressed(java.awt.event.MouseEvent evt) {
		int row = houseHoleTable.getSelectedRow();
		this.id.setText(houseHoleTable.getValueAt(row, 0).toString());
		this.roomNum.setText(houseHoleTable.getValueAt(row, 3).toString());
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		String roomNum = this.roomNum.getText();
		int id = Integer.parseInt(this.id.getText());
		if (roomNum == null || "".equals(roomNum)) {
			JOptionPane.showMessageDialog(null, "请输入房间号");
		}
		Connection con = null;
		try {
			con = dbUtil.getCon();
			int result = householdDao.updateGuestRoom(con, id);
			if (result != 0) {
				JOptionPane.showMessageDialog(null, "退房成功");
				KeFang guestRoom = new KeFang();
				guestRoom.setNum(Integer.parseInt(roomNum));
				guestRoomDao.updateState(con, guestRoom);
				guestRoom.setState(0);
				String name = null;
				this.roomNum.setText("");
				fillTable(name);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void serchActionPerformed(java.awt.event.ActionEvent evt) {
		String name = this.name.getText();
		this.fillTable(name);
	}

	private void nameActionPerformed(java.awt.event.ActionEvent evt) {

	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JTable houseHoleTable;
	private javax.swing.JTextField id;
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTextField name;
	private javax.swing.JTextField roomNum;
	private javax.swing.JButton serch;
	// End of variables declaration//GEN-END:variables

}