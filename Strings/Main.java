package Strings;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {
    public static String SEPARATOR = "@";
    public static final String COLON = ":";
 
   

    public static String generatefinalPortfolios(String input) {
        	String st[] = input.split(COLON);
           
            ArrayList<Portfolio> holdings = getHoldings(st[0]);
            ArrayList<Benchmark> benchmark = getBenchmark(st[1]);
            
            ArrayList<finalPortfolio> ts = calculateValue(holdings,benchmark);
            String res = getStringfinalPortfolio(ts);
            return res;    
        }
    
    public    static String getStringfinalPortfolio(ArrayList<finalPortfolio> t) {
        	String res ="";
        	for(int i=0;i<t.size() ;i++){
        	res += "["+t.get(i).ticker+", "+t.get(i).name+", "+String.format("%.0f", t.get(i).qty)+", "+String.format("%.2f", t.get(i).price)+", "+ String.format("%.2f", t.get(i).value)+", "+String.format("%.2f", t.get(i).nav) +"], " ;
        	}
        	res = res.substring(0, res.length()-2); 
            return res;
           
    }
    
    public static ArrayList<finalPortfolio> calculateValue(ArrayList<Portfolio> holdings,ArrayList<Benchmark> benchmark) {
        	ArrayList<finalPortfolio> ts = new ArrayList<finalPortfolio>();
            float sum = 0;
        	for(int i=0;i<holdings.size() ;i++){
        		finalPortfolio t = new finalPortfolio();
                float value = holdings.get(i).qty * benchmark.get(i).price;
                sum = sum+value;
                t.ticker = holdings.get(i).ticker;
                t.name = holdings.get(i).name;
                t.price = benchmark.get(i).price;
        		t.qty =  holdings.get(i).qty;
        		t.value = value;
        		ts.add(t);
        	}
     
               for(int i=0;i<holdings.size() ;i++){
        		finalPortfolio t = new finalPortfolio();
                float nav = (ts.get(i).value/sum)*100;  
        		ts.get(i).nav =  nav;
        		
               }
             

            return ts;
        }

        
        
       
        
        static ArrayList<Portfolio> getHoldings(String portfolioString) {
        
            String st[] = portfolioString.split(SEPARATOR);
             Arrays.sort(st);
             ArrayList<Portfolio> pf = new ArrayList<Portfolio>();
              String res = "";
              for(int i = 0; i < st.length; i++)
            {
                 String[] newRes = (st[i].split(","));   
                 Portfolio p = new Portfolio();
                 p.name = newRes[1];
                 p.qty = Float.valueOf(newRes[2]);
                 p.ticker = newRes[0];
                 pf.add(p);
            }
            return pf;
        }


        static ArrayList<Benchmark> getBenchmark(String portfolioString) {
        
            String st[] = portfolioString.split(SEPARATOR);
             Arrays.sort(st);
             ArrayList<Benchmark> bm = new ArrayList<Benchmark>();
              String res = "";
              for(int i = 0; i < st.length; i++)
            {
                 String[] newRes = (st[i].split(","));   
                 Benchmark b = new Benchmark();
                 b.ticker = newRes[0];
                 b.name = newRes[1];
                 b.qty = Float.valueOf(newRes[2]);
                 b.price = Float.valueOf(newRes[3]);
                 bm.add(b);
            }
            return bm;
        }
        
        
        public static class Portfolio {
            String name;
            String ticker;
            float qty;
            
        }

        public static class Benchmark{
            String ticker;
            float qty;
            String name;
            float price;

            
        }

       public static class finalPortfolio {
            String ticker;
            float qty;
            String name;
            float price;
            float value;
            float nav;
       }
    public static void main(String[] args) throws IOException{
        
        String res;
        String _input = "RIO,RIO TINTO PLC,746@AAL,ANGLO AMERICAN PLC,271:RIO,RIO TINTO PLC,688,13.9@AAL,ANGLO AMERICAN PLC,293,49.7";
       
        res = generatefinalPortfolios(_input);
        System.out.println(res);
    }
}