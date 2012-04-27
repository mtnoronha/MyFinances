package relatorio.contas;

import Persistencia.Conectar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class RelContas {

    public static void abrirContasPagarAtraso() {
        try {
            JasperReport relatorioJasper = (JasperReport) JRLoader.loadObject("C:\\CMMSys\\Reports\\Contas\\ContasAPagarEmAtraso.jasper");
            Map parametros = new HashMap();

            JasperFillManager.fillReportToFile(relatorioJasper, "C:\\CMMSys\\Reports\\Contas\\ContasAPagarEmAtraso.jrprint", parametros, Conectar.open());
            JasperViewer.viewReport("C:\\CMMSys\\Reports\\Contas\\ContasAPagarEmAtraso.jrprint", false, false);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
    
        public static void abrirLancamento() {
        try {
            JasperReport relatorioJasper = (JasperReport) JRLoader.loadObject("C:\\CMMSys\\Reports\\Financeiro\\Lancamento.jasper");
            Map parametros = new HashMap();

            JasperFillManager.fillReportToFile(relatorioJasper, "C:\\CMMSys\\Reports\\Financeiro\\Lancamento.jrprint", parametros, Conectar.open());
            JasperViewer.viewReport("C:\\CMMSys\\Reports\\Financeiro\\Lancamento.jrprint", false, false);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }


    public static void abrirContasReceberAtraso() {
        try {
            JasperReport relatorioJasper = (JasperReport) JRLoader.loadObject("C:\\CMMSys\\Reports\\Contas\\ContasAReceberEmAtraso.jasper");
            Map parametros = new HashMap();

            JasperFillManager.fillReportToFile(relatorioJasper, "C:\\CMMSys\\Reports\\Contas\\ContasAReceberEmAtraso.jrprint", parametros, Conectar.open());
            JasperViewer.viewReport("C:\\CMMSys\\Reports\\Contas\\ContasAReceberEmAtraso.jrprint", false, false);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static void abrirContasPagar() {
        try {
            JasperReport relatorioJasper = (JasperReport) JRLoader.loadObject("C:\\CMMSys\\Reports\\Contas\\ContasAPagar.jasper");
            Map parametros = new HashMap();

            JasperFillManager.fillReportToFile(relatorioJasper, "C:\\CMMSys\\Reports\\Contas\\ContasAPagar.jrprint", parametros, Conectar.open());
            JasperViewer.viewReport("C:\\CMMSys\\Reports\\Contas\\ContasAPagar.jrprint", false, false);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static void abrirContasReceber() {
        try {
            JasperReport relatorioJasper = (JasperReport) JRLoader.loadObject("C:\\CMMSys\\Reports\\Contas\\ContasAReceber.jasper");
            Map parametros = new HashMap();

            JasperFillManager.fillReportToFile(relatorioJasper, "C:\\CMMSys\\Reports\\Contas\\ContasAReceber.jrprint", parametros, Conectar.open());
            JasperViewer.viewReport("C:\\CMMSys\\Reports\\Contas\\ContasAReceber.jrprint", false, false);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static void abrirBalancoPatrimonial(Date data1, Date data2) {
        try {
            JasperReport relatorioJasper = (JasperReport) JRLoader.loadObject("C:\\CMMSys\\Reports\\Financeiro\\\\BalancoPatrimonial.jasper");
            Map parametros = new HashMap();
            parametros.put("data1", data1);
            parametros.put("data2", data2);
            JasperFillManager.fillReportToFile(relatorioJasper, "C:\\CMMSys\\Reports\\Financeiro\\\\BalancoPatrimonial.jrprint", parametros, Conectar.open());
            JasperViewer.viewReport("C:\\CMMSys\\Reports\\Financeiro\\\\BalancoPatrimonial.jrprint", false, false);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public static void abrirDRE(Date data1, Date data2) {
        try {
            JasperReport relatorioJasper = (JasperReport) JRLoader.loadObject("C:\\CMMSys\\Reports\\Financeiro\\\\DRE.jasper");
            Map parametros = new HashMap();
            parametros.put("data1", data1);
            parametros.put("data2", data2);
            JasperFillManager.fillReportToFile(relatorioJasper, "C:\\CMMSys\\Reports\\Financeiro\\\\DRE.jrprint", parametros, Conectar.open());
            JasperViewer.viewReport("C:\\CMMSys\\Reports\\Financeiro\\\\DRE.jrprint", false, false);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }

    public void abrirHistoricoLancamento(int p,Date data1,Date data2) {
        try {
            JasperReport relatorioJasper = (JasperReport) JRLoader.loadObject("C:\\CMMSys\\Reports\\Contas\\RelatorioHistoricoPadrao.jasper");
            Map parametros = new HashMap();
            parametros.put("idhistoricopadrao", p);
            parametros.put("dataInicio", data1);
            parametros.put("dataFim", data2);
                                    
            JasperFillManager.fillReportToFile(relatorioJasper, "C:\\CMMSys\\Reports\\Contas\\RelatorioHistoricoPadrao.jrprint", parametros, Conectar.open());
            JasperViewer.viewReport("C:\\CMMSys\\Reports\\Contas\\RelatorioHistoricoPadrao.jrprint", false, false);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
    }
}
