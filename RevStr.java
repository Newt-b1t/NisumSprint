public class RevStr {
    public static void main(String[] args) {
        String s = "I am Avinash Rath";
        StringBuffer sb = new StringBuffer(s);
        sb.reverse();
        System.out.println("Reversed String: " + sb);
    }
}