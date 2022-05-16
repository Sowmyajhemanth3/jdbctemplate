package com.src.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.src.bean.Student;



public class StudentDAOClass implements StudentDAOInterface {
@Autowired
	private JdbcTemplate jdbctemplate;
	
	public JdbcTemplate getJdbctemplate() {
	return jdbctemplate;
}

public void setJdbctemplate(JdbcTemplate jdbctemplate) {
	this.jdbctemplate = jdbctemplate;
}

	public int insertStudent(Student s) {
		// TODO Auto-generated method stub
		String sqlquery="insert into student121 values('"+s.getStdid()+"','"+s.getStdpwd()+"','"+s.getStdname()+"','"+s.getStdaddress()+"',"+s.getStdage()+","+s.getStdmob()+")";
		return jdbctemplate.update(sqlquery);
		
	}

	public int deleteStudent(final Student s) {
		// TODO Auto-generated method stub
		String sqlquery="delete from student121 where stdid=?";
		return jdbctemplate.execute(sqlquery,(PreparedStatementCallback<Integer>)ps->{
			ps.setString(1,s.getStdid());
			
			return ps.executeUpdate();
			
		});
	}

	
		

	public int editStudent(final Student s) {
		String sqlquery="update student121 set stdpwd=?,stdname=?,stdaddress=?,stdage=?,stdmob=? where stdid=?";
//		return jdbctemplate.execute(sqlquery,new PreparedStatementCallback<Integer>() {
//
//			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
//				ps.setString(1,s.getStdpwd());
//				ps.setString(2, s.getStdname());
//				ps.setString(3, s.getStdaddress());
//				ps.setInt(4, s.getStdage());
//				ps.setLong(5, s.getStdmob());
//				ps.setString(6, s.getStdid());
//				return ps.executeUpdate();
//			}
//			
//			
//		});
		
		return jdbctemplate.execute(sqlquery,(PreparedStatementCallback<Integer>) ps->{
			
			ps.setString(1,s.getStdpwd());
			ps.setString(2, s.getStdname());
			ps.setString(3, s.getStdaddress());
			ps.setInt(4, s.getStdage());
			ps.setLong(5, s.getStdmob());
			ps.setString(6, s.getStdid());
			return ps.executeUpdate();
		});
	
		
		
	}

	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
	//	return jdbctemplate.query("select * from student121", new ResultSetExtractor<List<Student>>() {
//			@Override
//			public List<Student> extractData(ResultSet rs) throws SQLException, DataAccessException {
//				List<Student> students=new ArrayList<Student>();
//				while(rs.next())
//				{
//					Student s = new Student();
//					s.setStdid(rs.getString(1));
//					s.setStdpwd(rs.getString(2));
//					s.setStdname(rs.getString(3));
//					s.setStdaddress(rs.getString(4));
//					s.setStdage(rs.getInt(5));
//					s.setStdmob(rs.getLong(6));
//					
//					students.add(s);
//				}
//				return students;
//			}			
//		});
		
		return jdbctemplate.query("select * from student121", (ResultSetExtractor<List<Student>>)rs->{
			List<Student> students=new ArrayList<Student>();
			while(rs.next())
			{
				Student s = new Student();
				s.setStdid(rs.getString(1));
				s.setStdpwd(rs.getString(2));
				s.setStdname(rs.getString(3));
				s.setStdaddress(rs.getString(4));
				s.setStdage(rs.getInt(5));
				s.setStdmob(rs.getLong(6));
				
				students.add(s);
			}
			return students;					
		});
	}

	public List<Student> getStudentById(String sid) {
		// TODO Auto-generated method stub
		String sqlquery="select * from student121 where stdid="+sid;
		return jdbctemplate.query(sqlquery, new RowMapper<Student>() {

			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s = new Student();
				s.setStdid(rs.getString(1));
				s.setStdpwd(rs.getString(2));
				s.setStdname(rs.getString(3));
				s.setStdaddress(rs.getString(4));
				s.setStdage(rs.getInt(5));
				s.setStdmob(rs.getLong(6));
				return s;
	}

});
	}
	}
	
	
