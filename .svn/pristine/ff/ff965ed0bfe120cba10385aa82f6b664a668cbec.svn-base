package com.ffcs.crmd.cas.base.seq;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;
import com.ffcs.crmd.platform.ddl.core.DefaultCrmSeqService;
import com.ffcs.crmd.platform.pub.utils.sql.Dialect;
import com.ffcs.crmd.platform.pub.utils.sql.DialectUtils;

@Service("crmSeqService")
public class CasSeqService extends DefaultCrmSeqService {

	private JdbcTemplate jdbcTemplate = ApplicationContextUtil.getBean("jdbcTemplate");
	@Override
	public Long getSeq(String seqName) {
		Long id = jdbcTemplate.queryForLong(getSql(seqName));
		return id;
	}

	@Override
	public List<Long> getSeqBatch(String seqName, int size) {
		return super.getSeqBatch(seqName, size);
	}
	
	private String getSql(String seqName) {
		String sql = "";
		
		if (Dialect.MYSQL.dialect().equals(DialectUtils.getDialect().dialect())) {
			sql = "select " + seqName + ".nextval from g_seq";
		} else {
			sql = "select " + seqName + ".nextval from dual";
		}
		return sql;
	}

	
}
