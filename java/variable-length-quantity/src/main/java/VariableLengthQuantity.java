import java.util.ArrayList;
import java.util.List;

class VariableLengthQuantity {

    List<String> encode(List<Long> numbers) {

        List<String> result = new ArrayList<>();

        for (Long number : numbers) {
            List<Byte> byteList = new ArrayList<>();

            do {
                byte byteValue = (byte) (number & 0x7F); // Pega os últimos 7 bits do número
                number >>>= 7; // Desloca o número 7 bits para a direita sem sinal

                if (!byteList.isEmpty()) {
                    byteValue |= 0x80; // Define o bit mais significativo para 1, se não for o último byte
                }

                byteList.add(0, byteValue); // Adiciona o byte no início da lista
            } while (number != 0);

            // Adiciona cada byte como uma string hexadecimal separada
            for (byte b : byteList) {
                result.add(String.format("0x%x", b));
            }
        }

        return result;
    }

    List<String> decode(List<Long> bytes) {
        List<String> numbers = new ArrayList<>();
        long currentNumber = 0;
        boolean hasMore = false;

        for (long byteValue : bytes) {
            currentNumber = (currentNumber << 7) | (byteValue & 0x7F); // Remove o bit de continuidade e adiciona os 7 bits

            if ((byteValue & 0x80) == 0) {
                // Se o bit de continuidade é 0, o número está completo
                numbers.add(String.format("0x%x", currentNumber));
                currentNumber = 0; // Reinicializa para o próximo número
                hasMore = false; // Reinicializa a flag
            } else {
                // Indica que há mais bytes para este número
                hasMore = true;
            }
        }

        if (hasMore) {
            throw new IllegalArgumentException("Invalid variable-length quantity encoding");
        }

        return numbers;
    }
}



