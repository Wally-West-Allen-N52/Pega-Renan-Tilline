package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Vaga;

public class VagaDao {

	public void save(Vaga vaga) {

		String sql = "INSERT INTO Vaga (linkVaga, vaga) VALUES (?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, vaga.getLinkVaga());
			pstm.setString(2, vaga.getVaga());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void removeById(int idVaga) {

		String sql = "DELETE FROM Vaga WHERE idVaga = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);

			pstm.setInt(1, idVaga);

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void update(Vaga vaga) {

		String sql = "UPDATE Vaga SET linkVaga = ?, vaga = ? WHERE idVaga = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, vaga.getLinkVaga());
			pstm.setString(2, vaga.getVaga());
			pstm.setInt(3, vaga.getIdVaga());

			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static List<Vaga> getVaga() {

		String sql = "SELECT * FROM Vaga";
//				+ "v.linkVaga, v.vaga"
//				+ "c.setor, c.responsavel, c.cnpj, c.empresa"
//				+ "FROM Vaga as v\r\n"
//				+ "INNER JOIN Cadastro as c on c.FkVagas = v.linkVaga";

		List<Vaga> vagas = new ArrayList<Vaga>();

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {

			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Vaga vaga = new Vaga();
				vaga.setIdVaga(rset.getInt("idVaga"));
				vaga.setLinkVaga(rset.getString("linkVaga"));
				vaga.setVaga(rset.getString("vaga"));

				vagas.add(vaga);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vagas;
	}
}
