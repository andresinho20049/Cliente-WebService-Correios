
import java.util.List;
import org.tempuri.CResultado;
import org.tempuri.CServico;

/**
 *
 * @author andre
 */
public class Principal {
    
    public static void main(String[] args) {
        CResultado res = calcPrazo("40010","06835435","06803310");
        List<CServico> lista = res.getServicos().getCServico();
        
            for(CServico c:lista){
                if(c.getErro().equals("")){
                    System.out.println("Prazo de entrega: "+c.getPrazoEntrega());
                }else{
                    System.out.println("Erro: "+ c.getMsgErro());
                }
            }
    }

    private static CResultado calcPrazo(java.lang.String nCdServico, java.lang.String sCepOrigem, java.lang.String sCepDestino) {
        org.tempuri.CalcPrecoPrazoWS service = new org.tempuri.CalcPrecoPrazoWS();
        org.tempuri.CalcPrecoPrazoWSSoap port = service.getCalcPrecoPrazoWSSoap();
        return port.calcPrazo(nCdServico, sCepOrigem, sCepDestino);
    }
    
}
