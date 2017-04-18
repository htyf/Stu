package com.oaec.service;

import java.util.List;

import com.oaec.dao.StudentDao;
import com.oaec.model.Student;

public class StudentService {
	public List getStudentList(int page,int row){
		// page*row   row
		StudentDao sd = new StudentDao();
		String sql = "select * from student order by sname limit "+(page*row)+","+row;
		return sd.getStudentList(sql);
	}

	public int add(Student stu) {
		StudentDao sd = new StudentDao();
		//String sql = 
				//"insert into student(sid,sname,sage,ssex,sphone) values('"+stu.getSid()+"','"+stu.getSname()+"','"+stu.getSage()+"','"+stu.getSsex()+"','"+stu.getSphone()+"')";
		String sql = "insert into student(sid,sname,sage,ssex,sphone) values(?,?,?,?,?)";
		return sd.add(sql,stu);
	}

	public int del(String[] ids) {
		StudentDao sd = new StudentDao();
		int num = 0;
		for(int i = 0;i<ids.length;i++){
			String sql = "delete from student where sid='"+ids[i]+"'";
			num +=  sd.del(sql);
		}
		return num;
	}
	
	public Student findOneStuForId(String id) {
		StudentDao studao = new StudentDao();
		String sql = "select * from student where sid = '"+id+"'";
		return studao.findOneStuForId(sql);
	}

	public int update(Student stu) {
		StudentDao studao = new StudentDao();
		String sql = "UPDATE student SET sname='"+stu.getSname()+"',sage="+stu.getSage()+",ssex='"+stu.getSsex()+"',sphone='"+stu.getSphone()+"' where sid='"+stu.getSid()+"'";
		return studao.update(sql);
	}
}
