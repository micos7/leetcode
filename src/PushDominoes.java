public class PushDominoes {
    public String pushDominoes(String dominoes) {
        //https://leetcode.com/problems/push-dominoes/ 838
        char[] d = dominoes.toCharArray();
        int l = dominoes.length();
        int[] forces = new int[l];

        int force = 0;
        for (int i = 0; i < l; i++) {
            if (d[i] == 'R') {
                force = l;
            } else if (d[i] == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] += force;
        }

        force = 0;
        for (int i = l - 1; i >= 0; i--) {
            if (d[i] == 'L') {
                force = l;
            } else if (d[i] == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] -= force;
        }

        StringBuilder sb = new StringBuilder();

        for (Integer f : forces) {
            if (f > 0) {
                sb.append('R');
            } else if (f < 0) {
                sb.append('L');
            } else {
                sb.append('.');
            }
        }

        return sb.toString();
    }
}
