package br.inatel.pcmania.Computador;

public class Computador {
    private String marca;
    private float preco;
    private SistemaOperacional sistemaOperacional;
    private MemoriaUSB memoriaUSB;
    private HardwareBasico[] hardwares; // Array para os 3 componentes básicos

    public Computador(String marca, float preco) {
        this.marca = marca;
        this.preco = preco;
        this.hardwares = new HardwareBasico[3]; // Inicializa o espaço para 3 hardwares
    }

    // Método para imprimir as configurações de forma organizada
    public void mostraConfigs() {
        System.out.println("Marca: " + this.marca);
        System.out.println("Preço: R$" + this.preco);

        if (sistemaOperacional != null) {
            System.out.println("Sistema: " + sistemaOperacional.getNome() + " (" + sistemaOperacional.getTipo() + " bits)");
        }

        for (HardwareBasico hb : hardwares) {
            if (hb != null) {
                System.out.println(hb.getNome() + ": " + (int)hb.getCapacidade() + " unidades/MHz/Gb");
            }
        }

        if (memoriaUSB != null) {
            System.out.println("Brinde: " + memoriaUSB.getNome() + " de " + memoriaUSB.getCapacidade() + "Gb");
        }
    }

    // Métodos para "montar" o computador
    public void addMemoriaUSB(MemoriaUSB musb) { this.memoriaUSB = musb; }
    public void setSistemaOperacional(SistemaOperacional so) { this.sistemaOperacional = so; }

    // Adiciona hardware na primeira posição vazia (null) do array
    public void addHardware(HardwareBasico hb) {
        for (int i = 0; i < hardwares.length; i++) {
            if (hardwares[i] == null) {
                this.hardwares[i] = hb;
                break;
            }
        }
    }

    public float getPreco() {
        return preco;
    }
}
