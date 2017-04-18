package com.oaec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oaec.model.Student;
import com.oaec.utils.JdbcUtils;


/**
 * 
 * 
 * @author jiwei
 *
 *
 *
 *
 */
public class StudentDao {
	public List getStudentList(String sql) {
		Connection conn = JdbcUtils.getConn();
		ResultSet rs = null;
		Statement stmt = null;
		List list = new ArrayList();
		List<Student> list_stu = new ArrayList<Student>();
		String sqlCount = "select count(1) as total from student";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Student stu = new Student();
				stu.setSid(rs.getString("sid"));
				stu.setSname(rs.getString("sname"));
				stu.setSage(rs.getInt("sage"));
				stu.setSsex(rs.getString("ssex").charAt(0));
				stu.setSphone(rs.getString("sphone"));
				list_stu.add(stu);
			}
			ResultSet rs2 = stmt.executeQuery(sqlCount);
			rs2.next();
			int total = Integer.parseInt(rs2.getString(1));
			list.add(list_stu);
			list.add(total);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, stmt, rs);
		}
		return list;
	}

	public int add(String sql,Student stu) {
		//  PreparedStatement和Statement的区别
		// 1: PreparedStatement是预编译的，性能要比Statement高
		// 2: Statement有bug ， SQL注入bug
		// 3: 写法上，PreparedStatement写法更容易 
		//          Statement的sql语句要自己拼接，容易出错
		// 4 : 语法上，PreparedStatement的sql语句参数可以用？来填充
		      
		Connection conn = JdbcUtils.getConn();
		Statement stmt = null;
		PreparedStatement pstmt = null;
		int num = 0;
		try {
			//stmt = conn.createStatement();
			pstmt = conn.prepareStatement(sql);//预编译
			pstmt.setString(1, stu.getSid());
			pstmt.setString(2, stu.getSname());
			pstmt.setInt(3, stu.getSage());
			pstmt.setString(4, stu.getSsex()+"");
			pstmt.setString(5, stu.getSphone());
			num = pstmt.executeUpdate();
			//num = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, stmt);
		}
		return num;

	}

	

	public Student findOneStuForId(String sql) {
		Connection conn = JdbcUtils.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			rs.next();
			Student stu = new Student();
			String sid = rs.getString("sid");
			String sname = rs.getString("sname");
			int sage = rs.getInt("sage");
			char ssex = rs.getString("ssex").charAt(0);
			String sphone = rs.getString("sphone");
			stu.setSid(sid);
			stu.setSname(sname);
			stu.setSage(sage);
			stu.setSsex(ssex);
			stu.setSphone(sphone);
			return stu;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn,stmt,rs);
		}
		return null;
	}

	public int update(String sql) {
		Connection conn = JdbcUtils.getConn();
		Statement stmt = null;
		int num = 0;
		try {
			stmt = conn.createStatement();
			num = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, stmt);
		}
		return num;
	}
	
	public int del(String sql) {
		Connection conn = JdbcUtils.getConn();
		Statement stmt = null;
		int num = 0;
		try {
			stmt = conn.createStatement();
			num = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.close(conn, stmt);
		}
		return num;
	}
}
