import java.util.Random;

public class ScrollArtV1 {
    static final int WIDTH = getTerminalWidth() - 1;
    static final int YEPPI_WIDTH = 34;
    static final int YEPPI_HEIGHT = 32;
    static final Random rand = new Random();

    public static void main(String[] args) throws InterruptedException {
        char[][] nextRows = new char[YEPPI_HEIGHT][WIDTH]; // store upcoming rows
        for (int i = 0; i < nextRows.length; i++) {
            nextRows[i] = emptyRow();
        }

        while (true) {
            for (int x = 0; x < WIDTH - YEPPI_WIDTH; x++) {
                if (rand.nextDouble() < 0.0005) {
                    char[][] img;
                     if (rand.nextDouble() < 0.5)
                         img = getYeppi();
                     else {
                    img = getFlower();
                     }
                    for (int iy = 0; iy < YEPPI_HEIGHT; iy++) {
                        for (int ix = 0; ix < YEPPI_HEIGHT; ix++) {
                            nextRows[iy][x + ix] = img[iy][ix];
                        }
                    }
                }
            }

            // Print and remove the top row
            System.out.println(new String(nextRows[0]));
            // Shift all rows up
            shiftRowsUp(nextRows);
            Thread.sleep(40); // Delay in ms
        }
    }

    static void shiftRowsUp(char[][] nextRows) {
        for (int i = 1; i < nextRows.length; i++) {
            nextRows[i - 1] = nextRows[i];
        }
        nextRows[nextRows.length - 1] = emptyRow();
    }

    static char[] emptyRow() {
        char[] row = new char[WIDTH];
        for (int i = 0; i < WIDTH; i++) {
            row[i] = ' ';
        }
        return row;
    }

    // rename your function here
    static char[][] getYeppi() {
        char[][] img = new char[YEPPI_HEIGHT][YEPPI_WIDTH];
        // fill with empty space
        for (int y = 0; y < YEPPI_HEIGHT; y++) {
            for (int x = 0; x < YEPPI_WIDTH; x++) {
                img[y][x] = ' ';
            }
        }
        // then fill individual characters
        img[0][1] = '.'; 
        img[0][2] = '_'; 
        img[0][3] = '_'; 
        img[0][25] = '.'; 
        img[0][26] = '^'; 
        img[0][27] = '^';

        img[1][1] = '/'; 
        img[1][2] = '"'; 
        img[1][5] = '"'; 
        img[1][6] = ';'; 
        img[1][25] = '|'; 
        img[1][29] = '"'; 
        img[1][30] = ')'; 

        img[2][0] = '.'; 
        img[2][7] = '\\'; 
        img[2][24] = '/'; 
        img[2][25] = '"'; 
        img[2][28] = 'X';
        img[2][30] = '?';

        img[3][0] = '|'; 
        img[3][1] = '"'; 
        img[3][3] = 'X'; 
        img[3][7] = '\\'; 
        img[3][22] = '/'; 
        img[3][26] = 'X'; 
        img[3][27] = 'X';
        img[3][30] = '|';
        img[4][0] = '\\'; 
        img[4][2] = 'X'; 
        img[4][3] = 'X'; 
        img[4][4] = 'X'; 
        img[4][5] = '.'; 
        img[4][8] = '\\'; 
        img[4][9] = '+'; 
        img[4][10] = '-'; 
        img[4][11] = '_'; 
        img[4][12] = '.'; 
        img[4][13] = '_'; 
        img[4][14] = '.'; 
        img[4][15] = '+'; 
        img[4][16] = '-'; 
        img[4][17] = '.'; 
        img[4][18] = '.'; 
        img[4][19] = '-'; 
        img[4][20] = '#'; 
        img[4][21] = '/'; 
        img[4][22] = '-'; 
        img[4][25] = 'X'; 
        img[4][26] = 'X'; 
        img[4][27] = 'X'; 
        img[4][28] = 'X'; 
        img[4][31] = ')';

        img[5][0] = '\''; 
        img[5][3] = '%'; 
        img[5][4] = '$'; 
        img[5][25] = '*'; 
        img[5][26] = '-'; 
        img[5][27] = '-'; 
        img[5][28] = '_'; 
        img[5][31] = '.';

        img[6][0] = '\\'; 
        img[6][32] = '|'; 
        
        img[7][0] = '.'; 
        img[7][1] = '|'; 
        img[7][6] = '_'; 
        img[7][7] = '_'; 
        img[7][23] = '_'; 
        img[7][24] = '_';
        img[7][25] = '_';
        img[7][32] = '\\';

        img[8][0] = '|';
        img[8][1] = '"'; 
        img[8][5] = '*'; 
        img[8][6] = '#'; 
        img[8][7] = '#'; 
        img[8][8] = '#'; 
        img[8][9] = 'x'; 
        img[8][10] = '*'; 
        img[8][22] = '#'; 
        img[8][23] = 'x'; 
        img[8][24] = '#';
        img[8][25] = '#';
        img[8][27] = '\\';
        img[8][33] = ':';

        img[9][0] = '\\'; 
        img[9][4] = '('; 
        img[9][6] = '#'; 
        img[9][7] = '#'; 
        img[9][8] = '#'; 
        img[9][9] = 'x'; 
        img[9][10] = '@';
        img[9][21] = 'x';
        img[9][22] = '#';
        img[9][23] = '#';
        img[9][24] = '#';
        img[9][25] = '#';
        img[9][33] = '|';

        img[10][0] = '\''; 
        img[10][1] = '.'; 
        img[10][15] = '_'; 
        img[10][16] = '.'; 
        img[10][17] = '.'; 
        img[10][18] = '_'; 
        img[10][32] = ')'; 
        img[10][33] = ':'; 

        img[11][1] = '\''; 
        img[11][2] = '.'; 
        img[11][14] = '\\'; 
        img[11][15] = '='; 
        img[11][18] = '='; 
        img[11][19] = '/'; 
        img[11][32] = '/'; 

        img[12][2] = '\\'; 
        img[12][15] = '^'; 
        img[12][16] = '^'; 
        img[12][31] = '.'; 
        
        img[13][3] = '+'; 
        img[13][16] = '/'; 
        img[13][17] = '\\'; 
        img[13][30] = '?'; 
        img[13][31] = '"'; 
        
        img[14][4] = '"'; 
        img[14][13] = '*'; 
        img[14][14] = '-'; 
        img[14][15] = '"'; 
        img[14][18] = '"'; 
        img[14][19] = '-'; 
        img[14][20] = '*'; 
        img[14][28] = '/';
        img[14][29] = '"';
        
        img[15][8] = '"'; 
        img[15][9] = '+'; 
        img[15][10] = '=';
        img[15][11] = '.';
        img[15][12] = '_'; 
        img[15][13] = '_';
        img[15][14] = '_';
        img[15][15] = '\\';
        img[15][16] = '_';
        img[15][17] = '_';
        img[15][18] = '/';
        img[15][19] = '.';
        img[15][20] = '_';
        img[15][21] = '_';
        img[15][22] = '.';
        img[15][23] = '-';
        img[15][24] = '-';
        img[15][25] = '=';
        img[15][26] = '=';
        img[15][27] = '"';
        return img;
    }

    static char[][] getFlower() {
        char[][] img = new char[YEPPI_HEIGHT][YEPPI_WIDTH];
        // fill with empty space
        for (int y = 0; y < YEPPI_HEIGHT; y++) {
            for (int x = 0; x < YEPPI_WIDTH; x++) {
                img[y][x] = ' ';
            }
        }
        // then fill individual characters
        img[2][0] = '|';
        img[3][0] = '"';
        img[7][0] = '/';
        img[8][0] = '~';

        img[1][1] = '.';
        img[2][1] = '"';
        img[3][1] = '|';
        img[4][1] = '"';
        img[6][1] = '.';
        img[7][1] = '.';
        img[8][1] = '.';
        img[9][1] = '\\';

        img[1][2] = '-';
        img[4][2] = '.';
        img[6][2] = '|';
        img[8][2] = '-';
        img[10][2] = '"';

        img[1][3] = '"';
        img[5][3] = '7';
        img[6][3] = '"';
        img[10][3] = '-';

        img[0][4] = '_';
        img[10][4] = '.';

        img[0][5] = '.';
        img[10][5] = '_';

        img[0][6] = '_';
        img[10][6] = '-';

        img[0][7] = '_';
        img[1][7] = '"';
        img[10][7] = '.';

        img[1][8] = '@';
        img[2][8] = '"';
        img[8][8] = '.';
        img[9][8] = '-';
        img[10][8] = '/';

        img[1][9] = '.';
        img[2][9] = '|';
        img[3][9] = '.';
        img[7][9] = '.';
        img[8][9] = '|';
        img[9][9] = '"';
        img[10][9] = '"';

        img[2][10] = '/';
        img[5][10] = '0';
        img[8][10] = '\\';

        img[1][11] = '_';
        img[9][11] = '"';

        img[1][12] = ':';
        img[9][12] = '.';
        img[10][12] = '"';

        img[1][13] = '"';
        img[10][13] = '-';

        img[0][14] = '_';
        img[10][14] = '.';

        img[0][15] = '_';
        img[10][15] = '_';

        img[0][16] = '.';
        img[10][16] = '_';

        img[0][17] = '_';
        img[3][17] = '"';
        img[10][17] = '.';

        img[1][18] = '"';
        img[2][18] = '/';
        img[3][18] = '~';
        img[6][18] = '.';
        img[7][18] = '"';
        img[8][18] = '.';
        img[9][18] = '/';
        img[10][18] = '\'';

        img[1][19] = '.';
        img[3][19] = '-';
        img[6][19] = '-';
        img[7][19] = '-';
        img[8][19] = '|';

        img[3][20] = '.';
        img[6][20] = '"';

        img[3][21] = '_';
        img[5][21] = '_';

        img[3][22] = '_';
        img[5][22] = '/';

        img[4][23] = '|';
        img[5][23] = '"';

        return img;
    }

    public static int getTerminalWidth() {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            return getUnixTerminalWidth();
        } else {
            return 80; // fallback for unknown OS
        }
    }

    private static int getUnixTerminalWidth() {
        try {
            // Try to get terminal size from environment variables first
            String columns = System.getenv("COLUMNS");
            if (columns != null && !columns.isEmpty()) {
                return Integer.parseInt(columns);
            }

            // Fallback to stty command
            ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c", "stty size </dev/tty");
            pb.redirectErrorStream(true);
            Process process = pb.start();
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()));
            String output = reader.readLine();
            if (output != null && !output.isEmpty()) {
                String[] parts = output.trim().split(" ");
                return Integer.parseInt(parts[1]); // columns
            }
        } catch (Exception ignored) {
            // Silently ignore errors and fall back to default
        }
        return 80; // fallback
    }

}