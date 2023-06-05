package br.com.clinica.clinicamedica.Util;

public class Validador {
    public static boolean osDadosNaoSaoVazios(String[] dados)
    {
        if(dados!=null)
        {
            for(String dado:dados)
            {
                if(dado==null || dado.length()<=0)
                    return false;
            }
            return true;
        }
        else
            return false;
    }
}
