public class VideoStitching {
    public int videoStitching(int[][] clips, int time) {
        int count = 0, start = 0, end = 0;

        while (start < time) {
            for (int[] clip : clips) {
                if (start >= clip[0]) {
                    end = Math.max(end, clip[1]);
                }
            }

            if (start == end) {
                return -1;
            }

            count++;
            start = end;
        }

        return count;
    }
}
