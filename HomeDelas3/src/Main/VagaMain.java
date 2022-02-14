package Main;

import dao.VagaDao;
import model.Vaga;

public class VagaMain {

	public static void main(String[] args) {
		
		VagaDao vagaDao = new VagaDao();
	
		// ================= save method ===================
		
		Vaga vaga = new Vaga();
		vaga.setLinkVaga("cucunamana.com");
		vaga.setVaga("Vaga da Hora");
		
		vagaDao.save(vaga);
		
	// ======================= remove method =====================
		
//		vagaDao.removeById(2);
		
	// ======================== update ===========================
		
//		Vaga vaga1 = new Vaga();
//		vaga1.setIdVaga(1);
//		vaga1.setLinkVaga("cadevagas.com");
//		vaga1.setVaga("VagaDoida doido");
//		
//		vagaDao.update(vaga1);
		
		// ================== list method ====================
		
		for (Vaga v : vagaDao.getVaga()) {
			System.out.println("\nLink vaga: " + v.getLinkVaga()
			+ "\nVaga: " + v.getVaga());
		}
	}

}



















