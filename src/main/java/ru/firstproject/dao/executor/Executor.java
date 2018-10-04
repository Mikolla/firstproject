package ru.firstproject.dao.executor;


import java.sql.*;

public class Executor {
	private final Connection connection;

	public Executor(Connection connection) {
		this.connection = connection;
	}

	public void execUpdate(String update) {
		try {
			connection.setAutoCommit(false);

			Statement stmt = connection.createStatement();
			stmt.execute(update);
			stmt.close();

			connection.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException ignore) {
			}
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException ignore) {
			}
		}
	}

	public long execUpdateWithKeys(String update) {
		long id = 0;
		try {

			try (PreparedStatement ps = connection.prepareStatement(update, Statement.RETURN_GENERATED_KEYS)) {
				ps.executeUpdate();
				try (ResultSet rs = ps.getGeneratedKeys()) {
					while(rs.next()) {
						id=rs.getInt(1);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			connection.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException ignore) {
			}
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException ignore) {
			}
		}
		return id;
	}




	public <T> T execQuery(String query, ExecutorHelper<T> helper) {
		T result = null;
		try {
			connection.setAutoCommit(false);

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			result = helper.help(resultSet);
			resultSet.close();
			statement.close();

			connection.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			try {
				connection.rollback();
			} catch (SQLException ignore) {
			}
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException ignore) {
			}
		}

		return result;
	}
}