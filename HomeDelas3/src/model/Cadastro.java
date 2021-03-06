package model;

public class Cadastro {
	private int idCadastro;
	private String setor;
	private String responsavel;
	private String cnpj;
	private String empresa;
	
	// Foreign keys
	private int FkidVaga;
	private Vaga vaga;
	
	public int getIdCadastro() {
		return idCadastro;
	}
	public void setIdCadastro(int idCadastro) {
		this.idCadastro = idCadastro;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public int getFkidVaga() {
		return FkidVaga;
	}
	public void setFkidVaga(int fkidVaga) {
		FkidVaga = fkidVaga;
	}
	public Vaga getVaga() {
		return vaga;
	}
	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}
	
	
}
