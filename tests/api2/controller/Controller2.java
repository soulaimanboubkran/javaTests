package tests.api2.controller;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Controller2 {
    public static long timeMs(){
        return System.currentTimeMillis();
    }
    public static Date dateNow(){
        return new Date();
    }
 
     public static long temps_milisecond() {
    return System.currentTimeMillis();
  }

  public static Date aujourdhui_1() {
    return new Date();
  }

  public static Date aujourdhui_2() {
    return new Date(temps_milisecond());
  }

  public static String format_mm_dd_yyyy(Date d) {
    return new SimpleDateFormat("MM/dd/yyyy").format(d);
  }

  public static String format_dd_mm_yyyy(Date d) {
    return new SimpleDateFormat("dd/MM/yyyy").format(d);
  }

  public static String format_dd_mmmm_yyyy(Date d) {
    return new SimpleDateFormat("dd/MMMM/yyyy").format(d);
  }

  public static String format_dddd_mmm_yyyy(Date d) {
    return new SimpleDateFormat("EEEE dd MMM yyyy").format(d);
  }

  public static void afifcher_info_date() {
    Calendar calendrier = Calendar.getInstance();
    System.out.println("Jour : " + calendrier.get(Calendar.DAY_OF_MONTH));
    System.out.println("Mois : " + calendrier.get(Calendar.MONTH));
    System.out.println("Année : " + calendrier.get(Calendar.YEAR));
  }

  public static String conversion_fr(double montant) {
    return DecimalFormat.getInstance(Locale.FRANCE).format(montant);
  }

  public static String conversion_us(double montant) {
    return DecimalFormat.getInstance(Locale.US).format(montant);
  }

  public static String argent_euro(double montant) {
    return DecimalFormat.getCurrencyInstance(Locale.FRANCE).format(montant);
  }

  public static String argent_dollard_us(double montant) {
    return DecimalFormat.getCurrencyInstance(Locale.US).format(montant);
  }

  public static String argent_dollard_canada(double montant) {
    return DecimalFormat.getCurrencyInstance(Locale.CANADA_FRENCH).format(montant);
  }

  public static String argent_livre_sterlin(double montant) {
    return DecimalFormat.getCurrencyInstance(Locale.UK).format(montant);
  }
}
