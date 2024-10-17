import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ledger {

    private static final Map<String, Map<String, CurrencySettings>> settings = new HashMap<>();

    static {
        // Configurações para USD
        Map<String, CurrencySettings> usdSettings = new HashMap<>();
        usdSettings.put("en-US", new CurrencySettings("$", "MM/dd/yyyy", ".", ",", "Date       | Description               | Change       "));
        usdSettings.put("nl-NL", new CurrencySettings("$", "dd/MM/yyyy", ",", ".", "Datum      | Omschrijving              | Verandering  "));
        settings.put("USD", usdSettings);

        // Configurações para EUR
        Map<String, CurrencySettings> eurSettings = new HashMap<>();
        eurSettings.put("en-US", new CurrencySettings("€", "MM/dd/yyyy", ".", ",", "Date       | Description               | Change       "));
        eurSettings.put("nl-NL", new CurrencySettings("€", "dd/MM/yyyy", ",", ".", "Datum      | Omschrijving              | Verandering  "));
        settings.put("EUR", eurSettings);
    }

    public LedgerEntry createLedgerEntry(String localDate, String description, int change) {
        LedgerEntry ledgerEntry = new LedgerEntry();
        ledgerEntry.setChange(change);
        ledgerEntry.setDescription(description);
        ledgerEntry.setLocalDate(LocalDate.parse(localDate));
        return ledgerEntry;
    }

    public String format(String cur, String loc, LedgerEntry[] entries) {

        if (isValidCurrency(cur)) {
            throw new IllegalArgumentException("Invalid currency");
        }

        if (isValidLocale(loc)) {
            throw new IllegalArgumentException("Invalid locale");
        }

        CurrencySettings settings = getCurrencySettings(cur, loc);
        if (settings == null) {
            throw new IllegalArgumentException("Settings not found for currency and locale");
        }

        StringBuilder s = new StringBuilder(settings.header);



        if (entries.length > 0) {
            List<LedgerEntry> neg = new ArrayList<>();
            List<LedgerEntry> pos = new ArrayList<>();

            for (LedgerEntry e : entries) {
                if (e.getChange() >= 0) {
                    pos.add(e);
                } else {
                    neg.add(e);
                }
            }

            neg.sort((o1, o2) -> o1.getLocalDate().compareTo(o2.getLocalDate()));
            pos.sort((o1, o2) -> o1.getLocalDate().compareTo(o2.getLocalDate()));

            List<LedgerEntry> all = new ArrayList<>();
            all.addAll(neg);
            all.addAll(pos);

            for (LedgerEntry e : all) {
                String date = e.getLocalDate().format(DateTimeFormatter.ofPattern(settings.datPat));
                String desc = e.getDescription();
                if (desc.length() > 25) {
                    desc = desc.substring(0, 22) + "...";
                }

                String converted = String.format("%.02f", Math.abs(e.getChange() / 100.0));
                String[] parts = converted.split("\\.");
                String amount = formatAmount(parts[0], parts[1], settings.decSep, settings.thSep, e.getChange(), settings.curSymb, loc);

                s.append("\n")
                        .append(String.format("%s | %-25s | %13s", date, desc, amount));
            }
        }

        return s.toString();
    }

    private String formatAmount(String whole, String fraction, String decSep, String thSep, double change, String curSymb, String loc) {
        StringBuilder amount = new StringBuilder();
        int count = 0;

        for (int ind = whole.length() - 1; ind >= 0; ind--) {
            if (count > 0 && count % 3 == 0) {
                amount.insert(0, thSep);
            }
            amount.insert(0, whole.charAt(ind));
            count++;
        }

        amount.append(decSep).append(fraction);

        if (loc.equals("nl-NL")) {
            if (change < 0) {
                return curSymb + " -" + amount.toString() + " "; // Para nl-NL negativos
            } else {
                return curSymb + " " + amount.toString() + " "; // Para nl-NL positivos
            }
        }

        // Remover o espaço após o símbolo da moeda
        String formattedAmount = curSymb + amount.toString();

        if (change < 0) {
            if (loc.equals("en-US")) {
                return "(" + formattedAmount + ")";
            } else {
                return formattedAmount.replace(curSymb, "").trim() + " -"; // Mantenha o formato para o locale nl-NL
            }
        } else {
            return formattedAmount + " "; // Adicione o espaço no final
        }
    }




    private CurrencySettings getCurrencySettings(String cur, String loc) {
        return settings.getOrDefault(cur, new HashMap<>()).get(loc);
    }

    private boolean isValidCurrency(String cur) {
        return !cur.equals("USD") && !cur.equals("EUR");
    }

    private boolean isValidLocale(String loc) {
        return !loc.equals("en-US") && !loc.equals("nl-NL");
    }

    public static class LedgerEntry {
        LocalDate localDate;
        String description;
        double change;

        public LocalDate getLocalDate() {
            return localDate;
        }

        public void setLocalDate(LocalDate localDate) {
            this.localDate = localDate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getChange() {
            return change;
        }

        public void setChange(double change) {
            this.change = change;
        }
    }

    private static class CurrencySettings {
        String curSymb;
        String datPat;
        String decSep;
        String thSep;
        String header;

        CurrencySettings(String curSymb, String datPat, String decSep, String thSep, String header) {
            this.curSymb = curSymb;
            this.datPat = datPat;
            this.decSep = decSep;
            this.thSep = thSep;
            this.header = header;
        }
    }

}
