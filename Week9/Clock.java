/* *****************************************************************************
Clock.java that represents time on a 24-hour clock, such as 00:00, 13:30, or 23:59.
Time is measured in hours (00–23) and minutes (00–59).
Two-argument constructor. Throw an IllegalArgumentException if either integer argument is outside its prescribed bounds (hours between 0 and 23, minutes between 0 and 59).
One-argument constructor. The string argument is composed of two digits, followed by a colon, followed by two digits, such as 09:45. Throw an IllegalArgumentException if either the string argument is not in this format or if it does not correspond to a valid time between 00:00 and 23:59.
String representation. The format is the hours (2 digits), followed by a colon, followed by the minutes (2 digits). Two examples are 00:00 and 23:59.
Ordering. Times are ordered from 00:00 (earliest) to 23:59 (latest).
Tic. Add one minute to the current time. For example, one minute after 06:00 is 06:01; one minute after 23:59 is 00:00.
Toc. Add Δ minutes to the current time. For example, 60 minutes after 12:34 is 13:34. Throw an IllegalArgumentException if Δ is negative.
Test client. The main() method must call each instance method directly and help verify that they work as prescribed.
Performance. All instance methods must take constant time.
 **************************************************************************** */

public class Clock {
    private int hour;
    private int min;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        hour = h;
        min = m;
        if (hour < 0 || hour > 23)
            throw new IllegalArgumentException("hour must be between 0 and 23");
        if (min < 0 || min > 59)
            throw new IllegalArgumentException("min must be between 0 and 59");
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {

        if (s.length() != 5 || s.charAt(2) != ':' || s.charAt(0) < 48 || s.charAt(0) > 57
                || s.charAt(1) < 48 || s.charAt(1) > 57 || s.charAt(3) < 48 || s.charAt(3) > 57
                || s.charAt(4) < 48 || s.charAt(4) > 57)
            throw new IllegalArgumentException(
                    "time format should be in form two digits, followed by a colon, followed by two digits");
        hour = Integer.parseInt(s.substring(0, 2));
        min = Integer.parseInt(s.substring(3, 5));

        if (hour < 0 || hour > 23)
            throw new IllegalArgumentException("hour must be between 0 and 23");
        if (min < 0 || min > 59)
            throw new IllegalArgumentException("min must be between 0 and 59");


    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String h = "" + hour;
        String m = "" + min;
        if (hour < 10)
            h = "0" + h;
        if (min < 10)
            m = "0" + m;
        return h + ":" + m;
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        if (hour < that.hour)
            return true;
        else if (hour == that.hour) {
            if (min < that.min)
                return true;
        }
        return false;
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        if (min < 59)
            min++;
        else {
            min = 0;
            if (hour < 23)
                hour++;
            else {
                hour = 0;
            }
        }
    }

    // Adds Δ minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0)
            throw new IllegalArgumentException("delta must be positive");
        int hourinc = 0;
        if (delta > 1440)
            delta = delta % 1440;
        if (delta > 59) {
            hourinc = delta / 60;
            delta = delta % 60;
        }

        hour = hour + hourinc;
        min = min + delta;

        if (min > 59) {
            min = min % 60;
            hour++;
        }
        if (hour > 23) {
            hour = hour % 24;
        }
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock c = new Clock(14, 59);
        Clock c2 = new Clock("05:59");
        System.out.println(c.toString());
        System.out.println(c2.toString());
        System.out.println(c.isEarlierThan(c2));
        c.tic();
        c2.toc(480);
        System.out.println(c.toString());
        System.out.println(c2.toString());
        System.out.println(c.isEarlierThan(c2));
        Clock c3 = new Clock("02:5");

    }
}
