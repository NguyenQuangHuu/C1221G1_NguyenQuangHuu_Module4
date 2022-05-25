package vn.codegym.utils;

import java.util.regex.Pattern;

public class RegEx {

    private static final String VIE_NAME = "^(\\s?[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ0-9]\\s?)*$";

    private static final String POSITIVE_NUMBER = "[+]?\\d+";

    private static final String POSITIVE_TENS_NUMBER = "[+]?\\d*\\.?\\d*";

    private  static final String CODE_CUSTOMER = "KH-\\d{4}";

    private static final String SERVICE_CODE = "DV-\\d{4}";

    private static final String PHONE_NUMBER = "((\\(84\\)\\+(90))|(\\(84\\)\\+(91))|(090)|(091))\\d{7}";

    private static final String PASSPORT = "^\\d{9}|\\d{12}$";

    private static final String EMAIL_VALIDATE = "([a-z]\\w+@[a-z]{2,}\\.)\\w{2,10}(\\.\\w{2,3})?";

    private static final String DATE_VALIDATE = "^([012]\\d|[3][0-1])/([0]\\d|[1][0-2])/((19)(\\d){2}|(20)(([01]\\d)|[2][0-2]))$";

    public static boolean codeCustomerCheck(String input){
        return Pattern.matches(CODE_CUSTOMER,input);
    }

    public static boolean serviceCode(String input){
        return Pattern.matches(SERVICE_CODE,input);
    }

    public static boolean phoneNumberValidate(String input){
        return Pattern.matches(PHONE_NUMBER,input);
    }

    public static boolean passportValidate(String input){
        return Pattern.matches(PASSPORT,input);
    }

    public static boolean emailValidate(String input){
        return Pattern.matches(EMAIL_VALIDATE,input);
    }

    public static boolean dateValidate(String input){
        return Pattern.matches(DATE_VALIDATE,input);
    }


    public static boolean numberPositive(String input){
        return Pattern.matches(POSITIVE_NUMBER,input);
    }

    public static boolean numberTensPositive(String input){
        return Pattern.matches(POSITIVE_TENS_NUMBER,input);
    }

    public static boolean nameCheck(String input){
        return Pattern.matches(VIE_NAME,input);
    }
}
