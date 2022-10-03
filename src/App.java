import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        
        double salario, gt_medicos, gt_educacionais, rd_anual_sal, rd_anual_prt_serv,
        rd_anual_gnh_capt, imp_sob_sal, imp_sob_serv, imp_sob_gnh_capt,
        taxa_imp_sal, max_dedutivel, gt_dedutivel, imp_bruto, taxa_max_dedutivel,
        imp_devido, gt_dedutivel_total, abatimento, taxa_abatimento;

        
        System.out.print("Renda Anual Com Salário: ");
        rd_anual_sal = sc.nextDouble();
        System.out.print("Renda Anual Com Prestação de Serviços: ");
        rd_anual_prt_serv = sc.nextDouble();
        System.out.print("Renda Anual Com Ganho de Capital: ");
        rd_anual_gnh_capt = sc.nextDouble();
        System.out.print("Gastos Médicos: ");
        gt_medicos = sc.nextDouble();
        System.out.print("Gastos Educacionais: ");
        gt_educacionais = sc.nextDouble();

        taxa_imp_sal = 0;

        salario = rd_anual_sal / 12;

            if(salario < 3000){
                taxa_imp_sal = 0;
            }

            if(salario >= 3001 || salario < 5000){
                taxa_imp_sal = 10;
            }

            if(salario > 5001){
                taxa_imp_sal = 20;
            }
        
        imp_sob_sal = taxa_imp_sal * rd_anual_sal / 100;
        imp_sob_serv = rd_anual_prt_serv * 15 / 100;
        imp_sob_gnh_capt = rd_anual_gnh_capt * 20 / 100;

        imp_bruto = imp_sob_sal + imp_sob_serv + imp_sob_gnh_capt;
        max_dedutivel = imp_bruto * 30 / 100;

        gt_dedutivel_total = gt_medicos + gt_educacionais;
        gt_dedutivel = gt_medicos + gt_educacionais;  
        taxa_abatimento = imp_bruto * 30 / 100;        
        abatimento = taxa_abatimento;

            if(gt_dedutivel <  taxa_abatimento){
                abatimento = gt_dedutivel;
            }

        imp_devido = imp_bruto - abatimento;

        System.out.println();
        System.out.println("RELATÓRIO DE IMPOSTO DE RENDA:");
        System.out.println();
        System.out.println("CONSOLIDADE DE RENDA:");
        System.out.printf("Imposto  sobre salário: %.2f\n", imp_sob_sal);
        System.out.printf("Imposto sobre serviço: %.2f\n", imp_sob_serv);
        System.out.printf("Imposto sobre ganho de capital: %.2f\n", imp_sob_gnh_capt);
        System.out.println();
        System.out.println("DEDUÇÕES");
        System.out.printf("Máximo dedutivel: %.2f\n", max_dedutivel);
        System.out.printf("Gastos dedutiveis: %.2f\n", gt_dedutivel_total);
        System.out.println();
        System.out.println("RESUMO");
        System.out.printf("Imposto bruto total: %.2f\n", imp_bruto);
        System.out.printf("Abatimento: %.2f\n", abatimento);
        System.out.printf("Imposto devido: %.2f\n", imp_devido);
        System.out.println();

            sc.close();


    }
}
