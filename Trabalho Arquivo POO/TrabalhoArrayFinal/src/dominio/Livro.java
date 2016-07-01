package dominio;

public class Livro {
	private String editora, autor, genero, nome; 
	int numPag, ano, codigo;
	
	@Override
	public String toString(){
		return "| Codigo: "+ codigo +"\n| Nome: " + nome + "\t\tAutor: "+ autor +"\n| Editora: " +editora + "\t"
				+ "Genero: " + genero + "\n| Ano: " + ano +"\t\tNumero de Paginas: " + numPag;
	}
	
	public String toString(String delimita){
		return codigo+delimita+nome+delimita+autor+delimita+editora+delimita+genero+delimita+ano+delimita+numPag;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumPag() {
		return numPag;
	}
	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	
	
	
}
