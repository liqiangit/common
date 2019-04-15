package com.liqiang.common.sequence.database.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import com.liqiang.common.sequence.Sequence;
import com.mysql.jdbc.Statement;

/**
 * https://blog.csdn.net/u013803262/article/details/73921136
 * @author YCKJ0224
 *
 */
@Service("mysqlSequence")
public class MysqlSequence implements Sequence {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Long nextval(String sequenceName) {
		//jdbcTemplate.update("insert into mysql_sequence(content) values('content')");
		String sql = "insert into mysql_sequence(content) values('content')";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				return ps;
			}
		}, keyHolder);
		return keyHolder.getKey().longValue();
	}

}
