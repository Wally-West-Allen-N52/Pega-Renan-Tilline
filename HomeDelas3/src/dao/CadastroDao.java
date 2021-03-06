package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import factory.ConnectionFactory;
import model.Cadastro;

public class CadastroDao {

	public void save(Cadastro cadastro) {

		String sql = "INSERT INTO Cadastro (setor, responsavel, cnpj, empresa, FkidVaga) VALUES (?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cadastro.getSetor());
			pstm.setString(2, cadastro.getResponsavel());
			pstm.setString(3, cadastro.getCnpj());
			pstm.setString(4, cadastro.getEmpresa());
			pstm.setInt(5, cadastro.getFkidVaga());

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

	public void update(Cadastro cadastro) {

		String sql = "UPDATE Cadastro SET setor = ?, responsavel = ?, cnpj = ?, empresa = ?, FkidVaga = ? WHERE IdCadastro = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);

			pstm.setString(1, cadastro.getSetor());
			pstm.setString(2, cadastro.getResponsavel());
			pstm.setString(3, cadastro.getCnpj());
			pstm.setString(4, cadastro.getEmpresa());
			pstm.setInt(5, cadastro.getFkidVaga());
			pstm.setInt(6, cadastro.getIdCadastro());

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

	public static List<Cadastro> getCadastro() {

		String sql = "SELECT * FROM Cadastro";

		List<Cadastro> cadastros = new ArrayList<Cadastro>();

		Connection conn = null;
		PreparedStatement pstm = null;

		ResultSet rset = null;

		try {

			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Cadastro cadastro = new Cadastro();
				cadastro.setIdCadastro(rset.getInt("IdCadastro"));
				cadastro.setSetor(rset.getString("setor"));
				cadastro.setResponsavel(rset.getString("responsavel"));
				cadastro.setCnpj(rset.getString("cnpj"));
				cadastro.setEmpresa(rset.getString("empresa"));
				cadastro.setFkidVaga(rset.getInt("FkidVaga"));

				cadastros.add(cadastro);
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
		return cadastros;
	}
}
