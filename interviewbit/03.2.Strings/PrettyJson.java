import java.util.ArrayList;


public class PrettyJson {

    public static void main(String[] args) {
        ArrayList<String> result = new PrettyJson().prettyJSON("A : \"{\"attributes\":[{\"nm\":\"ACCOUNT\",\"lv\":[{\"v\":{\"Id\":null,\"State\":null},\"vt\":\"java.util.Map\",\"cn\":1}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":13585},{\"nm\":\"PROFILE\",\"lv\":[{\"v\":{\"Party\":null,\"Ads\":null},\"vt\":\"java.util.Map\",\"cn\":2}],\"vt\":\"java.util.Map\",\"status\":\"SUCCESS\",\"lmd\":41962}]}\"");
        for (String str : result) {
            System.out.println(str);
        }
    }


    public ArrayList<String> prettyJSON(String A) {
        ArrayList<String> result = new ArrayList<>();


        StringBuilder sb = new StringBuilder();
        StringBuilder tabs = new StringBuilder();

        for (char c : A.toCharArray()) {
            if (c == '{' || c == '[') {
                if (sb.length() > 0) {
                    if (!sb.toString().trim().equals(""))
                        result.add(tabs.toString() + sb.toString().trim());
                    sb = new StringBuilder();
                }

                result.add(tabs.toString() + c);
                tabs.append('\t');
                continue;
            }
            if (c == ',') {
                if (!sb.toString().trim().equals("")) {
                    result.add(tabs.toString() + sb.toString().trim() + c);
                    sb = new StringBuilder();
                } else {
                    String prevResult = result.get(result.size() - 1);
                    result.set(result.size() - 1, prevResult + c);
                }
                continue;
            }

            if (c == '}' || c == ']') {
                if (sb.length() > 0) {
                    if (!sb.toString().trim().equals(""))
                        result.add(tabs.toString() + sb.toString().trim());
                    sb = new StringBuilder();
                }

            } else {
                sb.append(c);
            }
            if (c == '}' || c == ']') {
                tabs.deleteCharAt(tabs.length() - 1);
                result.add(tabs.toString() + c);
            }
        }
        return result;

    }
}
