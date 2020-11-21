package persistence;

import java.util.ArrayList;

import model.MinhaCasaMinhaVida;
import model.ModelGeneric;
import model.Plataformas;

public class TesteDeConeção {
	public static void main(String[] args) {
	DataBaseConnection con = DataBaseConnection.getIntancia();
	DatabaseQuerys q = new DatabaseQuerys();
	Plataformas minhaCasa = new Plataformas();
	
	ArrayList<ModelGeneric> a = q.listar(minhaCasa);
	for (ModelGeneric modelGeneric : a) {
		Plataformas p = (Plataformas) modelGeneric;
		System.out.println(p.getPlataformasId());
		System.out.println(p.getNome());
		System.out.println(p.getCriacao());
		System.out.println(p.getModificacao());
	}
	}
}
