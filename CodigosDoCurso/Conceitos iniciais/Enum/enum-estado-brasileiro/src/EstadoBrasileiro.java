// Criando o enum EstadoBrasileiro para ser usado em toda a aplicação.

public enum EstadoBrasileiro {
	SAO_PAULO ("SP","São Paulo", 11),
	RIO_JANEIRO ("RJ", "Rio de Janeiro", 12),
	PIAUI ("PI", "Piauí", 13),
	MARANHAO ("MA","Maranhão", 14),
    PARA("PA", "Pará", 15);
	
	private String nome;
	private String sigla;
    private int codigoIBGE;
	
	private EstadoBrasileiro(String sigla, String nome, int codigoIBGE) {
		this.sigla = sigla;
		this.nome = nome;
        this.codigoIBGE = codigoIBGE;
	}
	public String getSigla() {
		return sigla;
	}
	public String getNome() {
		return nome;
	}
    public int getCodigoIBGE() {
        return codigoIBGE;
    }
	public String getNomeMaiusculo() {
		return nome.toUpperCase();
	}
}