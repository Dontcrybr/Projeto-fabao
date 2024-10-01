
package Controller;

import static View.Tela2_GUI.rg_txt;
import java.util.Random;
import static View.Tela_GUI.cpf_txt;


public class logica_DAO {

    public static void gerarCPF() {
        
        Random ale = new Random();
        int[] cpf = new int[11]; 
        int[] peso = {10, 9, 8, 7, 6, 5, 4, 3, 2};
        int[] peso2 = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        

        
        for (int i = 0; i < 9; i++) {
            cpf[i] = ale.nextInt(10);
        }
        
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += cpf[i] * peso[i];
        }
        
        int resto1 = soma % 11;
        cpf[9] = (resto1 < 2) ? 0 : 11 - resto1; 

        int soma1 = 0;
        for (int i = 0; i < 10; i++) {
            soma1 += cpf[i] * peso2[i];
        }
         
        int resto2 = soma1 % 11;
        cpf[10] = (resto2 < 2) ? 0 : 11 - resto2; 
        
        
        String cpfFormatado = String.format("%03d.%03d.%03d-%02d", 
            cpf[0] * 100 + cpf[1] * 10 + cpf[2], 
            cpf[3] * 100 + cpf[4] * 10 + cpf[5], 
            cpf[6] * 100 + cpf[7] * 10 + cpf[8], 
            cpf[9] * 10 + cpf[10]);
        
        // Define o texto do JLabel
        cpf_txt.setText(cpfFormatado);
    }

    public static void limpar() {
        cpf_txt.setText("");
    }
    
    public static void limpar2() {
        rg_txt.setText("");
    }

    
    public static void GerarRG() {
         Random ale = new Random();
        int[] rg = new int[9];  // 8 dígitos do RG mais o dígito verificador
        int[] peso = {2, 3, 4, 5, 6, 7, 8, 9};  // Pesos usados no cálculo do dígito verificador

        // Gerar os 8 primeiros dígitos do RG
        for (int i = 0; i < 8; i++) {
            rg[i] = ale.nextInt(10);  // Gera dígitos aleatórios entre 0 e 9
        }

        // Cálculo do dígito verificador
        int soma = 0;
        for (int i = 0; i < 8; i++) {
            soma += rg[i] * peso[i];  // Soma ponderada dos dígitos do RG
        }
        int resto = soma % 11;

        // Verifica o resto para definir o dígito verificador
        rg[8] = (resto == 0 || resto == 1) ? 0 : 11 - resto; 

    
        // Formata o RG com o dígito verificador
         String rgFormatado = String.format("%02d.%03d.%03d-%01d", 
            rg[0] * 10 + rg[1],               // Primeiros 2 dígitos
            rg[2] * 100 + rg[3] * 10 + rg[4], // Próximos 3 dígitos
            rg[5] * 100 + rg[6] * 10 + rg[7], // Últimos 3 dígitos
            rg[8]);                           // Dígito verificador
         
         rg_txt.setText(rgFormatado);
    }
}



