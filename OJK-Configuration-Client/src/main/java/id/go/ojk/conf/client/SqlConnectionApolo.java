package id.go.ojk.conf.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SqlConnectionApolo {
	private Logger logger = LoggerFactory.getLogger(SqlConnectionApolo.class);
//	private static final String userName = "sa";	//devel
//	private static final String password = "password.1";	//devel	
//	private static final String userName = "admin.lcr";	//production
//	private static final String password = "4dminlcR";	//production
	private final String userName;// = DummySetup.serverConfig.getJdbc().getSqlUser();
	private final String password;// = DummySetup.serverConfig.getJdbc().getSqlPass();

	private final String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";	
	private final String jdbcURLApolo;// = DummySetup.serverConfig.getJdbc().getJdbcApolo();
	private final String jdbcURLCAM;// = DummySetup.serverConfig.getJdbc().getJdbcCAM();
	private final String jdbcURLMaster;// = DummySetup.serverConfig.getJdbc().getJdbcMaster();

	private static Connection databaseConnection = null;
//
//	public static void main(String[] args) {
////		System.out.println(getKeyApolo().get("010101-011"));
////		System.out.println(getUserAppAccess().get("bprdummy@gmail.com"));
//		getReportBySector();
//
//	}

	public SqlConnectionApolo(String enviType) {
		DummyServerConfig serverConfig = DummyEnvironment.config(EEnvironment.valueOf(enviType));
		userName = serverConfig.getJdbc().getSqlUser();
		password = serverConfig.getJdbc().getSqlPass();
		jdbcURLApolo = serverConfig.getJdbc().getJdbcApolo();
		jdbcURLCAM = serverConfig.getJdbc().getJdbcCAM();
		jdbcURLMaster = serverConfig.getJdbc().getJdbcMaster();
	}
	
	public Map<String, List<String>> getKeyApolo() {
		Map<String, List<String>> mapKeyApolo = new HashMap<>();
//		String queryString = "SELECT B.EntityCode, A.PublicKeyClientPath, A.PrivateKeyServerPath "
//				+ "FROM [APOLO_Rev1].[dbo].[Key] A "
//				+ "LEFT JOIN CAM.dbo.[Application.Entity] B "
//				+ "ON A.EntityId=B.EntityId "
//				+ "AND A.DeleteFlag=B.DeleteFlag "
//				+ "ORDER BY B.NaturalEntityCode";
		
		String queryString = "SELECT B.EntityCode, A.PublicKeyClientPath, A.PrivateKeyServerPath "
				+ "FROM [APOLO].[dbo].[Key] A "
				+ "LEFT JOIN CAM.dbo.[Application.Entity] B "
				+ "ON A.EntityId=B.EntityId "
				+ "AND A.DeleteFlag=B.DeleteFlag "
				+ "ORDER BY B.NaturalEntityCode";
		ResultSet rs = null;
		try {
			rs = getQuery(jdbcURLMaster, queryString);
			while (rs.next()) {
				List<String> keyApolo = new ArrayList<String>();
				String cpub = rs.getString(2).replace("ftp://localhost:889/KEY/", "");
				String spriv = rs.getString(3).replace("ftp://localhost:889/KEY/", "");
				
				keyApolo.add(cpub);
				keyApolo.add(spriv);
				
				mapKeyApolo.put(rs.getString(1), keyApolo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeDbCon();
		}
		
		return mapKeyApolo;
	}
	
	public Map<String, List<String>> getReportBySector() {
		Map<String, List<String>> mapReportBySector = new HashMap<String, List<String>>();
		String queryString = "SELECT DISTINCT A.MenuId, B.SectorCode "
				+ "FROM [CAPT].[Report] A "
				+ "LEFT JOIN CAPT.ReportSector B "
				+ "ON A.ReportId = B.ReportId "
				+ "AND A.DeleteFlag = B.DeleteFlag";
		ResultSet rs = null;
		try {
			rs = getQuery(jdbcURLApolo, queryString);
			while (rs.next()) {
				if(!mapReportBySector.containsKey(rs.getString(1))) {
					List<String> sectorCode = new ArrayList<String>();
					sectorCode.add(rs.getString(2));
					
					mapReportBySector.put(rs.getString(1), sectorCode);
				} else {
					List<String> sectorCode = mapReportBySector.get(rs.getString(1));
					sectorCode.add(rs.getString(2));
					
					mapReportBySector.replace(rs.getString(1), sectorCode);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeDbCon();
		}
		
		return mapReportBySector;
	}

	public Map<String, String> getMapReport() {
		Map<String, String> mapReport = new HashMap<>();		
		String queryString = "SELECT MenuId, ReportCode, ReportName FROM [CAPT].[Report] "
				+ "where reportcode not in ('PEKAP','LSF')";
		ResultSet rs = null;
		try {
			rs = getQuery(jdbcURLApolo, queryString);
			while (rs.next()) {
				mapReport.put((rs.getString(1) + "|" + rs.getString(2)), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeDbCon();
		}
		
		return mapReport;
	}
	
	public Map<String, List<String>> getUserAppAccess() {
		Map<String, List<String>> userAppAccess = new HashMap<String, List<String>>();		
		String queryString = "SELECT DISTINCT A.UserId, D.UserName, C.MenuId, C.MenuName "
				+ "FROM [dbo].[Akses.UserApplication] A "
				+ "LEFT JOIN [dbo].[Akses.RoleMenu] B "
				+ "ON A.RoleId=B.RoleId "
				+ "AND A.ActiveFlag=B.ActiveFlag "
				+ "AND A.DeleteFlag=B.DeleteFlag "
				+ "LEFT JOIN [dbo].[Akses.Menu] C "
				+ "ON B.MenuId=C.MenuId "
				+ "AND B.ActiveFlag=C.ActiveFlag "
				+ "AND B.DeleteFlag=C.DeleteFlag "
				+ "LEFT JOIN [dbo].[Akses.User] D "
				+ "ON A.UserId=D.UserId "
				+ "AND A.ActiveFlag=D.ActiveFlag "
				+ "AND A.DeleteFlag=D.DeleteFlag "
				+ "WHERE A.ApplicationId='10' "
				+ "AND A.ActiveFlag='1' "
				+ "AND A.DeleteFlag='0' "
				+ "AND C.MenuItemTypeCode='CANAL' "
				+ "AND D.UsrTypeLookup='EXT' "
				+ "AND C.ParentMenuCode IS NOT NULL "
				+ "ORDER BY A.UserId ASC";
		ResultSet rs = null;
		try {
			rs = getQuery(jdbcURLCAM, queryString);
			while (rs.next()) {
				if(!userAppAccess.containsKey(rs.getString(2))) {
					List<String> appAccess = new ArrayList<String>();
					appAccess.add(rs.getString(3));
					
					userAppAccess.put(rs.getString(2), appAccess);
				} else {
					List<String> appAccess = userAppAccess.get(rs.getString(2));
					appAccess.add(rs.getString(3));
					
					userAppAccess.replace(rs.getString(2), appAccess);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResultSet(rs);
			closeDbCon();
		}
		return userAppAccess;
	}

	private void closeDbCon() {
		try {
			databaseConnection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private ResultSet getQuery(String jdbcURL,String queryString) {
//		System.out.println("Program started");
		try {
			Class.forName(jdbcDriver).newInstance();
//			System.out.println("JDBC driver loaded");
		} catch (Exception err) {
			logger.error(err.getMessage(), err);
			System.exit(0);
		}

		ResultSet rs = null;
		try {
			databaseConnection = DriverManager.getConnection(jdbcURL, userName, password);
//			System.out.println("Connected to the database \n");
			Statement sqlStatement = databaseConnection.createStatement();

			// execute the query
			rs = sqlStatement.executeQuery(queryString);
		} catch (SQLException err) {
			logger.error(err.getMessage(), err);
			System.exit(0);
		}

		return rs;
	}

}
