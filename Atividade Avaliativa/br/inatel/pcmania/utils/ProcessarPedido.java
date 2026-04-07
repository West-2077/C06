package br.inatel.pcmania.utils;
import br.inatel.pcmania.Computador.Computador;

public class ProcessarPedido {

    public static void enviarPedido(Computador[] computador){

        boolean temComputador = false;

        for( Computador pc: computador){
            if(pc != null){
                temComputador = true;
                break;
            }
        }

        if(temComputador){
            System.out.println("Pedido enviado...");
        }

        else
        {
            System.out.println("Carrinho vazio. Nenhum pedido para enviar.");
        }
    }
}
