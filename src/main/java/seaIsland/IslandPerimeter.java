package seaIsland;

public class IslandPerimeter {

    private int perimeter;

    IslandPerimeter(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {

                if (map[i][j] == 1) {

                    // Left
                    if (j - 1 == -1 || map[i][j - 1] == 0)
                        perimeter++;

                    // Right
                    if (j + 1 == map[0].length || map[i][j + 1] == 0)
                        perimeter++;

                    // Top
                    if (i - 1 == -1 || map[i - 1][j] == 0)
                        perimeter++;

                    // Bottom
                    if (i + 1 == map.length || map[i + 1][j] == 0)
                        perimeter++;
                }
            }
        }
    }

    public double getPerimeter() {
        return perimeter;
    }

}
