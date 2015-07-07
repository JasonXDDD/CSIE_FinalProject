package Public_Class;

/**
 * Created by JASON_ on 2015/7/4.
 */
public class OpenFile_Test {
    public static void main (String args[]) {
        try {
            Runtime r1 = Runtime.getRuntime ();
            Process proc = r1.exec ("cmd.exe /c"+ "start C:\\");
//            int e1 = proc.exitValue ();
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

}
