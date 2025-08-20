package home.thienph.xyahoo.data.networks;

public final class ByteBuffer {
    private byte[] buffer;
    private int length;
    private int position;

    public ByteBuffer() {
        this.buffer = new byte[32];
        this.position = 0;
    }

    public ByteBuffer(byte[] byArray) {
        this.buffer = byArray;
        this.position = 0;
        this.length = byArray.length;
    }

    public final void writeByte(byte by) {
        this.buffer[this.position++] = by;
        this.d();
    }

    private void d() {
        if (this.position > this.length) {
            this.length = this.position;
        }
    }

    public final void ensureCapacity(int n) {
        if ((n = this.position + n) > this.buffer.length) {
            byte[] byArray = new byte[n];
            System.arraycopy(this.buffer, 0, byArray, 0, this.length);
            this.buffer = byArray;
        }
    }

    public final void writeBytes(byte[] byArray, int n, int n2) {
        System.arraycopy(byArray, n, this.buffer, this.position, n2);
        this.position += n2;
        this.d();
    }

    public final byte readByte() {
        return this.buffer[this.position++];
    }

    public final byte[] readBytes(int n) {
        byte[] byArray = new byte[n];
        System.arraycopy(this.buffer, this.position, byArray, 0, n);
        this.position += n;
        return byArray;
    }

    public final byte[] getBuffer() {
        return this.buffer;
    }

    public final int getLength() {
        return this.length;
    }
}
