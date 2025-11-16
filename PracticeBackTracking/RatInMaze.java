// // Solution 1:Algorithm -1.Create a solution matrix, initially filled 
// // with 0’s.2.Createarecursivefunction,whichtakestheinitialmatrix,
// // outputmatrixandpositionof rat (i, j).3.if the position is out of the 
// // matrix or the position is not valid then return.4.
// // Markthepositionoutput[i][j]
// // as1andcheckifthecurrentpositionisdestinationornot. If destination is 
// // reached print the output matrix and return.5.Recursively call for 
// // position (i+1, j) and (i, j+1).6.Unmark position (i, j), i.e output[i]
// // [j] = 0.

// import java.util.*;

// public class RatInMaze {

//     static void printSolution(int[][] sol) {
//         int N = sol.length;

//         for(int i = 0; i < N; i++) {
//             for(intj = 0; j < N; j++) {
//                 System.out.print(sol[i][j] + " ");
//             }
//             System.out.println();
//         }
//         System.out.println();
//     }

//     // Check if cell is safe to move
//     static boolean isSafe(int[][] maze, int row, int col, boolean[][] visited) {
//         int N = maze.length;
//         return (row >= 0 && col >= 0 && row < N && col < N &&
//                 maze[row][col] == 1 && !visited[row][col]);
//     }

//     // Recursive backtracking to find all paths
//     static void findPaths(int[][] maze, int row, int col, boolean[][] visited, String path, List<String> paths) {
//         int N = maze.length;

//         // Destination reached
//         if (row == N - 1 && col == N - 1) {
//             // paths.add(path);
//             sol[row][col] = 1;
//             printSolution(sol);
//             sol[row][col] = 0;
//             return;
//         }

//         // Mark visited
//         visited[row][col] = true;
//         sol[row][col] = 1;

//         // Down
//         if (isSafe(maze, row + 1, col, visited))
//             // findPaths(maze, row + 1, col, visited, path + "D", paths);
//             findPaths(maze, row + 1, col, visited, sol);

//         // Up
//         if (isSafe(maze, row - 1, col, visited))
//             // findPaths(maze, row - 1, col, visited, path + "U", paths);
//             findPaths(maze, row - 1, col, visited, sol);

//         // Right
//         if (isSafe(maze, row, col + 1, visited))
//             // findPaths(maze, row, col + 1, visited, path + "R", paths);
//             findPaths(maze, row, col + 1, visited, sol);

//         // Left
//         if (isSafe(maze, row, col - 1, visited))
//             // findPaths(maze, row, col - 1, visited, path + "L", paths);
//             findPaths(maze, row, col - 1, visited, sol);

//         // Backtrack
//         visited[row][col] = false;
//         sol[row][col] = 0;
//     }

//     public static void main(String[] args) {
//         int[][] maze = {
//             {1, 0, 0, 0},
//             {1, 1, 0, 1},
//             {0, 1, 0, 0},
//             {1, 1, 1, 1}
//         };

//         int[][] sol = new int[N][N];
//         findPaths(maze, 0, 0, visited, sol);

//         int N = maze.length;
//         boolean[][] visited = new boolean[N][N];
//         List<String> paths = new ArrayList<>();

//         if (maze[0][0] == 1) {
//             findPaths(maze, 0, 0, visited, "", paths);
//         }

//         if (paths.isEmpty()) {
//             System.out.println("No path found");
//         } else {
//             System.out.println("Possible paths:");
//             for (String p : paths) {
//                 System.out.println(p);
//             }
//         }
//     }
// }


public class RatInMaze {
    public static void printSolution(int sol[][]) {
        for (int i = 0; i < sol.length; i++) {
            for(int j = 0; j < sol.length; j++) {
                System.out.print(" " + sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int maze[][], int x, int y) {
        // if (x, y) is outside maze return false

        return (x >= 0 && x < maze.length && y >= 0 && y < maze.length && maze[x][y] == 1);
    }

     public static boolean solveMaze(int maze[][]) {
        int N = maze.length;
        int sol[][] = new int[N][N];
        if(solveMazeUtil(maze, 0, 0, sol) == false) {
            System.out.println("Solution Doesn't exists");
            return false;
        }

        printSolution(sol);
        return true;
    }

    public static boolean solveMazeUtil(int maze[][], int x, int y, int sol[][]) {
        if (x == maze.length - 1 && y == maze.length - 1 && maze[x][y] == 1) {
            sol[x][y] = 1;
            return true;
        }

        // Check if maze [x][y] is valid

        if(isSafe(maze, x, y)  == true) {
            if(sol[x][y] == 1) 
                return false;
            sol[x][y] = 1;

            if(solveMazeUtil(maze, x + 1, y, sol))
                return true;
            if(solveMazeUtil(maze, x, y + 1, sol))
                return true;
            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    public static void main(String args[]) {
        int maze[][] = {
            {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };
        solveMaze(maze);
    }
}