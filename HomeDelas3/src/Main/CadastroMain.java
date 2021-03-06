package Main;

import dao.CadastroDao;
import model.Cadastro;

public class CadastroMain {

	public static void main(String[] args) {

		CadastroDao cadastroDao = new CadastroDao();

		// ================= save method ===================

		Cadastro cadastro = new Cadastro();
		cadastro.setSetor("Bancada");
		cadastro.setResponsavel("Paulo Romano");
		cadastro.setCnpj("5555-55555-5555");
		cadastro.setEmpresa("WallaceStrege");
		cadastro.setFkidVaga(1);
				
		cadastroDao.save(cadastro);

		// ======================= remove method =====================

//		vagaDao.removeById(2);

		// ======================== update ===========================

//		Cadastro cadastro1 = new Cadastro();
//		cadastro1.setSetor("cadevagas.com");
//		cadastro1.setResponsavel("Doida doido");
//		cadastro1.setCnpj("45777-55677");
//		cadastro1.setEmpresa("Raga Tanga");
//		cadastro1.setFkidVaga(1);
//		cadastro1.setIdCadastro(1);
//		
//		
//		
//		cadastroDao.update(cadastro1);

		// ================== list method ====================

		for (Cadastro c : cadastroDao.getCadastro()) {
			System.out.println(
					"\nSetor: " + c.getResponsavel()
					+ "\nVaga: " + c.getCnpj()
					+ "\nEmpresa: " + c.getEmpresa());
		}
	}

}
