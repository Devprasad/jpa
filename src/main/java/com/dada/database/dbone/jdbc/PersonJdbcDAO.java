package com.dada.database.dbone.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository //Talks to db
public class PersonJdbcDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	class PersonRowMapper implements RowMapper<JDBCPerson>{

		@Override
		public JDBCPerson mapRow(ResultSet rs, int rowNum) throws SQLException {
			JDBCPerson p = new JDBCPerson();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setLocation(rs.getString("location"));
			p.setBirthdate(rs.getTimestamp("birthdate"));
			return p;
		}
		
	}
	
	public List<JDBCPerson> findAll(){
		return jdbcTemplate.query("select * from person", new BeanPropertyRowMapper<JDBCPerson>(JDBCPerson.class));
	}
	
	
	//BeanPropertyRowMapper to map database row to Person class or create your own RowMapper
	public JDBCPerson findById(int id){
		return jdbcTemplate.queryForObject("select * from person where id=?", 
				new Object[] {id}, new PersonRowMapper());
	}
	
	//Or add annotations to Person class: https://stackoverflow.com/a/53077343/6766414?? did't try
	public List<JDBCPerson> findByName(String name){
		return jdbcTemplate.query("select * from person where name=?", new Object[] {name}, new BeanPropertyRowMapper<JDBCPerson>(JDBCPerson.class));
	}
	
	
	public int DeleteById(int id){
		return jdbcTemplate.update("delete from person where id=?", new Object[] {id});
	}
	
	
	public int DeleteByIdAndName(int id, String name){
		return jdbcTemplate.update("delete from person where id=? and name=?", new Object[] {id, name});
	}
	
	
	public int insert(JDBCPerson p) {
		return jdbcTemplate.update("insert into person(id, name, location, birthdate) values (?,?,?,?)",
				p.getId(), p.getName(), p.getLocation(), new Timestamp(p.getBirthdate().getTime()));
	}
	
	public int update(JDBCPerson p) {
		return jdbcTemplate.update("update person "+
						" set name= ?, location = ?, birthdate = ? "+
						" where id = ?",
				p.getName(), p.getLocation(), new Timestamp(p.getBirthdate().getTime()), p.getId());
	}
	
}

