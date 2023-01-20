package estruturaDeDados_Santander_Coders.projetoTeste.libraryOpenCSV

import com.opencsv.bean.StatefulBeanToCsv
import com.opencsv.bean.StatefulBeanToCsvBuilder
import java.nio.file.Files
import java.nio.file.Paths

fun main(args: Array<String>) {
    val writer = Files.newBufferedWriter(Paths.get("utils/deals.csv"))
    val deals = ArrayList<Deal>();

    val deal: Deal = Deal()
    deal.agencia = 1520
    deal.conta = 1
    deal.banco= "SANTANDER"
    deal.titular= "JOAO"
    deal.operacao= "SAQUE"
    deal.dataHora= "2022-02-10T10:13:39"
    deal.valor= 150.0

    deals.add(
        deal
    )
    deals.add(
        deal
    )
    deals.add(
        deal
    )


    val beanToCsv: StatefulBeanToCsv<Deal> = StatefulBeanToCsvBuilder<Deal>(writer).build();

    beanToCsv.write(deals);

    writer.flush();
    writer.close();
}

