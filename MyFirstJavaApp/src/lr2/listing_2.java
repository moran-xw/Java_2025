package lr2;

public class listing_2 {

    public static String getEncryptString(String encryptString, int shift) {
        // преобразуем переданную в метод строку в символьный массив
        char[] arrayChar = encryptString.toCharArray();
        // создаем массив с типом данных long, размер массива равен размеру символьного массива
        long[] arrayInt = new long[arrayChar.length];
        // создаем символьный массив, в который будем записывать преобразованные символы
        char[] arrayCharNew = new char[arrayChar.length];
        // в цикле перебираем все символы из переданной строки, прибавляем к ним число-ключ (сдвиг)
        for (int i = 0; i < arrayChar.length; i++) {
            // прибавляем к символу с индексом i сдвиг
            arrayInt[i] = arrayChar[i] + shift;
            // преобразуем число в символ char и записываем его в новый массив
            arrayCharNew[i] = (char) arrayInt[i];
        }
        // преобразовываем новый массив символов в строку
        encryptString = new String(arrayCharNew);
        // возвращаем полученную строку
        return encryptString;
    }
}

