package br.inatel.pcmania.Cliente;

import br.inatel.pcmania.Computador.Computador;

public class Cliente {
    private String nome;
    private String cpf;
    private Computador[] computadores = new Computador[10]; // Limite de 10 compras

    public Cliente(String nome, String cpf) {
        this.nome = nome; // 'this' diferencia o atributo do parâmetro
        this.cpf = cpf;
    }

    // Adiciona o PC comprado ao array do cliente
    public void adicionaComputador(Computador pc) {
        for (int i = 0; i < computadores.length; i++) {
            if (computadores[i] == null) {
                computadores[i] = pc;
                break;
            }
        }
    }

    // Percorre o array somando os preços de cada PC não nulo
    public float calculaTotalCompra() {
        float total = 0;
        for (Computador pc : computadores) {
            if (pc != null) total += pc.getPreco();
        }
        return total;
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public Computador[] getComputadores() {
        return computadores;
    }
}