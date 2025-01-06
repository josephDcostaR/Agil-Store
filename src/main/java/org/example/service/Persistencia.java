package org.example.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.example.model.Produto;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.getType;

public class Persistencia {

    private static final String ARQUIVO_JSON = "produtos.json";
    private static final Gson gson = new Gson();

    //Salvar a lista dos produtos em json
    public static void salvarProdutos(List<Produto> produtos) {
        try(FileWriter writer = new FileWriter(ARQUIVO_JSON)) {
            gson.toJson(produtos, writer);
        }catch (IOException e) {
            System.err.println("Erro ao salvar os dados: " + e.getMessage());
        }
    }

    //Carregar a lista dos produtos em json
    public static List<Produto> carregarProdutos() {
        try(FileReader reader = new FileReader(ARQUIVO_JSON)) {
            Type tipoLista = new TypeToken<List<Produto>>() {}.getType();
            return gson.fromJson(reader, tipoLista);
        }catch (IOException e) {
            System.out.println("Arquivo não encontrado ou vazio. Criando nova lista.");
            return new ArrayList<>();
        }
    }
}
