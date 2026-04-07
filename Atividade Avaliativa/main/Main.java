package br.inatel.pcmania.main;

import br.inatel.pcmania.Cliente.Cliente;
import br.inatel.pcmania.Computador.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int matricula = 628; // Sua matrícula base para os preços
        Cliente cliente = new Cliente("Seu Nome", "123.456.789-00");

        System.out.println(" BEM-VINDO À PC MANIA ");
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("Promoções disponíveis: 1, 2 ou 3 (0 para finalizar)");
            System.out.print("Escolha sua opção: ");
            opcao = entrada.nextInt();

            // Criamos uma variável pc que será configurada de acordo com a escolha
            Computador pc = null;

            switch (opcao) {
                case 1:
                    pc = new Computador("Apple", (float) matricula);
                    pc.setSistemaOperacional(new SistemaOperacional("macOS", 64));
                    pc.addHardware(new HardwareBasico("Pentium Core i3", 2200));
                    pc.addHardware(new HardwareBasico("Memória RAM", 8));
                    pc.addHardware(new HardwareBasico("HD", 500));
                    pc.addMemoriaUSB(new MemoriaUSB("Pendrive", 16));
                    break;
                case 2:
                    pc = new Computador("Samsung", (float) matricula + 1234);
                    pc.setSistemaOperacional(new SistemaOperacional("Windows 8", 64));
                    pc.addHardware(new HardwareBasico("Pentium Core i5", 3370));
                    pc.addHardware(new HardwareBasico("Memória RAM", 16));
                    pc.addHardware(new HardwareBasico("HD", 1000));
                    pc.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));
                    break;
                case 3:
                    pc = new Computador("Dell", (float) matricula + 5678);
                    pc.setSistemaOperacional(new SistemaOperacional("Windows 10", 64));
                    pc.addHardware(new HardwareBasico("Pentium Core i7", 4500));
                    pc.addHardware(new HardwareBasico("Memória RAM", 32));
                    pc.addHardware(new HardwareBasico("HD", 2000));
                    pc.addMemoriaUSB(new MemoriaUSB("HD Externo", 1000));
                    break;
                case 0:
                    System.out.println("Finalizando pedido...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            // Se um PC foi criado, adiciona ao cliente
            if (pc != null) {
                cliente.adicionaComputador(pc);
                System.out.println("PC adicionado ao carrinho!");
            }
        }

        // Relatório Final

        System.out.println("RESUMO DA COMPRA");
        System.out.println("Cliente: " + cliente.getNome() + " | CPF: " + cliente.getCpf());

        // Listar configurações de cada PC comprado
        for (Computador pcComprado : cliente.getComputadores()) {
            if (pcComprado != null) pcComprado.mostraConfigs();
        }

        System.out.println("TOTAL FINAL: R$ " + cliente.calculaTotalCompra());


        entrada.close();
    }
}
