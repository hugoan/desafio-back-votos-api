package br.com.cooperativa.desafiobackvotos.api.Utils;

import org.springframework.util.StringUtils;

import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class MaskUtils {

    public static String maskCPF(String value) {
        if (StringUtils.isEmpty(value)) return value;
        try {
            var formatter = new MaskFormatter("###.###.###-##");
            formatter.setValueContainsLiteralCharacters(false);
            return formatter.valueToString(value);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String unmask(String value) {
        if (StringUtils.isEmpty(value)) return value;
        return value.replaceAll("\\D+", "");
    }
}
