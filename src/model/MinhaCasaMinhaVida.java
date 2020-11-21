package model;

public class MinhaCasaMinhaVida extends ModelGeneric {
	public Integer test1;
	public Integer test2;
	public Integer lulaLadrao;
	public String meuNome;

	public Integer getTest1() {
		return test1;
	}

	public void setTest1(Integer test1) {
		this.test1 = test1;
	}

	public Integer getTest2() {
		return test2;
	}

	public void setTest2(Integer test2) {
		this.test2 = test2;
	}

	public Integer getLulaLadrao() {
		return lulaLadrao;
	}

	public void setLulaLadrao(Integer test3) {
		this.lulaLadrao = test3;
	}

	public String getMeuNome() {
		return meuNome;
	}

	public void setMeuNome(String meuNome) {
		this.meuNome = meuNome;
	}

	@Override
	public String toString() {

		return getTest1() + " " + getTest2() + " " + getLulaLadrao()+" "+getMeuNome();
	}
}
