package com.blusoft.blucargo.dao.ddl;

public interface SchemaConstants {

	String PREFIX = "--";
	String SUFFIX = "=";
	String DROP = PREFIX + "drop";
	String CREATE = PREFIX + "create";
	String HSQL_CREATE_OUTPUT = PREFIX + "hsqlCreateOutput" + SUFFIX;
	String HSQL_DROP_OUTPUT = PREFIX + "hsqlDropOutput" + SUFFIX;
	String ORACLE_CREATE_OUTPUT = PREFIX + "oracleCreateOutput" + SUFFIX;
	String ORACLE_DROP_OUTPUT = PREFIX + "oracleDropOutput" + SUFFIX;
	String DELIMITER = PREFIX + "delimiter" + SUFFIX;
}
