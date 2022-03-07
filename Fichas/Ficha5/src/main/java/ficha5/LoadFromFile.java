package ficha5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LoadFromFile {

	public ArrayList<Pessoa> obterInformacaoFicheiro(String nomeFicheiro) {
		ArrayList<Pessoa> ListaPessoa = new ArrayList<Pessoa>();
		try {
			InputStream inputStream = getFileAsIOStream(nomeFicheiro);
			String conteudoFicheiro = getFileContent(inputStream);
			ListaPessoa = convertStringToListPessoa(conteudoFicheiro);
		} catch (Exception e) {
			System.out.println(e);
		}

		return ListaPessoa;

	}

	private InputStream getFileAsIOStream(String nomeFicheiro) {

		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(nomeFicheiro);
		if (inputStream == null) {
			throw new IllegalArgumentException(nomeFicheiro + "não encontrado");

		}
		return inputStream;
	}

	private String getFileContent(InputStream is) {
		String conteudoFicheiro = "";
		try {
			InputStreamReader inStrReader = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(inStrReader);
			String line;
			while ((line = br.readLine()) != null) {
				conteudoFicheiro += line;

			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return conteudoFicheiro;
	}

	private ArrayList<Pessoa> convertStringToListPessoa(String texto) throws JSONException {
		ArrayList<Pessoa> listaPessoasAux = new ArrayList<Pessoa>();
		JSONArray jsonArray = new JSONArray(texto);

		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);

			Pessoa pessoaAux = new Pessoa(jsonObject.getString("Primeiro_nome"), jsonObject.getString("Ultimo_nome"),
					jsonObject.getInt("Idade"), jsonObject.getDouble("Saldo"));
			listaPessoasAux.add(pessoaAux);
		}
		return listaPessoasAux;
	}

}