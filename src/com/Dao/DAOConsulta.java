

package com.Dao;

import com.Beans.PrazoServico;
import java.util.List;
import javax.swing.JOptionPane;
import org.tempuri.CResultado;
import org.tempuri.CServico;

/**
 *
 * @author andre
 */
public class DAOConsulta {
    
    public  void CalcularPrazo(PrazoServico p) {
        CResultado res = calcPrazo("40010",p.getCepRemetente(),p.getCepDestino());
        List<CServico> lista = res.getServicos().getCServico();
        
            for(CServico c:lista){
                if(c.getErro().equals("")){
                    p.setPrazo(c.getPrazoEntrega());
                }else{
                    JOptionPane.showMessageDialog(null, "Erro: " + c.getMsgErro());
                }
            }
    }

    private static CResultado calcPrazo(java.lang.String nCdServico, java.lang.String sCepOrigem, java.lang.String sCepDestino) {
        org.tempuri.CalcPrecoPrazoWS service = new org.tempuri.CalcPrecoPrazoWS();
        org.tempuri.CalcPrecoPrazoWSSoap port = service.getCalcPrecoPrazoWSSoap();
        return port.calcPrazo(nCdServico, sCepOrigem, sCepDestino);
    }
    
}
