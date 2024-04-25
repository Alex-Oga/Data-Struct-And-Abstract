public class Roman {

    public static int romanToInt(String romanNum) {
        int current = 0;
        int sum = 0;
        char[] arrayChar = romanNum.toCharArray();

        for (int i = arrayChar.length - 1; i >= 0; i--) {
            switch (arrayChar[i]) {
                case 'I':
                    if (current == 0) {
                        sum += 1;
                    } else {
                        if (current == 1) {
                            sum += 1;
                        } else {
                            sum -= 1;
                        }
                    }
                    current = 1;
                    break;
                case 'V':
                    if (current == 0) {
                        sum += 5;
                    }
                    else {
                        if (current <= 5) {
                            sum += 5;
                        }
                        else {
                            sum -= 5;
                        }
                    }
                    current = 5;
                    break;
                case 'X':
                    if (current == 0) {
                        sum += 10;
                    }
                    else {
                        if (current <= 10) {
                            sum += 10;
                        }
                        else {
                            sum -= 10;
                        }
                    }
                    current = 10;
                    break;
                case 'L':
                    if (current == 0) {
                        sum += 50;
                    }
                    else {
                        if (current <= 50) {
                            sum += 50;
                        }
                        else {
                            sum -= 50;
                        }
                    }
                    current = 50;
                    break;
                case 'C':
                    if (current == 0) {
                        sum += 100;
                    }
                    else {
                        if (current <= 100) {
                            sum += 100;
                        }
                        else {
                            sum -= 100;
                        }
                    }
                    current = 100;
                    break;
                case 'D':
                    if (current == 0) {
                        sum += 500;
                    }
                    else {
                        if (current <= 500) {
                            sum += 500;
                        }
                        else {
                            sum -= 500;
                        }
                    }
                    current = 500;
                    break;
                case 'M':
                    if (current == 0) {
                        sum += 1000;
                    }
                    else {
                        if (current <= 1000) {
                            sum += 1000;
                        }
                        else {
                            sum -= 1000;
                        }
                    }
                    current = 1000;
            }
        }
        return sum;
    }
}
