package br.com.pi.drot.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class DataDoDia {
    private static DataDoDia dataDoDiaFormatada;

    private DataDoDia() {
    }

    public static DataDoDia getInstance() {
        if(dataDoDiaFormatada == null) {
            dataDoDiaFormatada = new DataDoDia();
        }
        return dataDoDiaFormatada;
    }

    public String retornarDataDoDia() {
        SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendarDataAtual = Calendar.getInstance();
        String dataDoDia = "";
        dataDoDia= formatoData.format(calendarDataAtual.getTime());
        return dataDoDia;
    }
    
    public float diferencaEmDiasAteHoje(String dataInicio, int diasTratamento)  {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateInicioTratamentoFormatado = LocalDateTime.parse(dataInicio.concat(" 10:00:00"), formatter);

        float diff = dateInicioTratamentoFormatado.until(now, ChronoUnit.DAYS);
        
        System.out.println("diferenca das datas: " + diff);
        return diff < 0 ? 0:diff;
    }
}