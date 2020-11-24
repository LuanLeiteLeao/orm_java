package persistence;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.ModelGeneric;
import model.Plataformas;

public class TesteDeConeção {
	public static void main(String[] args) {
	DataBaseConnection con = DataBaseConnection.getIntancia();
	DatabaseQuerys q = new DatabaseQuerys();
	Plataformas minhaCasa = new Plataformas();
	minhaCasa.getNameFields();
//	
//	ArrayList<Plataformas> a = (ArrayList<Plataformas>) q.listar(minhaCasa);
//	for (Plataformas modelGeneric : a) {
//	
//		System.out.println(modelGeneric.getPlataformasId());
//		System.out.println(modelGeneric.getNome());
//		System.out.println(modelGeneric.getCriacao());
//		System.out.println(modelGeneric.getModificacao());
//	}

	minhaCasa.setPlataformasId(90);
	minhaCasa.setNome("Test");
	minhaCasa.setCriacao(new Date());
	minhaCasa.setModificacao(new Date());
//	q.inserir(minhaCasa); 
	q.remover(minhaCasa);
	
	
	}
}
