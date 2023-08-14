package com.dmm.xamalanche.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionMetodsUtils {

    /** Verifica se uma lista é vazia */
    public static <T> boolean isEmpty(Collection<T> input) {
        return input == null || input.isEmpty();
    }

    /** Verifica se uma lista NÃO é vazia */
    public static <T> boolean isNotEmpty(Collection<T> input) {
        return !isEmpty(input);
    }

    /** Verifica se um Objeto NÃO é Null */
    public static boolean isNotObjectEmpty(Object entity) {
        return entity != null;
    }

    /** Verifica se um campo do tipo String é null ou " "(Vazio) */
    public static boolean isStringEmpty(String string) {
        return string == null || string == "";
    }

    /**
    * Metodo em teste
    * Devera retornar somente os dados diferentes entre as duas listas
     */
    public static <T> List<T> difference(List<T> lista1, List<T> lista2){
        List<T> diferentes = new ArrayList<>(lista1);

        diferentes.addAll(lista2);
        diferentes.removeAll(lista1);
        diferentes.removeAll(lista2);

        return diferentes;
    }

}
