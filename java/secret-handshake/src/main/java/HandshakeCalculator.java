import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

class HandshakeCalculator {

    List<Signal> calculateHandshake(int number) {

        String binario = Integer.toBinaryString(number);

        while (binario.length() < 5) {
            binario = "0" + binario;
        }

        if (binario.length() > 5){
            binario = binario.substring(binario.length() - 5);
        }

        List<Signal> signals = getSignals(binario);

        if(binario.charAt(0) == '1'){
            Collections.reverse(signals);
        }


        return signals;

    }

    private static List<Signal> getSignals(String binario) {
        List<Signal> signals = new ArrayList<Signal>();

        if(binario.charAt(4) == '1'){
            Signal signal = Signal.WINK;
            signals.add(signal);
        }

        if(binario.charAt(3) == '1'){
            Signal signal = Signal.DOUBLE_BLINK;
            signals.add(signal);
        }

        if(binario.charAt(2) == '1'){
            Signal signal = Signal.CLOSE_YOUR_EYES;
            signals.add(signal);
        }

        if(binario.charAt(1) == '1'){
            Signal signal = Signal.JUMP;
            signals.add(signal);
        }
        return signals;
    }

}
