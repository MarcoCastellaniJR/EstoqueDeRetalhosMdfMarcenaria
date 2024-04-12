package Integrator.client.model;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ImportCsv {



    public ImportCsv() throws IOException {
        String csvFile = "caminho/do/arquivo";

        try(CSVReader reader = new CSVReader(new FileReader(csvFile))){
            String[] line;
            // Loop para ler todas as linhas do arquivos CSV
            while((line = reader.readNext()) != null){
                // processa cada linha do CSV
                for(String cell:line){
                    System.out.print(cell + "\t"); // realiza a ação com a linha
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
