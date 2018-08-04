public class MinStack {

    public static void main(String[] args) {
        MinStack _this = new MinStack();
        String[] input = "586 g t t g P 593848644 t p t t t t p P 680232627 P 383101258 P 240914318 g t t g g g p t P 213391515 p g p P 742850435 t t p P 140398572 t p P 223343895 g p P 781329724 p g P 957992928 g t p t g t p t t P 285167635 g g g g P 406164147 t P 758145620 p p p P 124285491 P 562495437 g t p P 944055491 p t P 52710853 p t P 300724037 t g t p p P 261181367 p t p t p g p P 878174480 g P 212362489 p p g p t p g t t t g t p p P 31729170 P 114379646 p g g g t t t g P 940773816 t t t t t p g t g t P 951862306 g P 881407410 P 353039583 P 878631052 t p p g g t P 463882617 p t g p t P 471748835 g p g g t g g t t g g g P 842420509 P 945537631 p g p p p t t t g p p P 731260864 p P 32317538 g g t t P 32484018 t t p g p P 804019134 t P 711633790 p P 800701823 g p p t P 407672563 p t g P 224962756 g g p p g P 574232670 t p p p t P 701785843 g P 444445859 g P 47850275 p t g P 501076238 g t t t g p g t p p t g p g P 309787254 t P 869566183 P 71770367 p t P 464272346 g g p P 397900315 g t t p p p g t t P 937096341 p P 436863539 t t P 542632465 P 781555871 p p t p P 254349373 P 178643603 g g P 178735710 P 52131937 g P 952629390 p P 350915931 g P 228975548 P 263688213 t p t g t P 676902702 t t P 63194601 g g P 19217890 P 596393544 p g t p t g p g P 508824208 P 36903639 p t p P 719030567 t p P 719389474 P 479824726 p p t p p g t P 725153581 P 541171427 P 103507999 p P 277436428 g t p t g t t t P 701795326 t t p t p p g p P 324304199 p P 82265427 p g p t p g p g p p p P 525849167 P 696013291 P 753175403 p p P 870235711 t g g p g p p t p g P 974721906 P 531365097 P 501145234 t p t g g t p t P 137243011 g p P 34998402 P 447313462 p p P 603194026 t t t g t p g p g P 215762626 t P 151859662 P 409772254 p p t t g g t p p P 517631790 g t g P 359027788 p p g t t P 66861044 p p t t g t P 230291592 P 681081810 t P 462993916 p g p P 100520658 p g t P 192955504 t P 651898157 g t P 357537677 g P 764119050 P 843021351 p g P 661902663 g g P 350513129 P 818846798 P 675467354 t g g t p P 393353030 t p g g P 538842245 t t g P 464133893 p t t p g p p t t p p g g P 812231214 p g P 809370817 p P 49863929 p P 133917999 g P 98397249 p p t p g t p P 565077104 t P 500269843 P 337772871 t g P 648755277 t g g g P 945760233 g t P 195829325 t p g g g g g t p g t t P 279641729 p g p p t g t t t t p p P 623929613 t t p p t P 404667209 t t p t p t p P 360716847 t g t g p p p g P 596790133 p g p g P 997831569 t t g t g t g P 619805999 g p t p g p g t P 272317483 P 830076034 t g g t g P 962873120".split(" ");
        int counter = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(input[0]); i++) {
            switch (input[counter++]) {
                case "P":
                    _this.push(Integer.parseInt(input[counter++]));
                    break;
                case "p":
                    _this.pop();
                    break;
                case "t":
                    sb.append(_this.top());
                    sb.append(" ");
                    break;
                case "g":
                    sb.append(_this.getMin());
                    sb.append(" ");
                    break;
            }

        }
        System.out.println(sb.toString());
    }

    private Node last = null;

    public void push(int x) {
        Node newNode = new Node(x, last != null ? Math.min(last.minValue, x) : x);
        newNode.prev = last;
        last = newNode;
    }

    public void pop() {
        if (last != null) {
            last = last.prev;
        }
    }

    public int top() {
        return last != null ? last.value : -1;
    }

    public int getMin() {
        return last != null ? last.minValue : -1;
    }

    public class Node {
        int value;
        int minValue;
        Node prev;

        public Node(int value, int minValue) {
            this.value = value;
            this.minValue = minValue;
        }
    }
}
