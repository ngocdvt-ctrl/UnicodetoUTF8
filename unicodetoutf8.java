public class unicodetoutf8 {

    /**
     * Unicodeコードポイント（0x800 ～ 0xFFFF）を
     * UTF-8（3バイト形式）にエンコードする
     */
    public static int[] encode(int codePoint) {
        int[] utf8Bytes = {224, 128, 128}; // 1110xxxx 10xxxxxx 10xxxxxx
        int cp = codePoint;

        // 下位ビットから順に6ビットずつ各バイトへ割り当てる
        for (int i = utf8Bytes.length - 1; i >= 0; i--) {
            utf8Bytes[i] += cp % 64;
            cp = cp / 64;
        }

        return utf8Bytes;
    }

    /**
     * 1バイトの値を8ビットの2進数文字列として表示する
     */
    private static String toBinary8(int value) {
        return String.format("%8s", Integer.toBinaryString(value))
                .replace(' ', '0');
    }

    public static void main(String[] args) {
        int codePoint = 0x3042; // 「あ」

        int[] result = encode(codePoint);

        System.out.println("UTF-8 (HEX):");
        for (int b : result) {
            System.out.printf("%02X ", b);
        }

        System.out.println("\n\nUTF-8 (BINARY):");
        for (int b : result) {
            System.out.println(toBinary8(b));
        }
    }
}