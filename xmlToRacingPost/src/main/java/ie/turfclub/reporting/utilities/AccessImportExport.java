package ie.turfclub.reporting.utilities;

import ie.turfclub.pojos.AccessTableToMySQLTableObject;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.healthmarketscience.jackcess.DatabaseBuilder;
import com.healthmarketscience.jackcess.Row;
import com.healthmarketscience.jackcess.Table;

public class AccessImportExport {

	private SimpleDateFormat dateSQLFormat = new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat dateFormat = new SimpleDateFormat(
			"EEE MMM dd HH:mm:ss ZZZ yyyy");

	public void readFromAccessToMysql(
			AccessTableToMySQLTableObject mySQLAccessObject, boolean truncate, String notExists, String notExistsAccessHeader)
			throws IOException, ParseException {

		Table table = DatabaseBuilder.open(
				new File(mySQLAccessObject.getAccessFilePath())).getTable(
				mySQLAccessObject.getAccessTable());

		ArrayList<String> accessHeaders = mySQLAccessObject
				.getAccessTableFields();
		ArrayList<String> mySQLHeaders = mySQLAccessObject
				.getMySQLTableFields();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Connection conn = null;
		try {
			conn = DriverManager.getConnection(mySQLAccessObject
					.getMySQLConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String sql;

		if (truncate) {
			sql = "TRUNCATE " + mySQLAccessObject.getMySQLTable();
			try {
				stmt.execute(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		;

		System.out.println("table emptied");
		for (Row row : table) {
			StringBuilder stringSQLBegining = new StringBuilder();
			stringSQLBegining.append("INSERT INTO "
					+ mySQLAccessObject.getMySQLTable() + " (");
			StringBuilder stringSQLEnding = new StringBuilder();
			stringSQLEnding.append(" VALUES(");
			String header;
			String notExistsValue = null;
			for (int i = 0; i < mySQLHeaders.size(); i++) {

				header = accessHeaders.get(i);
				if(header.equals(notExistsAccessHeader)){
					notExistsValue = row.get(header).toString();;
					System.out.println(notExistsValue);
				}
				// String mySQLHeader = mySQLHeaders.get(i);
				// System.out.println(header + " " + mySQLHeader + " " + i);
				if (header.contains(",")) {
					Object rowString = null;
					String rowStr = "";
					int subCount = 0;
					for (String subHeader : header.split(",")) {

						rowString = row.get(subHeader);
						if (rowString != null) {
							if (subCount == 0) {
								rowStr += rowString.toString();
							} else {
								rowStr += " " + rowString.toString();
							}

						}
						subCount++;

					}

					if (rowStr != "") {

						if (rowStr.contains("'") || rowStr.contains("’")) {
							rowStr = rowStr.replaceAll("’", "'")
									.replaceAll("'", "''").trim();
						}
						if (i == accessHeaders.size() - 1) {
							stringSQLBegining.append(mySQLHeaders.get(i));
							stringSQLEnding.append("'" + rowStr + "'");
						} else {
							stringSQLBegining
									.append(mySQLHeaders.get(i) + ", ");
							stringSQLEnding.append("'" + rowStr + "' , ");
						}

					}
				} else if (header.toLowerCase().contains("address")) {
					System.out.println(header);
					Object rowString = row.get(header);
					if (rowString != null) {

						if (i == accessHeaders.size() - 1) {

							stringSQLEnding.append("'"
									+ StringToTitleCase.convertString(rowString
											.toString().replaceAll("’", "'")
											.replaceAll("'", "''").trim())
									+ "'");
							stringSQLBegining.append(mySQLHeaders.get(i));
						} else {

							stringSQLEnding.append("'"
									+ StringToTitleCase.convertString(rowString
											.toString().replaceAll("’", "'")
											.replaceAll("'", "''").trim())
									+ "', ");
							stringSQLBegining
									.append(mySQLHeaders.get(i) + ", ");
						}

					}
				} else {
					Object rowString = row.get(header);
					if (rowString != null) {
						if (rowString.toString().contains(" BST ")
								|| rowString.toString().contains(" GMT ")) {
							if (i == accessHeaders.size() - 1) {
								stringSQLBegining.append(mySQLHeaders.get(i));
								stringSQLEnding.append("'"
										+ dateSQLFormat
												.format(dateFormat
														.parse(rowString
																.toString()))
												.toString()
												.replaceAll("'", "''") + "'");
							} else {
								stringSQLBegining.append(mySQLHeaders.get(i)
										+ ", ");
								stringSQLEnding.append("'"
										+ dateSQLFormat
												.format(dateFormat
														.parse(rowString
																.toString()))
												.toString()
												.replaceAll("'", "''") + "', ");
							}
							// System.out.println();

						}

						else {
							if (i == accessHeaders.size() - 1) {
								if (checkIfPhoneNo(rowString.toString())) {
									stringSQLEnding.append("'"
											+ rowString.toString()
													.replaceAll("’", "'")
													.replaceAll("'", "''")
													.replaceAll("-", "")
													.replaceAll("\\s", "")
													.trim() + "'");

								} else {
									stringSQLEnding.append("'"
											+ rowString.toString()
													.replaceAll("’", "'")
													.replaceAll("'", "''")
													.trim() + "'");

								}
								stringSQLBegining.append(mySQLHeaders.get(i));
							} else {
								if (checkIfPhoneNo(rowString.toString())) {
									stringSQLEnding.append("'"
											+ rowString.toString()
													.replaceAll("’", "'")
													.replaceAll("'", "''")
													.replaceAll("-", "")
													.replaceAll("\\s", "")
													.trim() + "', ");

								} else {
									stringSQLEnding.append("'"
											+ rowString.toString()
													.replaceAll("’", "'")
													.replaceAll("'", "''")
													.trim() + "', ");

								}
								stringSQLBegining.append(mySQLHeaders.get(i)
										+ ", ");
							}

						}

					}
				}

			}
			stringSQLBegining.append(")");
			stringSQLEnding.append(")");
			sql = stringSQLBegining.toString() + stringSQLEnding.toString();
			if (sql.endsWith(", )")) {
				sql = sql.replace(", )", ")");
			}
			if (sql.substring(
					sql.lastIndexOf("VALUES('") + "VALUES('".length(),
					sql.lastIndexOf("')")).length() < 1) {
				// System.out.println(sql.substring(sql.lastIndexOf("VALUES('"),
				// sql.lastIndexOf("')")).length() + sql);
				System.out.println("|"
						+ sql.substring(sql.lastIndexOf("VALUES('")
								+ "VALUES('".length(), sql.lastIndexOf("')"))
						+ "|");
				// stmt.execute(sql);
			} else {
				// System.out.println(sql.substring(sql.lastIndexOf("VALUES('"),
				// sql.lastIndexOf("')")).length() + sql);

				sql = convertToMySQLBoolean(sql);
				if(notExists.length() > 0){
					System.out.println(sql + notExists + notExistsValue + "')");
				}
				
				else{
					
				}
				try {
					stmt.execute(sql );
				} catch (SQLException e) {
					System.out.println("IGNORE " + e);
				}
			}

		}

	}

	public void copyOfficialsFromAccessToMysql(
			AccessTableToMySQLTableObject mySQLAccessObject)
			throws IOException, ParseException, SQLException {

		Table table = DatabaseBuilder.open(
				new File(mySQLAccessObject.getAccessFilePath())).getTable(
				mySQLAccessObject.getAccessTable());

		ArrayList<String> accessHeaders = mySQLAccessObject
				.getAccessTableFields();
		ArrayList<String> mySQLHeaders = mySQLAccessObject
				.getMySQLTableFields();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Connection conn = null;
		try {
			conn = DriverManager.getConnection(mySQLAccessObject
					.getMySQLConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement stmt = conn.createStatement();
		String sql = "";

		for (Row row : table) {
			StringBuilder stringSQLBegining = new StringBuilder();
			stringSQLBegining.append("INSERT IGNORE INTO "
					+ mySQLAccessObject.getMySQLTable() + " (");
			StringBuilder stringSQLEnding = new StringBuilder();
			stringSQLEnding.append(" VALUES(");
			String header;
			for (int i = 0; i < mySQLHeaders.size(); i++) {

				header = accessHeaders.get(i);
				// String mySQLHeader = mySQLHeaders.get(i);
				// System.out.println(header + " " + mySQLHeader + " " + i);

				Object rowString = row.get(header);
				if (rowString != null) {

					if (rowString.toString().endsWith(",")) {
						rowString = rowString.toString().replaceAll(",", "");
					}

					if (i == accessHeaders.size() - 1) {

						stringSQLEnding.append("'"
								+ rowString.toString().replaceAll("’", "'")
										.replaceAll("'", "''").trim() + "'");

						stringSQLBegining.append(mySQLHeaders.get(i));
					} else {

						stringSQLEnding.append("'"
								+ rowString.toString().replaceAll("’", "'")
										.replaceAll("'", "''").trim() + "', ");

						stringSQLBegining.append(mySQLHeaders.get(i) + ", ");
					}

				}

			}

			stringSQLBegining.append(")");
			stringSQLEnding.append(")");
			sql = stringSQLBegining.toString() + stringSQLEnding.toString();
			if (sql.endsWith(", )")) {
				sql = sql.replace(", )", ")");
			}
			if (sql.substring(
					sql.lastIndexOf("VALUES('") + "VALUES('".length(),
					sql.lastIndexOf("')")).length() < 1) {
				// System.out.println(sql.substring(sql.lastIndexOf("VALUES('"),
				// sql.lastIndexOf("')")).length() + sql);
				System.out.println("|"
						+ sql.substring(sql.lastIndexOf("VALUES('")
								+ "VALUES('".length(), sql.lastIndexOf("')"))
						+ "|");
				// stmt.execute(sql);
			} else {
				// System.out.println(sql.substring(sql.lastIndexOf("VALUES('"),
				// sql.lastIndexOf("')")).length() + sql);
				System.out.println(sql.substring(sql.lastIndexOf("VALUES('")
						+ "VALUES('".length(), sql.lastIndexOf("')")));
				System.out.println(sql);
				sql = convertToMySQLBoolean(sql);
				stmt.execute(sql);
			}

		}

	}

	private String convertToMySQLBoolean(String input) {
		input = input.replaceAll("'true'", "'1'");
		input = input.replaceAll("'false'", "'0'");
		return input;

	}

	private boolean checkIfPhoneNo(String input) {
		String re1 = "(\\d+)"; // Integer Number 1
		String re2 = "(-)"; // Any Single Character 1
		String re3 = "(\\d+)"; // Integer Number 2
		String re4 = "(\\s+)";

		Pattern p = Pattern.compile(re1 + re2 + re3, Pattern.CASE_INSENSITIVE
				| Pattern.DOTALL);
		Pattern pt = Pattern.compile(re1 + re4 + re3, Pattern.CASE_INSENSITIVE
				| Pattern.DOTALL);
		Matcher m = p.matcher(input);
		Matcher ma = pt.matcher(input);
		if (m.find() || ma.find()) {
			return true;
		}
		return false;
	}

	
	
	
	
	public void updateTrainersTable(
			AccessTableToMySQLTableObject mySQLAccessObject)
			throws IOException {
		Table table = DatabaseBuilder.open(
				new File(mySQLAccessObject.getAccessFilePath())).getTable(
				mySQLAccessObject.getAccessTable());

		ArrayList<String> accessHeaders = mySQLAccessObject
				.getAccessTableFields();
		ArrayList<String> mySQLHeaders = mySQLAccessObject
				.getMySQLTableFields();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Connection conn = null;
		try {
			conn = DriverManager.getConnection(mySQLAccessObject
					.getMySQLConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "";

		System.out.println("Rows:" + table.getRowCount());
		for (Row row : table) {
			StringBuilder stringSQLBegining = new StringBuilder();
			stringSQLBegining.append("UPDATE "
					+ mySQLAccessObject.getMySQLTable() + " SET ");

			String header;
			for (int i = 0; i < mySQLHeaders.size(); i++) {

				header = accessHeaders.get(i);
				// String mySQLHeader = mySQLHeaders.get(i);
				// System.out.println(header + " " + mySQLHeader + " " + i);

				Object rowString = row.get(header);
				if (rowString != null) {

					if (rowString.toString().endsWith(",")) {
						rowString = rowString.toString().replaceAll(",", "");
					}

					System.out.println(accessHeaders.size() - 1 + " " + i);
					if (i == accessHeaders.size() - 1) {

						System.out.println(header.toLowerCase());
						if (header.toLowerCase().contains("address")) {
							rowString = capitalizeString(rowString.toString());
						}
						if (header.toLowerCase().contains("phone")
								|| header.toLowerCase().contains("fax")
								|| header.toLowerCase().contains("mobile")) {
							rowString = rowString.toString().replaceAll(
									"[^0-9]", "");
						}

						stringSQLBegining.append(mySQLHeaders.get(i)
								+ "='"
								+ rowString.toString().replaceAll("’", "'")
										.replaceAll("'", "''").trim() + "'");
					} else {

						System.out.println(header.toLowerCase());
						if (header.toLowerCase().contains("address")) {
							rowString = capitalizeString(rowString.toString());
						}
						if (header.toLowerCase().contains("phone")
								|| header.toLowerCase().contains("fax")
								|| header.toLowerCase().contains("mobile")) {
							rowString = rowString.toString().replaceAll(
									"[^0-9]", "");
							if (rowString.equals("")) {
								stringSQLBegining.append(mySQLHeaders.get(i)
										+ "=null, ");
							} else {
								if (rowString.toString().startsWith("353")) {
									rowString = rowString.toString().replace(
											"353", "(+353) ");
								}
								if (rowString.toString().startsWith("44")) {
									rowString = rowString.toString().replace(
											"44", "(+44) ");
								}
								stringSQLBegining.append(mySQLHeaders.get(i)
										+ "='"
										+ rowString.toString()
												.replaceAll("’", "'")
												.replaceAll("'", "''").trim()
										+ "'" + ", ");
							}
						} else {
							stringSQLBegining.append(mySQLHeaders.get(i)
									+ "='"
									+ rowString.toString().replaceAll("’", "'")
											.replaceAll("'", "''").trim() + "'"
									+ ", ");
						}

					}

				} else {
					stringSQLBegining.append(mySQLHeaders.get(i) + "=null, ");
				}

			}

			sql = stringSQLBegining.toString();
			if (sql.endsWith(", ")) {
				sql = stringSQLBegining.toString() + ")";
				sql = sql.replace(", )", "");
			}

			Object accNo = row.get("AccountNo");

			sql = sql + " WHERE trainer_account_no='" + accNo.toString() + "'";

			// System.out.println(sql.substring(sql.lastIndexOf("VALUES('"),
			// sql.lastIndexOf("')")).length() + sql);

			System.out.println(sql);
			sql = convertToMySQLBoolean(sql);
			System.out.println(sql);
			try {
				boolean complete = stmt.execute(sql);
				System.out.println(complete);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static String capitalizeString(String string) {
		char[] chars = string.toLowerCase().toCharArray();
		boolean found = false;
		for (int i = 0; i < chars.length; i++) {
			if (!found && Character.isLetter(chars[i])) {
				chars[i] = Character.toUpperCase(chars[i]);
				found = true;
			} else if (Character.isWhitespace(chars[i]) || chars[i] == '.'
					|| chars[i] == '\'') { // You can add other chars here
				found = false;
			}
		}
		return String.valueOf(chars);
	}

}