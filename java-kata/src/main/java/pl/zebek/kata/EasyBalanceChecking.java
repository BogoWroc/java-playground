package pl.zebek.kata;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class EasyBalanceChecking {

    public static double fetchValue(String row){
        String [] arr = row.split(" ");
        String v = arr[arr.length-1];
        return Double.parseDouble(v);
    }

    public static String formatRow(String row){
        String [] arr = row.split(" ");
        return Arrays.stream(arr).filter(it -> !it.isEmpty()).collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        String b1 = "1665.00\n" +
                "001 Gasoline ;! 120.30 ?;\n" +
                "002 Stamps  17.50 \n" +
                "003 Picture ;! 24.81 ?;\n" +
                "004 Music ;! 128.00 ?;\n" +
                "005 Grocery ;! 24.81 ?;\n" +
                "006 Hardware  17.60 \n" +
                "007 Gasoline ;! 12.00 ?;\n" +
                "008 Car  13.65 ";

        String [] arr = b1.split("\n");
        List<String> clearRows = Arrays.stream(arr).map(it -> it.replaceAll("[^A-Za-z0-9/.\\s]", "")).filter(it-> it.length()!=0).collect(Collectors.toList());
        clearRows = clearRows.stream().map(EasyBalanceChecking::formatRow).collect(Collectors.toList());

        DoubleSummaryStatistics doubleSummaryStatistics = clearRows.stream().filter(it-> it.split(" ").length >1).mapToDouble(EasyBalanceChecking::fetchValue).summaryStatistics();

        StringBuffer buf = new StringBuffer();
        Double balance = Double.valueOf(clearRows.get(0));
        buf.append(String.format("Original Balance: %.2f\\r\\n", balance));
        for(int i=1; i< clearRows.size(); i++){
            String row = clearRows.get(i);
            Double current = fetchValue(row);
            balance = balance - current;
            buf.append(String.format("%s Balance %.2f\\r\\n", row,balance));
        }
        buf.append(String.format("Total expense  %.2f\\r\\n", doubleSummaryStatistics.getSum()));
        buf.append(String.format("Average expense  %.2f", doubleSummaryStatistics.getAverage()));


        System.out.println(buf.toString());
    }

}
