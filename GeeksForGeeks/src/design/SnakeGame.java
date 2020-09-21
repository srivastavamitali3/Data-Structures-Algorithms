package design;

public class SnakeGame {
    class SnakePart {
        public int row;
        public int col;
        public SnakePart next;

        public SnakePart(int row, int col) {
            this.row = row;
            this.col = col;
            this.next = null;
        }
    }

    int[][] food;
    int foodCount;
    int width;
    int height;
    SnakePart head;
    SnakePart tail;
    int score;

    public SnakeGame(int width, int height, int[][] food) {
        this.food = food;
        this.foodCount = 0;
        this.width = width;
        this.height = height;
        this.head = new SnakePart(0, 0);
        this.tail = new SnakePart(-1, -1);
        this.tail.next = head;
        this.score = 0;
    }

    public int move(String direction) {
        // update coordinates first
        SnakePart tmp = this.tail.next;
        int tailRow = tmp.row;
        int tailCol = tmp.col;
        while (tmp != this.head) {
            tmp.row = tmp.next.row;
            tmp.col = tmp.next.col;
            tmp = tmp.next;
        }
        if (direction.equals("U")) {
            tmp.row = tmp.row - 1;
        } else if (direction.equals("L")) {
            tmp.col = tmp.col - 1;
        } else if (direction.equals("R")) {
            tmp.col = tmp.col + 1;
        } else if (direction.equals("D")) {
            tmp.row = tmp.row + 1;
        }
        // hit boundary or body ?
        if (tmp.row < 0 || tmp.row >= height || tmp.col < 0 || tmp.col >= width) {
            return -1;
        }
        SnakePart t = this.tail.next;
        while (t != this.head) {// check if head collide with the body
            if (t.row == tmp.row && t.col == tmp.col) {
                return -1;
            }
            t = t.next;
        }
        // get food ?
        if (foodCount < food.length && food[foodCount][0] == tmp.row && food[foodCount][1] == tmp.col) {
            SnakePart newPart = new SnakePart(tailRow, tailCol);
            newPart.next = this.tail.next;
            this.tail.next = newPart;
            this.score++;
            this.foodCount++;
        }
        return this.score;
    }
}
/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */