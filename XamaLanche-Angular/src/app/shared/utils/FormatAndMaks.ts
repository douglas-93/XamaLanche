export class FormatAndMaks {
    static formatPhoneNumber(input: string): string {
        // Remove todos os caracteres não numéricos
        const cleanedInput = input.replace(/\D/g, '');

        // Verifica se é um número de celular (começa com 9) ou um número de telefone (começa com DDD)
        const isCellphone = cleanedInput.length === 11;
        const ddd = cleanedInput.substring(0, 2);
        const rest = cleanedInput.substring(2);

        // Formata o número com base no tipo (celular ou telefone)
        const formattedNumber = isCellphone
            ? `(${ddd}) ${rest.substring(0, 5)}-${rest.substring(5)}`
            : `(${ddd}) ${rest.substring(0, 4)}-${rest.substring(4)}`;

        return formattedNumber;
    }
}
